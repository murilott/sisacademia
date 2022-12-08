package br.univille.sisacademia.service;

import java.util.List;

import br.univille.sisacademia.dto.RotinaDTO;
import br.univille.sisacademia.entity.Rotina;

public interface RotinaService {
    List<Rotina> getAll();
    Rotina save(Rotina rotina, RotinaDTO rotinaDTO);
    Rotina findById(long id);
    void delete(long id);
}
