package br.com.zupacademy.guilhermesantos.casadocodigo.dto;

import br.com.zupacademy.guilhermesantos.casadocodigo.anotation.GenericUniqueColumn;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelPais;

import javax.validation.constraints.NotEmpty;

public class ModelPaisDTO {

    @GenericUniqueColumn(domainClass = ModelPais.class, fieldName = "nome", message = "Nome do Pais já possui Cadastro! Informe Outro")
    @NotEmpty(message = "O Nome do Pais deve ser informado!")
    private String nome;

    public ModelPais converteObjetoEntidade(){
        return new ModelPais(this.nome);
    }

    @Deprecated
    public ModelPaisDTO(){

    }

    public ModelPaisDTO(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
