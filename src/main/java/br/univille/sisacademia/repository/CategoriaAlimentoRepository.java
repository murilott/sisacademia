package br.univille.sisacademia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.sisacademia.entity.CategoriaAlimento;

@Repository
public interface CategoriaAlimentoRepository extends JpaRepository<CategoriaAlimento, Long> {
    
}
