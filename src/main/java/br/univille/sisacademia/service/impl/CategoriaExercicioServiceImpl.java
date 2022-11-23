package br.univille.sisacademia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sisacademia.entity.CategoriaExercicio;
import br.univille.sisacademia.repository.CategoriaExercicioRepository;
import br.univille.sisacademia.service.CategoriaExercicioService;

@Service
public class CategoriaExercicioServiceImpl implements CategoriaExercicioService {

    @Autowired
    private CategoriaExercicioRepository repositorio;

    @Override
    public List<CategoriaExercicio> getAll() {
        return repositorio.findAll();
    }

    @Override
    public CategoriaExercicio save(CategoriaExercicio categoriaExercicio) {
        return repositorio.save(categoriaExercicio);
    }

    @Override
    public CategoriaExercicio findById(long id) {
        var resultado = repositorio.findById(id);

        if ( resultado.isPresent() ) {
            return resultado.get();
        }

        return new CategoriaExercicio();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
}
