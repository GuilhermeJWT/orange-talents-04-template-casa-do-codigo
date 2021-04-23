package br.com.zupacademy.guilhermesantos.casadocodigo.exception;

import br.com.zupacademy.guilhermesantos.casadocodigo.dto.ModelAutorDTO;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelAutor;
import br.com.zupacademy.guilhermesantos.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class UniqueEmailException implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return ModelAutorDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if(errors.hasErrors()){
            return;
        }

        ModelAutorDTO dto = (ModelAutorDTO) target;
        Optional<ModelAutor> modelAutor =  autorRepository.findByEmail(dto.getEmail());

        if (modelAutor.isPresent()){
            errors.rejectValue("email", null, "E-mail já Existente!, Cadastre outro!");
        }

    }
}
