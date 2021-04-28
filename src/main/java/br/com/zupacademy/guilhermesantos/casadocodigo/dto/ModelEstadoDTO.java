package br.com.zupacademy.guilhermesantos.casadocodigo.dto;

import br.com.zupacademy.guilhermesantos.casadocodigo.anotation.GenericUniqueColumn;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelEstado;

import javax.validation.constraints.NotEmpty;

public class ModelEstadoDTO {

    @GenericUniqueColumn(domainClass = ModelEstado.class, fieldName = "estado", message = "Nome do Estado já possui Cadastro! Informe Outro")
    @NotEmpty(message = "O Nome do Estado deve ser informado!")
    private String estado;

    public ModelEstado converteObjetoEntidade(){
        return new ModelEstado(this.estado);
    }

    public ModelEstadoDTO(String estado){
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}
