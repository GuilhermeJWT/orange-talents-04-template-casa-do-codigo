package br.com.zupacademy.guilhermesantos.casadocodigo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
@RequestMapping(value = "/estado")
public class EstadoController {

    @PersistenceContext
    private EntityManager manager;

}
