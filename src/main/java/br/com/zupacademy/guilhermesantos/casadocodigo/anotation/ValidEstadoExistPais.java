package br.com.zupacademy.guilhermesantos.casadocodigo.anotation;

import br.com.zupacademy.guilhermesantos.casadocodigo.exception.GenericEstadoExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = {GenericEstadoExistValidator.class})
public @interface ValidEstadoExistPais {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();

}
