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

import br.univille.sisacademia.entity.Dieta;
import br.univille.sisacademia.entity.Prato;
import br.univille.sisacademia.service.DietaService;
import br.univille.sisacademia.service.PratoService;

@Controller
@RequestMapping("/dieta")
public class DietaController {

    @Autowired
    private PratoService pratoService;

    @Autowired
    private DietaService service;

    @GetMapping
    public ModelAndView index(){
        var listaDietas = service.getAll();

        return new ModelAndView("dieta/index", "listaDietas", listaDietas);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var dieta = new Dieta();
        var prato = new Prato();
        var listaPratos = pratoService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("prato", prato);
        dados.put("listaPratos", listaPratos);
        dados.put("dieta", dieta);
        dados.put("novoPrato", new Prato());

        return new ModelAndView("dieta/form", dados);    }

    @PostMapping(params = "form")
    public ModelAndView save(Dieta dieta, BindingResult bindingResult) {
        service.save(dieta);

        return new ModelAndView("redirect:/dieta");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        var umaDieta = service.findById(id);
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("dieta", umaDieta);

        return new ModelAndView("dieta/form", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deletar(@PathVariable("id") long id) {
        service.delete(id);
        return new ModelAndView("redirect:/dieta");
    }
    @PostMapping(params = "incdieta")
    public ModelAndView incluirTreino(Dieta dieta, Prato novoPrato){
        dieta.getListaPratos().add(novoPrato);
        var listaPratos = pratoService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("dieta", dieta);
        dados.put("listaPratos", listaPratos);
        dados.put("novoPrato", new Prato());
        return new ModelAndView("dieta/form", dados);
    }
}
