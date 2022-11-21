package br.univille.sisacademia.service;

import java.util.List;

import br.univille.sisacademia.entity.Alergia;

public interface AlergiaService {
    List<Alergia> getAll();
    Alergia save(Alergia alergia);
    Alergia findById(long id);
    void delete(long id);
}
