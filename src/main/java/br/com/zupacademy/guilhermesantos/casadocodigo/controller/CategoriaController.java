package br.com.zupacademy.guilhermesantos.casadocodigo.controller;

import br.com.zupacademy.guilhermesantos.casadocodigo.dto.ModelCategoriaDTO;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelCategoria;
import br.com.zupacademy.guilhermesantos.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping(value = "/salvar")
    public ResponseEntity<ModelCategoriaDTO> salvarCategoria (@RequestBody @Valid ModelCategoriaDTO modelCategoriaDTO){

        ModelCategoria modelCategoria = modelCategoriaDTO.converteObjetoEntidade();
        categoriaRepository.save(modelCategoria);

        return new ResponseEntity<ModelCategoriaDTO>(HttpStatus.OK);

    }
}

