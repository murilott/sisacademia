package br.univille.sisacademia.service;

import java.util.List;

import br.univille.sisacademia.entity.CategoriaExercicio;

public interface CategoriaExercicioService {
    List<CategoriaExercicio> getAll();
    CategoriaExercicio save(CategoriaExercicio categoriaExercicio);
    CategoriaExercicio findById(long id);
    void delete(long id);
    // easter egg pro murcilho ver 😀
}
