package br.univille.sisacademia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.sisacademia.entity.Prato;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Long> {
    
}
