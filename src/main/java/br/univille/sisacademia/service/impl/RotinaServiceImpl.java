package br.univille.sisacademia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.univille.sisacademia.entity.Rotina;
import br.univille.sisacademia.repository.RotinaRepository;
import br.univille.sisacademia.service.RotinaService;

public class RotinaServiceImpl implements RotinaService {

    @Autowired
    private RotinaRepository repositorio;

    @Override
    public List<Rotina> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Rotina save(Rotina rotina) {
        return repositorio.save(rotina);
    }

    @Override
    public Rotina findById(long id) {
        var resultado = repositorio.findById(id);

        if ( resultado.isPresent() ) {
            return resultado.get();
        }

        return new Rotina();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
}
