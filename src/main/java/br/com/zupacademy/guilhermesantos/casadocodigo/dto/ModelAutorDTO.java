package br.com.zupacademy.guilhermesantos.casadocodigo.dto;

import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelAutor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ModelAutorDTO{

    @NotEmpty(message = "O Nome deve ser informado!")
    private String nome;

    @Column(unique = true)
    @Email(message = "E-mail Inválido!")
    @NotEmpty(message = "O E-mail deve ser informado!")
    private String email;

    @Size(max = 400, message = "A Descrição deve ter no máximo 400 Caracteres")
    @NotEmpty(message = "A Descrição deve ser informado!")
    private String descricao;

    public ModelAutorDTO(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public ModelAutor converteObjetoEntidade() {
        return new ModelAutor(this.nome, this.email, this.descricao);
    }

    public String getEmail() {
        return this.email;
    }
}