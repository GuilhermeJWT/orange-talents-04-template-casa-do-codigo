package br.com.zupacademy.guilhermesantos.casadocodigo.repository;

import br.com.zupacademy.guilhermesantos.casadocodigo.model.ModelAutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<ModelAutor, Long> {



}
