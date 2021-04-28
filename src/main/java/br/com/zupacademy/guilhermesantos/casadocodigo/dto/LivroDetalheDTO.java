package br.com.zupacademy.guilhermesantos.casadocodigo.dto;

import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelLivro;
import org.springframework.data.domain.Page;

public class LivroDetalheDTO {

    private Long id;

    private String titulo;

    public static Page<LivroDetalheDTO> converteObjetoEntidade(Page<ModelLivro> modelLivros){
        return modelLivros.map(LivroDetalheDTO::new);
    }

    public LivroDetalheDTO(ModelLivro modelLivro){
        this.id = modelLivro.getId();
        this.titulo = modelLivro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String gettitulo() {
        return titulo;
    }
}
