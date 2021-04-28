package br.com.zupacademy.guilhermesantos.casadocodigo.dto;

import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelLivro;

import java.math.BigDecimal;

public class LivroDetalheSiteDTO {

    private AutorDetalheSiteDTO autor;
    private AutorDetalheSiteDTO descricao;
    private String titulo;
    private BigDecimal preco;
    private String resumo;
    private String sumario;
    private String isbn;
    private int numero_pagina;

    public LivroDetalheSiteDTO(ModelLivro modelLivro){
        autor = new AutorDetalheSiteDTO(modelLivro.getAutor());
        titulo = modelLivro.getTitulo();
        preco = modelLivro.getPreco();
        resumo = modelLivro.getResumo();
        sumario = modelLivro.getSumario();
        isbn = modelLivro.getIsbn();
        numero_pagina = modelLivro.getNumero_pagina();
    }

    public AutorDetalheSiteDTO getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumero_pagina() {
        return numero_pagina;
    }
}

