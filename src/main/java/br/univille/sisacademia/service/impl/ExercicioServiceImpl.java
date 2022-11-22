package br.univille.sisacademia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.univille.sisacademia.entity.Exercicio;
import br.univille.sisacademia.repository.ExercicioRepository;
import br.univille.sisacademia.service.ExercicioService;

public class ExercicioServiceImpl implements ExercicioService {

    @Autowired
    private ExercicioRepository repositorio;

    @Override
    public List<Exercicio> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Exercicio save(Exercicio exercicio) {
        return repositorio.save(exercicio);
    }

    @Override
    public Exercicio findById(long id) {
        var resultado = repositorio.findById(id);

        if ( resultado.isPresent() ) {
            return resultado.get();
        }

        return new Exercicio();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
}
