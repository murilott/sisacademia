package br.univille.sisacademia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.univille.sisacademia.entity.CategoriaAlimento;
import br.univille.sisacademia.repository.CategoriaAlimentoRepository;
import br.univille.sisacademia.service.CategoriaAlimentoService;

public class CategoriaAlimentoServiceImpl implements CategoriaAlimentoService {

    @Autowired
    private CategoriaAlimentoRepository repositorio;

    @Override
    public List<CategoriaAlimento> getAll() {
        return repositorio.findAll();
    }

    @Override
    public CategoriaAlimento save(CategoriaAlimento categoriaAlimento) {
        return repositorio.save(categoriaAlimento);
    }

    @Override
    public CategoriaAlimento findById(long id) {
        var resultado = repositorio.findById(id);

        if ( resultado.isPresent() ) {
            return resultado.get();
        }

        return new CategoriaAlimento();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
}
