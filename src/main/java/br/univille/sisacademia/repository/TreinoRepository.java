package br.univille.sisacademia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.sisacademia.entity.Treino;

@Repository
public interface TreinoRepository extends JpaRepository<Treino, Long> {
    
}
