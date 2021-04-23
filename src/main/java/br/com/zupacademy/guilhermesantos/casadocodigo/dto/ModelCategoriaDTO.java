package br.com.zupacademy.guilhermesantos.casadocodigo.dto;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelCategoria;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

public class ModelCategoriaDTO {

    @Column(unique = true)
    @NotEmpty(message = "O Nome da Categoria deve ser informado!")
    private String nome;

    public ModelCategoria converteObjetoEntidade() {
        return new ModelCategoria(this.nome);
    }

    @Deprecated
    public ModelCategoriaDTO(){

    }

    public ModelCategoriaDTO(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
