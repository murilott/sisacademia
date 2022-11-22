package br.univille.sisacademia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.sisacademia.entity.Exercicio;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
    
}
