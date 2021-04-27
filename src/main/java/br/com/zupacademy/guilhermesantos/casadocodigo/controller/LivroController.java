package br.com.zupacademy.guilhermesantos.casadocodigo.controller;

import br.com.zupacademy.guilhermesantos.casadocodigo.dto.ModelLivroDTO;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelLivro;
import br.com.zupacademy.guilhermesantos.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping(value = "/salvar")
    public ResponseEntity<ModelLivroDTO> salvarLivro(@RequestBody @Valid ModelLivroDTO modelLivroDTO){

        ModelLivro modelLivro = modelLivroDTO.converteObjetoEntidade();
        livroRepository.save(modelLivro);

        return new ResponseEntity<ModelLivroDTO>(HttpStatus.OK);
    }

}
