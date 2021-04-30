package br.com.zupacademy.guilhermesantos.casadocodigo.exception;

import br.com.zupacademy.guilhermesantos.casadocodigo.anotation.ValidEstadoExistPais;
import br.com.zupacademy.guilhermesantos.casadocodigo.dto.ModelEstadoDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GenericEstadoExistValidator implements ConstraintValidator<ValidEstadoExistPais, ModelEstadoDTO> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(ValidEstadoExistPais constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ModelEstadoDTO value, ConstraintValidatorContext context) {

        Query query = manager.createQuery("select 1 from ModelEstado e where e.estado =:nome and e.pais.id =:paisId");
        query.setParameter("nome", value.getEstado());
        query.setParameter("paisId", value.getPaisId());

        return query.getResultList().isEmpty();

    }
}
