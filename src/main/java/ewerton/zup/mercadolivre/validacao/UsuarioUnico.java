package ewerton.zup.mercadolivre.validacao;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ValorUnicoValidador.class})
public @interface UsuarioUnico {

    String message() default "Usuario já existe no sistema!" ;
    Class<?> []groups() default {};
    Class<? extends Payload>[] payload() default {};
}
