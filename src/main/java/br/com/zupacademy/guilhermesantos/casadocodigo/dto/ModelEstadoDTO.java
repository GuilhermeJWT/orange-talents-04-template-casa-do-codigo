package br.com.zupacademy.guilhermesantos.casadocodigo.dto;

import br.com.zupacademy.guilhermesantos.casadocodigo.anotation.GenericUniqueColumn;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelEstado;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelPais;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ModelEstadoDTO {

    @GenericUniqueColumn(domainClass = ModelEstado.class, fieldName = "estado", message = "Nome do Estado já possui Cadastro! Informe Outro")
    @NotEmpty(message = "O Nome do Estado deve ser informado!")
    private String estado;

    @GenericUniqueColumn(domainClass = ModelEstado.class, fieldName = "pais_id", message = "Pais já cadastrado! Informe Outro")
    @NotNull(message = "O Pais deve ser informado!")
    private Long paisId;

    public ModelEstadoDTO(String estado, Long paisId){
        this.estado = estado;
        this.paisId = paisId;
    }

    public ModelEstado converteObjetoEntidade(EntityManager manager){

        ModelPais pais = manager.find(ModelPais.class, paisId);

        return new ModelEstado(estado, pais);
    }

    public ModelEstadoDTO(){

    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }

    public Long getPaisId() {
        return paisId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
