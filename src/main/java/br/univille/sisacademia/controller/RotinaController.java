package br.univille.sisacademia.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sisacademia.entity.Rotina;
import br.univille.sisacademia.entity.Treino;
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

    @GetMapping
    public ModelAndView index(){
        var listaRotinas = service.getAll();
        var listaTreinos = treinoService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("listaRotinas", listaRotinas);
        dados.put("listaTreinos", listaTreinos);
        return new ModelAndView("rotina/index", dados);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var rotina = new Rotina();
        var treino = new Treino();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("rotina", rotina);
        dados.put("treino", treino);
        dados.put("novoTreino", new Treino());

        return new ModelAndView("rotina/form", dados);    
    }

    @PostMapping(params = "form")
    public ModelAndView save(Rotina rotina, BindingResult bindingResult) {
        service.save(rotina);

        return new ModelAndView("redirect:/rotina");
    }
    

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
    @PostMapping(params = "inctreino")
    public ModelAndView incluirTreino(Rotina rotina, Treino novoTreino){
        rotina.getListaTreinos().add(novoTreino);
        var listaUsuarios = usuarioService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("rotina", rotina);
        dados.put("listaUsuarios", listaUsuarios);
        dados.put("novoTreino", new Treino());
        return new ModelAndView("rotina/form", dados);
    }
}
