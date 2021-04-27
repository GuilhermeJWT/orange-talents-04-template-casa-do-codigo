package br.com.zupacademy.guilhermesantos.casadocodigo.repository;

import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelLivro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<ModelLivro, Long> {

}
