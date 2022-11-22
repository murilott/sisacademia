package br.univille.sisacademia.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sisacademia.entity.Rotina;
import br.univille.sisacademia.service.RotinaService;

@Controller
@RequestMapping("/rotina")
public class RotinaController {

    private RotinaService service;

    @GetMapping
    public ModelAndView index(){
        var listaRotinas = service.getAll();

        return new ModelAndView("rotina/index", "listaRotinas", listaRotinas);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var rotina = new Rotina();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("rotina", rotina);

        return new ModelAndView("rotina/form", dados);    }

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
}
