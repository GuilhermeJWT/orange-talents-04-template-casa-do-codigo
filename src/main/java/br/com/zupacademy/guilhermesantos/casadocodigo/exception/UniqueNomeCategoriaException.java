package br.com.zupacademy.guilhermesantos.casadocodigo.exception;

import br.com.zupacademy.guilhermesantos.casadocodigo.dto.ModelCategoriaDTO;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelCategoria;
import br.com.zupacademy.guilhermesantos.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class UniqueNomeCategoriaException implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return ModelCategoriaDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if(errors.hasErrors()){
            return;
        }

        ModelCategoriaDTO dto = (ModelCategoriaDTO) target;
        Optional<ModelCategoria> modelCategoria =  categoriaRepository.findByNome(dto.getNome());

        if (modelCategoria.isPresent()){
            errors.rejectValue("nome", null, "Nome Categoria já Existente!, Cadastre outra!");
        }

    }

}
