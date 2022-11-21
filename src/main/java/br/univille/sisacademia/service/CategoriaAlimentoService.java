package br.univille.sisacademia.service;

import java.util.List;

import br.univille.sisacademia.entity.CategoriaAlimento;

public interface CategoriaAlimentoService {
    List<CategoriaAlimento> getAll();
    CategoriaAlimento save(CategoriaAlimento categoriaAlimento);
    CategoriaAlimento findById(long id);
    void delete(long id);
}
