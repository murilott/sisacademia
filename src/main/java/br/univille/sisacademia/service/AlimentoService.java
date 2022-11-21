package br.univille.sisacademia.service;

import java.util.List;

import br.univille.sisacademia.entity.Alimento;

public interface AlimentoService {
    List<Alimento> getAll();
    Alimento save(Alimento alimento);
    Alimento findById(long id);
    void delete(long id);
}
