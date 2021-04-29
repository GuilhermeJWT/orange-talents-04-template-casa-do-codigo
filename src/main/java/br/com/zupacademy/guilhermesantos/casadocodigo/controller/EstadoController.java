package br.com.zupacademy.guilhermesantos.casadocodigo.controller;

import br.com.zupacademy.guilhermesantos.casadocodigo.dto.ModelEstadoDTO;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelEstado;
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
@RequestMapping(value = "/estado")
public class EstadoController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/salvar")
    @Transactional
    public ResponseEntity<ModelEstadoDTO> salvaEstado (@RequestBody @Valid ModelEstadoDTO modelEstadoDTO){

        ModelEstado modelEstado = modelEstadoDTO.converteObjetoEntidade(manager);
        manager.persist(modelEstado);

        return new ResponseEntity<ModelEstadoDTO>(HttpStatus.OK);

    }

}
