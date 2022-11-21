package br.univille.sisacademia.service;

import java.util.List;

import br.univille.sisacademia.entity.Prato;

public interface PratoService {
    List<Prato> getAll();
    Prato save(Prato prato);
    Prato findById(long id);
    void delete(long id);
}
