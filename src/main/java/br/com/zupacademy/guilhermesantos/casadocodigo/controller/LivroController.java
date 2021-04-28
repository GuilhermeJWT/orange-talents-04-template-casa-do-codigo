package br.com.zupacademy.guilhermesantos.casadocodigo.controller;

import br.com.zupacademy.guilhermesantos.casadocodigo.dto.LivroDetalheDTO;
import br.com.zupacademy.guilhermesantos.casadocodigo.dto.ModelLivroDTO;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelLivro;
import br.com.zupacademy.guilhermesantos.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/salvar")
    @Transactional
    public ResponseEntity<ModelLivroDTO> salvarLivro(@RequestBody @Valid ModelLivroDTO modelLivroDTO){

        ModelLivro modelLivro = modelLivroDTO.converteObjetoEntidade(manager);
        manager.persist(modelLivro);

        return new ResponseEntity<ModelLivroDTO>(HttpStatus.OK);
    }

    @GetMapping(value = "/pesquisar/{id}")
    public Page<LivroDetalheDTO> listaLivrosCadastrados(Pageable paginaLivros){

    Page<ModelLivro> modelLivros = livroRepository.findAll(paginaLivros);

    return LivroDetalheDTO.converteObjetoEntidade(modelLivros);

    }

}
