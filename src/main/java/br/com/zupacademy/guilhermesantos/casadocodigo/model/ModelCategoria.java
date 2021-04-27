package br.com.zupacademy.guilhermesantos.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria")
public class ModelCategoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O Nome da Categoria deve ser informado!")
    private String nome;

    @OneToMany(mappedBy = "categoria", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ModelLivro> livro = new ArrayList<ModelLivro>();

    public ModelCategoria(String nome){
        this.nome = nome;
    }

    @Deprecated
    public ModelCategoria(){

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<ModelLivro> getLivro() {
        return livro;
    }
}
