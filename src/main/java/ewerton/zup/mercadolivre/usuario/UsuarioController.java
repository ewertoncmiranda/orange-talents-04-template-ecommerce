package ewerton.zup.mercadolivre.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

   @Autowired
   UsuarioRepositorio repositorio;

    @PostMapping
    public ResponseEntity cadastrarNovoUsuario(@RequestBody @Valid  NovoUsuarioRequester novoUsuario){
        Usuario usuario = novoUsuario.toModel();
        repositorio.save(usuario);
        return ResponseEntity.ok().build();
    }
}
