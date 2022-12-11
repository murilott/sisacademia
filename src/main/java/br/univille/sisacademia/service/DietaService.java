package br.univille.sisacademia.service;

import java.util.List;

import br.univille.sisacademia.dto.DietaDTO;
import br.univille.sisacademia.entity.Dieta;

public interface DietaService {
    List<Dieta> getAll();
    Dieta save(Dieta dieta, DietaDTO dietaDTO);
    Dieta findById(long id);
    void delete(long id);
}
