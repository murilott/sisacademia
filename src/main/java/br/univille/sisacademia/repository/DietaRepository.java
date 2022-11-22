package br.univille.sisacademia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.sisacademia.entity.Dieta;

@Repository
public interface DietaRepository extends JpaRepository<Dieta, Long> {
    
}
