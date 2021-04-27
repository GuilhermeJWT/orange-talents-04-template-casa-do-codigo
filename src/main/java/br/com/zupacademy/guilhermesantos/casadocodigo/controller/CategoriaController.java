package br.com.zupacademy.guilhermesantos.casadocodigo.controller;

import br.com.zupacademy.guilhermesantos.casadocodigo.dto.ModelCategoriaDTO;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelCategoria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/salvar")
    @Transactional
    public ResponseEntity<ModelCategoriaDTO> salvarCategoria (@RequestBody @Valid ModelCategoriaDTO modelCategoriaDTO){

        ModelCategoria modelCategoria = modelCategoriaDTO.converteObjetoEntidade();
        manager.persist(modelCategoria);

        return new ResponseEntity<ModelCategoriaDTO>(HttpStatus.OK);

    }
}

