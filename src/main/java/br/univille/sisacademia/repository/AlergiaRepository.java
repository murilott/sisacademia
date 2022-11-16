package br.univille.sisacademia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.sisacademia.entity.Alergia;

@Repository
public interface AlergiaRepository extends JpaRepository<Alergia, Long> {
    
}
