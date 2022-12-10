package br.univille.sisacademia.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sisacademia.dto.RotinaDTO;
import br.univille.sisacademia.entity.Exercicio;
import br.univille.sisacademia.entity.Rotina;
import br.univille.sisacademia.entity.Treino;
import br.univille.sisacademia.service.ExercicioService;
import br.univille.sisacademia.service.RotinaService;
import br.univille.sisacademia.service.TreinoService;
import br.univille.sisacademia.service.UsuarioService;

@Controller
@RequestMapping("/rotina")
public class RotinaController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RotinaService service;

    @Autowired
    private TreinoService treinoService;

    @Autowired
    private ExercicioService exercicioService;

    @GetMapping
    public ModelAndView index() {
        var listaRotinas = service.getAll();
        var listaTreinos = treinoService.getAll();
        var listaExercicios = exercicioService.getAll();

        HashMap<String, Object> dados = new HashMap<>();

        dados.put("listaRotinas", listaRotinas);
        dados.put("listaTreinos", listaTreinos);
        dados.put("listaExercicios", listaExercicios);
        
        return new ModelAndView("rotina/index", dados);
    }

    @GetMapping("/novo")
    public ModelAndView novoRotina() {
        var novaRotina = new RotinaDTO();
        var listaRotinas = service.getAll();
        var listaTreinos = treinoService.getAll();
        var listaExercicios = exercicioService.getAll();

        HashMap<String, Object> dados = new HashMap<>();

        dados.put("novaRotina", novaRotina);
        dados.put("novoTreino", new Treino());
        dados.put("listaRotinas", listaRotinas);
        dados.put("listaTreinos", listaTreinos);
        dados.put("listaExercicios", listaExercicios);

        return new ModelAndView("rotina/form", dados);
    }

    @PostMapping(params = "save")
    public ModelAndView save(Rotina rotina, RotinaDTO rotinaDTO) {
        service.save(rotina, rotinaDTO);

        return new ModelAndView("redirect:/rotina");
    }

    @PostMapping(params = "inctreinorotina")
    public ModelAndView incluirTreino(RotinaDTO rotina) {
        rotina.getListaTreinos().add(rotina.getTreinoSelecionado());

        var listaTreinos = treinoService.getAll();
        var listaRotinas = service.getAll();
        var listaExercicios = exercicioService.getAll();

        HashMap<String, Object> dados = new HashMap<>();

        dados.put("rotina", rotina);
        dados.put("novoTreino", rotina.getTreinoSelecionado());
        dados.put("novaRotina", rotina);
        dados.put("listaTreinos", listaTreinos);
        dados.put("listaRotinas", listaRotinas);
        dados.put("listaExercicios", listaExercicios);

        return new ModelAndView("rotina/form", dados);
    }

    // @GetMapping("/treino/novo")
    // public ModelAndView novoTreino(){
    // var treino = new Treino();
    // var listaTreinos = treinoService.getAll();
    // HashMap<String, Object> dados = new HashMap<>();
    // dados.put("treino", treino);
    // dados.put("listaTreinos", listaTreinos);

    // return new ModelAndView("treino/form", dados);
    // }

    // @GetMapping("/exercicio/novo")
    // public ModelAndView novoExercicio(){
    // var exercicio = new Exercicio();
    // var listaExercicios = exercicioService.getAll();
    // HashMap<String, Object> dados = new HashMap<>();
    // dados.put("exercicio", exercicio);
    // dados.put("listaExercicios", listaExercicios);

    // return new ModelAndView("exercicio/form", dados);
    // }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        var umaRotina = service.findById(id);
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("rotina", umaRotina);

        return new ModelAndView("rotina/form", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deletar(@PathVariable("id") long id) {
        service.delete(id);
        return new ModelAndView("redirect:/rotina");
    }
}
