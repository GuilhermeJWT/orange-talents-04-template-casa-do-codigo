package br.com.zupacademy.guilhermesantos.casadocodigo.dto;
import br.com.zupacademy.guilhermesantos.casadocodigo.anotation.GenericUniqueColumn;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelCategoria;

import javax.validation.constraints.NotEmpty;

public class ModelCategoriaDTO {

    @GenericUniqueColumn(domainClass = ModelCategoria.class, fieldName = "nome", message = "Nome já possui Cadastro! Informe Outro")
    @NotEmpty(message = "O Nome da Categoria deve ser informado!")
    private String nome;

    public ModelCategoria converteObjetoEntidade() {
        return new ModelCategoria(this.nome);
    }

    public ModelCategoriaDTO(String nome){
        this.nome = nome;
    }

    @Deprecated
    public ModelCategoriaDTO (){

    }

    public String getNome() {
        return nome;
    }
}
