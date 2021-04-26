package br.com.zupacademy.guilhermesantos.casadocodigo.model;

import br.com.zupacademy.guilhermesantos.casadocodigo.anotation.GenericUniqueColumn;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "livro")
public class ModelLivro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O Titulo deve ser informado!")
    @GenericUniqueColumn(domainClass = ModelLivro.class, fieldName = "titulo", message = "Titulo ja possui Cadastro! Informe outro")
    private String titulo;

    @NotEmpty(message = "O Resumo deve ser informado")
    @Size(max = 500, message = "O Resumo deve ter no máximo 500 caracteres!")
    private String resumo;

    @NotEmpty(message = "O Sumário deve ser informado!")
    private String sumario;

    @NotNull(message = "O Preço deve ser informado!")
    @Size(min = 20)
    private BigDecimal preco;

    @NotNull(message = "O Número de páginas deve ser informado!")
    @Size(min = 100)
    private Integer numero_pagina;

    @GenericUniqueColumn(domainClass = ModelLivro.class, fieldName = "isbn", message = "Isbn já possui Cadastro! Informe outro")
    @NotEmpty(message = "O Isbn deve ser informado!")
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate data_publicacao;

    //@OneToOne(optional = false)
    //@ForeignKey(name = "autor_fk")
    //private ModelAutor autor;

    //@OneToOne(optional = false)
    //@ForeignKey(name = "categoria_fk")
    //private ModelCategoria categoria;


    public ModelLivro(String titulo, String resumo, String sumario, BigDecimal preco, Integer numero_pagina, String isbn, LocalDate data_publicacao) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numero_pagina = numero_pagina;
        this.isbn = isbn;
        this.data_publicacao = data_publicacao;
    }
    @Deprecated
    public ModelLivro(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getNumero_pagina() {
        return numero_pagina;
    }

    public void setNumero_pagina(Integer numero_pagina) {
        this.numero_pagina = numero_pagina;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getData_publicacao() {
        return data_publicacao;
    }

    public void setData_publicacao(LocalDate data_publicacao) {
        this.data_publicacao = data_publicacao;
    }
}
