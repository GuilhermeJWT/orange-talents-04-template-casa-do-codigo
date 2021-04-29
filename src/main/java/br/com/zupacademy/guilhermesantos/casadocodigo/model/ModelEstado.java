package br.com.zupacademy.guilhermesantos.casadocodigo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "estado")
public class ModelEstado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O Nome do Estado deve ser informado!")
    private String estado;

    @JsonIgnore
    @ManyToOne(optional = false)
    @ForeignKey(name = "pais_id")
    private ModelPais pais;

    public ModelEstado(String estado, ModelPais pais){
        this.estado = estado;
        this.pais = pais;
    }

    @Deprecated
    public ModelEstado(){

    }

    public void setPais(ModelPais pais) {
        this.pais = pais;
    }

    public ModelPais getPais() {
        return pais;
    }

    public Long getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

}
