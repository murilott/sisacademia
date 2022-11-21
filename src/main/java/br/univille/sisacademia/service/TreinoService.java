package br.univille.sisacademia.service;

import java.util.List;

import br.univille.sisacademia.entity.Treino;

public interface TreinoService {
    List<Treino> getAll();
    Treino save(Treino treino);
    Treino findById(long id);
    void delete(long id);
}
