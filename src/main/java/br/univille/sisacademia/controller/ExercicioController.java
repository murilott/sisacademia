package br.univille.sisacademia.controller;

import java.util.HashMap;

// import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sisacademia.entity.Exercicio;
import br.univille.sisacademia.service.ExercicioService;

@Controller
@RequestMapping("/exercicio")
public class ExercicioController {
    
    @Autowired
    private ExercicioService exercicioService;

    @GetMapping
    public ModelAndView index(){
        var exercicio = new Exercicio();
        var listaExercicios = exercicioService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("listaExercicios", listaExercicios);
        dados.put("exercicio", exercicio);
        dados.put("novoExercicio", new Exercicio());
        return new ModelAndView("exercicio/form", dados);
    }
    @PostMapping(params = "incexercicio")
    public ModelAndView incluirExercicio(Exercicio exercicio){
        var listaExercicios = exercicioService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("listaExercicios", listaExercicios);
        dados.put("novoExercicio", new Exercicio());
        return new ModelAndView("exercicio/form", dados);
    }
    @PostMapping(params = "removeitem")
    public ModelAndView removerItem(@RequestParam("removeitem") int index, Exercicio exercicio){
        exercicioService.getAll().remove(index);
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("novoExercicio", new Exercicio());
        return new ModelAndView("exercicio/form", dados);
    }
}
