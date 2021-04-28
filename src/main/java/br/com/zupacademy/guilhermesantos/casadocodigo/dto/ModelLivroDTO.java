package br.com.zupacademy.guilhermesantos.casadocodigo.dto;

import br.com.zupacademy.guilhermesantos.casadocodigo.anotation.GenericUniqueColumn;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelAutor;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelCategoria;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelLivro;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ModelLivroDTO {

    @NotEmpty(message = "O Titulo deve ser informado!")
    private String titulo;

    @NotEmpty(message = "O Resumo deve ser informado")
    @Size(max = 500, message = "O Resumo deve ter no máximo 500 caracteres!")
    private String resumo;

    @NotEmpty(message = "O Sumário deve ser informado!")
    private String sumario;

    @NotNull(message = "O Preço deve ser informado!")
    @Min(value = 20, message = "O Valor do livro deve ser mais que R$ 20.00")
    private BigDecimal preco;

    @NotNull(message = "O Número de páginas deve ser informado!")
    @Min(value = 100, message = "O Livro deve ter mais de 100 páginas!")
    private int numero_pagina;

    @NotEmpty(message = "O Isbn deve ser informado!")
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    private Long autorId;

    private Long categoriaId;

    public ModelLivroDTO(String titulo, String resumo, String sumario, BigDecimal preco, int numero_pagina, String isbn, LocalDate dataPublicacao, Long autorId, Long categoriaId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numero_pagina = numero_pagina;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autorId = autorId;
        this.categoriaId = categoriaId;
    }

    public ModelLivro converteObjetoEntidade(EntityManager manager){

        ModelAutor autor = manager.find(ModelAutor.class, this.autorId);
        ModelCategoria categoria = manager.find(ModelCategoria.class, this.categoriaId);

        return new ModelLivro(titulo, resumo, sumario, preco, numero_pagina, isbn, dataPublicacao, autor,categoria);
    }

    public ModelLivroDTO(){

    }

    public void setData_publicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public void setAutor(Long autor) {
        this.autorId = autor;
    }

    public void setCategoria(Long categoria) {
        this.categoriaId = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getNumero_pagina() {
        return numero_pagina;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getAutor() {
        return autorId;
    }

    public Long getCategoria() {
        return categoriaId;
    }
}
