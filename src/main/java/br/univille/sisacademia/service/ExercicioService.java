package br.univille.sisacademia.service;

import java.util.List;

import br.univille.sisacademia.entity.Exercicio;

public interface ExercicioService {
    List<Exercicio> getAll();
    Exercicio save(Exercicio exercicio);
    Exercicio findById(long id);
    void delete(long id);
}
