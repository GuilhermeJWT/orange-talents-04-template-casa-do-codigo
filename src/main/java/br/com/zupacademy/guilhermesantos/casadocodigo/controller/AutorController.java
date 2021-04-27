package br.com.zupacademy.guilhermesantos.casadocodigo.controller;

import br.com.zupacademy.guilhermesantos.casadocodigo.dto.ModelAutorDTO;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelAutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/salvar")
    @Transactional
    public ResponseEntity<ModelAutorDTO> salvarAutor(@RequestBody @Valid ModelAutorDTO modelAutorDTO){

        ModelAutor modelAutor = modelAutorDTO.converteObjetoEntidade();
        manager.persist(modelAutor);

        return new ResponseEntity<ModelAutorDTO>(HttpStatus.OK);

    }

}
