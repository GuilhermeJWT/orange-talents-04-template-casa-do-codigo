package br.com.zupacademy.guilhermesantos.casadocodigo.controller;

import br.com.zupacademy.guilhermesantos.casadocodigo.dto.ModelPaisDTO;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelPais;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/pais")
public class PaisController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/salvar")
    @Transactional
    public ResponseEntity<ModelPaisDTO> salvarPais(@RequestBody @Valid ModelPaisDTO modelPaisDTO){

        ModelPais modelPais = modelPaisDTO.converteObjetoEntidade();
        manager.persist(modelPais);

        return new ResponseEntity<ModelPaisDTO>(HttpStatus.OK);

    }

}
