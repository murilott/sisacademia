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

        if ( resultado.isPresent() ) {
            rotina.setNome(rotinaDTO.getNome());
            rotina.setListaTreinos((ArrayList)rotinaDTO.getListaTreinos());
            rotina.setTempo(rotinaDTO.getTempo());
            rotina.setCalorias(rotinaDTO.getCalorias());
            rotina.setDataInicio(rotinaDTO.getDataInicio());
            
            return repositorio.save(rotina);
        } else
            return repositorio.save(rotina);

        // procurar o id, ver se existe o objeto, se existe atualizar, se n existe, criar
        // passar os dados do DTO para a entidade padrão copiando os dados, menos o treinoSelecionado
        // return repositorio.save(rotina);
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
