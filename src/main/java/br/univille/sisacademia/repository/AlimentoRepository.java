package br.univille.sisacademia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.sisacademia.entity.Alimento;

@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, Long> {
    
}
