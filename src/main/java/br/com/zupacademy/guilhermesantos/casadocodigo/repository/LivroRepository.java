package br.com.zupacademy.guilhermesantos.casadocodigo.repository;

import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelLivro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<ModelLivro, Long> {

}
