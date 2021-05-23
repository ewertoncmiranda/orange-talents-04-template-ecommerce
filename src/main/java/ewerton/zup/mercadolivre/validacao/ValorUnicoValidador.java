package ewerton.zup.mercadolivre.validacao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValorUnicoValidador implements ConstraintValidator <UsuarioUnico,Object>{

    @PersistenceContext
    EntityManager entityManager ;

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context){
        Query query = entityManager.createQuery
                ("SELECT 1 FROM Usuario u WHERE u.login = :valor ");
        query.setParameter("valor", value);
        return query.getResultList().isEmpty();
    }
}
