package br.univille.sisacademia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.univille.sisacademia.entity.Alimento;
import br.univille.sisacademia.repository.AlimentoRepository;
import br.univille.sisacademia.service.AlimentoService;

@Service
public class AlimentoServiceImpl implements AlimentoService {

    @Autowired
    private AlimentoRepository repositorio;

    @Override
    public List<Alimento> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Alimento save(Alimento alimento) {
        return repositorio.save(alimento);
    }

    @Override
    public Alimento findById(long id) {
        var resultado = repositorio.findById(id);

        if ( resultado.isPresent() ) {
            return resultado.get();
        }

        return new Alimento();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
    
}
