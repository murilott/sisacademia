package br.univille.sisacademia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.sisacademia.entity.Rotina;

@Repository
public interface RotinaRepository extends JpaRepository<Rotina, Long> {
    
}
