package br.com.zupacademy.guilhermesantos.casadocodigo.controller;

import br.com.zupacademy.guilhermesantos.casadocodigo.dto.ModelClienteDTO;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelClientes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/salvar")
    @Transactional
    public Long salvaCliente(@RequestBody @Valid ModelClienteDTO modelClienteDTO){

        ModelClientes modelClientes = modelClienteDTO.converteObjetoEntidade(manager);
        manager.persist(modelClientes);

        return modelClientes.getId();

    }

}
