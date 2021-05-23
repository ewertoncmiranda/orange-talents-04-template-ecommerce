package ewerton.zup.mercadolivre.compartilhado.erro;

public class ErrorResponse {

    private String campo ;
    private String mensagem ;

    public ErrorResponse(String campo , String mensagem){
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
