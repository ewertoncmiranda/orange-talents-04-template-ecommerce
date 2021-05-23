package ewerton.zup.mercadolivre.usuario;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

@Entity
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String login ;

    private String senha ;

    @CreationTimestamp @PastOrPresent
    private LocalDateTime criadoEm ;

    public Usuario(  String login ,
                     String senha ){
        this.login = login ;
        this.senha = criptografaSenha(senha);
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    private String criptografaSenha(String senha){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-384");
            messageDigest.update(senha.getBytes(),0,senha.length());
            byte[] digest =  messageDigest.digest();
            senha = new BigInteger(1,digest).toString(16);
            return senha;
        }catch (NoSuchAlgorithmException e){
           e.printStackTrace();}
        return "ERRO NA CRIPTOGRAFIA DA SENHA!" ;

        }
}
