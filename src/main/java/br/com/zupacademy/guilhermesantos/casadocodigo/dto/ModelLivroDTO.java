package br.com.zupacademy.guilhermesantos.casadocodigo.dto;

import br.com.zupacademy.guilhermesantos.casadocodigo.anotation.GenericUniqueColumn;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelAutor;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelCategoria;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelLivro;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ModelLivroDTO {

    @NotEmpty(message = "O Titulo deve ser informado!")
    @GenericUniqueColumn(domainClass = ModelLivro.class, fieldName = "titulo", message = "Titulo ja possui Cadastro! Informe outro")
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

    @GenericUniqueColumn(domainClass = ModelLivro.class, fieldName = "isbn", message = "Isbn já possui Cadastro! Informe outro")
    @NotEmpty(message = "O Isbn deve ser informado!")
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    //private ModelAutor autor;

    //private ModelCategoria categoria;

    public ModelLivroDTO(String titulo, String resumo, String sumario, BigDecimal preco, int numero_pagina, String isbn, LocalDate dataPublicacao) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numero_pagina = numero_pagina;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
    }

    public ModelLivro converteObjetoEntidade(){
        return new ModelLivro(
                this.titulo,
                this.resumo,
                this.sumario,
                this.preco,
                this.numero_pagina,
                this.isbn,
                this.dataPublicacao);
    }

    public void setData_publicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

}
