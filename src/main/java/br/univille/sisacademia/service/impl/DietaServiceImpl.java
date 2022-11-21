package br.univille.sisacademia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.univille.sisacademia.entity.Dieta;
import br.univille.sisacademia.repository.DietaRepository;
import br.univille.sisacademia.service.DietaService;

public class DietaServiceImpl implements DietaService {

    @Autowired
    private DietaRepository repositorio;

    @Override
    public List<Dieta> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Dieta save(Dieta dieta) {
        return repositorio.save(dieta);
    }

    @Override
    public Dieta findById(long id) {
        var resultado = repositorio.findById(id);

        if ( resultado.isPresent() ) {
            return resultado.get();
        }

        return new Dieta();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
}
