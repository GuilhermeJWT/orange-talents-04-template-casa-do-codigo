package br.com.zupacademy.guilhermesantos.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autor")
public class ModelAutor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O Nome deve ser informado!")
    private String nome;

    @Email(message = "E-mail Inválido!")
    @NotEmpty(message = "O E-mail deve ser informado!")
    private String email;

    @Size(max = 400, message = "A Descrição deve ter no máximo 400 Caracteres")
    @NotEmpty(message = "A Descrição deve ser informado!")
    private String descricao;

    @Column(nullable = false)
    private LocalDateTime dataRegistro = LocalDateTime.now();

    @OneToMany(mappedBy = "autor", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ModelLivro> livro = new ArrayList<ModelLivro>();

    public ModelAutor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    @Deprecated
    public ModelAutor(){

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public List<ModelLivro> getLivro() {
        return livro;
    }

}
