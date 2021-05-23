package ewerton.zup.mercadolivre.usuario;


import ewerton.zup.mercadolivre.validacao.UsuarioUnico;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoUsuarioRequester {

    @Deprecated
    public NovoUsuarioRequester(){};

    @NotBlank @Email @UsuarioUnico
    private String login ;

    @NotBlank @NotNull @Length(min = 6) private String senha ;

    public String getLogin() {return login; }

    public String getSenha() {return senha; }

    public Usuario toModel() {
    return new Usuario(login,senha) ;
    }
}
