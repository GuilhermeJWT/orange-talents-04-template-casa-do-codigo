package br.com.zupacademy.guilhermesantos.casadocodigo.dto;

import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelAutor;

public class AutorDetalheSiteDTO {

    private String nome;
    private String descricao;

    public AutorDetalheSiteDTO (ModelAutor modelAutor){
        nome = modelAutor.getNome();
        descricao = modelAutor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
