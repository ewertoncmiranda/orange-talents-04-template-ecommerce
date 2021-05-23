package ewerton.zup.mercadolivre.compartilhado.erro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GeneralHandlerError {

    @Autowired
    MessageSource messageSource ;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ErrorResponse> handlerMethodNotArgumentNotValid
                                         (MethodArgumentNotValidException exception){
        List<FieldError> listaDeFieldErrors =  exception.getBindingResult().getFieldErrors();
        List<ErrorResponse>  listaDeErrorResponses = new ArrayList<>() ;
        listaDeFieldErrors.forEach( error ->{
            String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            ErrorResponse errorResponse = new ErrorResponse(error.getField() ,mensagem);
            listaDeErrorResponses.add(errorResponse);
        });
        return listaDeErrorResponses;
    }


}

