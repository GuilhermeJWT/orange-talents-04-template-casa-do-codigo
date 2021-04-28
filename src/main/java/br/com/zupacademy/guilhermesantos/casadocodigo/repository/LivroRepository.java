package br.com.zupacademy.guilhermesantos.casadocodigo.repository;

import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelLivro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<ModelLivro, Long> {

    @Query("select l from ModelLivro l left join fetch l.autor where l.id =:id")
    Optional<ModelLivro> findByIdFetchLivros(@Param("id") Long id);
}
