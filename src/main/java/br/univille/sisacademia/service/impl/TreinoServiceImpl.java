package br.univille.sisacademia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sisacademia.entity.Treino;
import br.univille.sisacademia.repository.TreinoRepository;
import br.univille.sisacademia.service.TreinoService;

@Service
public class TreinoServiceImpl implements TreinoService {

    @Autowired
    private TreinoRepository repositorio;

    @Override
    public List<Treino> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Treino save(Treino treino) {
        return repositorio.save(treino);
    }

    @Override
    public Treino findById(long id) {
        var resultado = repositorio.findById(id);

        if ( resultado.isPresent() ) {
            return resultado.get();
        }

        return new Treino();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
}
