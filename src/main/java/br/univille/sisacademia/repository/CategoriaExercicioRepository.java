package br.univille.sisacademia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.sisacademia.entity.CategoriaExercicio;

@Repository
public interface CategoriaExercicioRepository extends JpaRepository<CategoriaExercicio, Long> {
    
}
