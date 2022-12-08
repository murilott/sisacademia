package br.univille.sisacademia.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//import br.univille.sisacademia.entity.Exercicio;
import br.univille.sisacademia.entity.Treino;
import br.univille.sisacademia.service.ExercicioService;
import br.univille.sisacademia.service.TreinoService;

@Controller
@RequestMapping("/treino")
public class TreinoController {
    
    @Autowired
    private TreinoService treinoService;

    @Autowired
    private ExercicioService exercicioService;

    @GetMapping
    public ModelAndView index(){
        var treino = new Treino();
        var listaTreinos = treinoService.getAll();
        var listaExercicios = exercicioService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("listaTreinos", listaTreinos);
        dados.put("treino", treino);
        dados.put("novoTreino", new Treino());
        dados.put("listaExercicios", listaExercicios);
        return new ModelAndView("treino/form", dados);
    }
    @PostMapping(params = "inctreino")
    public ModelAndView incluirTreino(Treino treino){
        treinoService.save(treino);
        var listaTreinos = treinoService.getAll();
        var listaExercicios = exercicioService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("listaTreinos", listaTreinos);
        dados.put("novoTreino", new Treino());
        dados.put("listaExercicios", listaExercicios);
        return new ModelAndView("redirect:/treino");
    }
}
