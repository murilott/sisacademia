package br.univille.sisacademia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sisacademia.entity.Alergia;
import br.univille.sisacademia.repository.AlergiaRepository;
import br.univille.sisacademia.service.AlergiaService;

@Service
public class AlergiaServiceImpl implements AlergiaService {

    @Autowired
    private AlergiaRepository repositorio;

    @Override
    public List<Alergia> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Alergia save(Alergia alergia) {
        return repositorio.save(alergia);
    }

    @Override
    public Alergia findById(long id) {
        var resultado = repositorio.findById(id);

        if ( resultado.isPresent() ) {
            return resultado.get();
        }

        return new Alergia();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
}
