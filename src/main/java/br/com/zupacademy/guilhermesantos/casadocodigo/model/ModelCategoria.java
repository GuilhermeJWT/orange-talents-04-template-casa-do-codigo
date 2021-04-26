package br.com.zupacademy.guilhermesantos.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "categoria")
public class ModelCategoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O Nome da Categoria deve ser informado!")
    private String nome;

    //@OneToOne(mappedBy = "categoria", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //private ModelLivro livro;

    public ModelCategoria(String nome){
        this.nome = nome;
    }

    @Deprecated
    public ModelCategoria(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
