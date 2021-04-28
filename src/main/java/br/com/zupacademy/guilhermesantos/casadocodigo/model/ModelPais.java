package br.com.zupacademy.guilhermesantos.casadocodigo.model;

import br.com.zupacademy.guilhermesantos.casadocodigo.anotation.GenericUniqueColumn;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pais")
public class ModelPais implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O Nome do Pais deve ser informado!")
    private String nome;

    @OneToMany(mappedBy = "pais", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ModelEstado> estado = new ArrayList<ModelEstado>();

    public ModelPais(String nome){
        this.nome = nome;
    }

    @Deprecated
    public ModelPais(){

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<ModelEstado> getEstado() {
        return estado;
    }
}
