package br.univille.sisacademia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sisacademia.dto.RotinaDTO;
import br.univille.sisacademia.entity.Rotina;
import br.univille.sisacademia.repository.RotinaRepository;
import br.univille.sisacademia.service.RotinaService;

@Service
public class RotinaServiceImpl implements RotinaService {

    @Autowired
    private RotinaRepository repositorio;

    @Override
    public List<Rotina> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Rotina save(Rotina rotina, RotinaDTO rotinaDTO) {
        var resultado = repositorio.findById(rotinaDTO.getId());

        // return repositorio.save(rotina);
        if ( resultado.isPresent() ) {
            rotina.setNome(rotinaDTO.getNome());
            // rotina.setListaTreinos((ArrayList)rotinaDTO.getListaTreinos());
            for ( int i=0; i<rotinaDTO.getListaTreinos().size(); i++ ) {
                var exercDTO = rotinaDTO.getListaTreinos().get(i).getExercicio();

                rotina.getListaTreinos().get(i).setExercicio(exercDTO);
            }
            rotina.setTempo(rotinaDTO.getTempo());
            rotina.setCalorias(rotinaDTO.getCalorias());
            rotina.setDataInicio(rotinaDTO.getDataInicio());
            
            return repositorio.save(rotina);
        } else {
            var novaRotina = new Rotina();
            novaRotina.setNome(rotinaDTO.getNome());
            // novaRotina.setListaTreinos((ArrayList)rotinaDTO.getListaTreinos());
            for ( int i=0; i<rotinaDTO.getListaTreinos().size(); i++ ) {
                var treinoDTO = rotinaDTO.getListaTreinos().get(i);

                novaRotina.getListaTreinos().add(treinoDTO);
            }
            novaRotina.setTempo(rotinaDTO.getTempo());
            novaRotina.setCalorias(rotinaDTO.getCalorias());
            novaRotina.setDataInicio(rotinaDTO.getDataInicio());

            return repositorio.save(novaRotina);
        }
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
