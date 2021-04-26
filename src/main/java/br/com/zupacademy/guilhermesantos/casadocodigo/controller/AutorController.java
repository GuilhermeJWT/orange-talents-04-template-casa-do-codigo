package br.com.zupacademy.guilhermesantos.casadocodigo.controller;

import br.com.zupacademy.guilhermesantos.casadocodigo.dto.ModelAutorDTO;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelAutor;
import br.com.zupacademy.guilhermesantos.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping(value = "/salvar")
    public ResponseEntity<ModelAutorDTO> salvarAutor(@RequestBody @Valid ModelAutorDTO modelAutorDTO){

        ModelAutor modelAutor = modelAutorDTO.converteObjetoEntidade();
        autorRepository.save(modelAutor);

        return new ResponseEntity<ModelAutorDTO>(HttpStatus.OK);

    }

}
