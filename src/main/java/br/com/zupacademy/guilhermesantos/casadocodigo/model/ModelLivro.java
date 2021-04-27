package br.com.zupacademy.guilhermesantos.casadocodigo.model;

import br.com.zupacademy.guilhermesantos.casadocodigo.anotation.GenericUniqueColumn;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "livro")
public class ModelLivro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    private int numero_pagina;

    @NotEmpty(message = "O Isbn deve ser informado!")
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @JsonIgnore
    @ManyToOne(optional = false)
    @ForeignKey(name = "autor_fk")
    private ModelAutor autor;

    @OneToOne(optional = false)
    @ForeignKey(name = "categoria_fk")
    private ModelCategoria categoria;


    public ModelLivro(String titulo, String resumo, String sumario, BigDecimal preco, int numero_pagina, String isbn, LocalDate dataPublicacao) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numero_pagina = numero_pagina;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
    }
    @Deprecated
    public ModelLivro(){

    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
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

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public ModelAutor getAutor() {
        return autor;
    }

    public ModelCategoria getCategoria() {
        return categoria;
    }
}
