package br.univille.sisacademia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sisacademia.entity.Prato;
import br.univille.sisacademia.repository.PratoRepository;
import br.univille.sisacademia.service.PratoService;

@Service
public class PratoServiceImpl implements PratoService {

    @Autowired
    private PratoRepository repositorio;

    @Override
    public List<Prato> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Prato save(Prato prato) {
        return repositorio.save(prato);
    }

    @Override
    public Prato findById(long id) {
        var resultado = repositorio.findById(id);

        if ( resultado.isPresent() ) {
            return resultado.get();
        }

        return new Prato();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
}
