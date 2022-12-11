package br.univille.sisacademia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sisacademia.dto.DietaDTO;
import br.univille.sisacademia.entity.Dieta;
import br.univille.sisacademia.repository.DietaRepository;
import br.univille.sisacademia.service.DietaService;

@Service
public class DietaServiceImpl implements DietaService {

    @Autowired
    private DietaRepository repositorio;

    @Override
    public List<Dieta> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Dieta save(Dieta dieta, DietaDTO dietaDTO) {
        var resultado = repositorio.findById(dietaDTO.getId());

        // return repositorio.save(dieta);
        if( resultado.isPresent()) {
            dieta.setNome(dietaDTO.getNome());
            dieta.setCalorias(dietaDTO.getCalorias());
            dieta.setDataInicio(dietaDTO.getDataInicio());

            return repositorio.save(dieta);
        } else {
            var novaDieta = new Dieta();
            novaDieta.setNome(dietaDTO.getNome());
            for(int i=0; i<dietaDTO.getListaPratos().size(); i++){
                var pratoDTO = dietaDTO.getListaPratos().get(i);

                novaDieta.getListaPratos().add(pratoDTO);
            }
            novaDieta.setCalorias(dietaDTO.getCalorias());
            novaDieta.setDataInicio(dietaDTO.getDataInicio());

            return repositorio.save(novaDieta);
        }
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
