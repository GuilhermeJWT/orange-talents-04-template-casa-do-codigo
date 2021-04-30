package br.com.zupacademy.guilhermesantos.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "cliente")
public class ModelClientes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email(message = "E-mail Inválido!")
    @NotEmpty(message = "O E-mail deve ser informado!")
    private String email;

    @NotEmpty(message = "O Nome deve ser informado!")
    private String nome;

    @NotEmpty(message = "O Sobrenome deve ser informado!")
    private String sobrenome;

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

    @ManyToOne(optional = false)
    private ModelEstado estado;

    @ManyToOne(optional = false)
    private ModelPais pais;

    public ModelClientes(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, String telefone, String cep, ModelEstado estado, ModelPais pais){
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.estado = estado;
        this.pais = pais;
    }

    @Deprecated
    public ModelClientes(){

    }

    public Long getId() {
        return id;
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

    public ModelEstado getEstado() {
        return estado;
    }

    public ModelPais getPais() {
        return pais;
    }
}
