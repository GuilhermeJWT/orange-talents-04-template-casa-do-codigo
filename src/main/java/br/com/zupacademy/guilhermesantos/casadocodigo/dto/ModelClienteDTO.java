package br.com.zupacademy.guilhermesantos.casadocodigo.dto;

import br.com.zupacademy.guilhermesantos.casadocodigo.anotation.GenericUniqueColumn;
import br.com.zupacademy.guilhermesantos.casadocodigo.anotation.ValidDocumentCpfCnpj;
import br.com.zupacademy.guilhermesantos.casadocodigo.anotation.ValidEstadoExistPais;
import br.com.zupacademy.guilhermesantos.casadocodigo.anotation.ValidIdExistent;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelClientes;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelEstado;
import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelPais;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ModelClienteDTO {

    @GenericUniqueColumn(domainClass = ModelClientes.class, fieldName = "email", message = "E-mail já possui Cadastro! Informe Outro")
    @Email(message = "E-mail Inválido!")
    @NotEmpty(message = "O E-mail deve ser informado!")
    private String email;

    @NotEmpty(message = "O Nome deve ser informado!")
    private String nome;

    @NotEmpty(message = "O Sobrenome deve ser informado!")
    private String sobrenome;

    @NotEmpty(message = "O Documento deve ser informado!")
    @ValidDocumentCpfCnpj(domainClass = ModelClientes.class, fieldName = "documento", message = "O Documento (Cpf | Cnpj) devem ser Válidos para o cadastro!")
    @GenericUniqueColumn(domainClass = ModelClientes.class, fieldName = "documento", message = "O Documento já possui Cadastro! informe outro")
    private String documento;

    @NotEmpty(message = "O Endereço deve ser informado!")
    private String endereco;

    @NotEmpty(message = "O Complemento deve ser informado!")
    private String complemento;

    @NotEmpty(message = "A Cidade deve ser informada!")
    private String cidade;

    @NotEmpty(message = "O Telefone deve ser informado!")
    private String telefone;

    @NotEmpty(message = "O Cep deve ser informado!")
    private String cep;

    private Long estadoId;

    @ValidIdExistent(domainClass = ModelPais.class, fieldName = "id", message = "Pais Inexistente! informe outro")
    @NotNull(message = "O Pais deve ser informado!")
    private Long paisId;

    public ModelClientes converteObjetoEntidade(EntityManager manager){

        ModelEstado estado = manager.find(ModelEstado.class, estadoId);
        ModelPais pais = manager.find(ModelPais.class, paisId);

        return new ModelClientes(email, nome, sobrenome, documento, endereco, complemento, cidade, telefone, cep, estado, pais);

    }

    public ModelClienteDTO(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, String telefone, String cep, Long estadoId, Long paisId){
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.estadoId = estadoId;
        this.paisId = paisId;
    }

    public ModelClienteDTO(){

    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }
}
