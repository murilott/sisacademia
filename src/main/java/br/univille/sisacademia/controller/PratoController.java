package br.univille.sisacademia.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sisacademia.entity.Prato;
import br.univille.sisacademia.service.PratoService;

@Controller
@RequestMapping("/prato")
public class PratoController {
    
    @Autowired
    private PratoService pratoService;

    @GetMapping
    public ModelAndView index(){
        var prato = new Prato();
        var listaPratos = pratoService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("listaPratos", listaPratos);
        dados.put("prato", prato);
        dados.put("novoPrato", new Prato());
        return new ModelAndView("prato/form", dados);
    }
    @PostMapping(params = "incprato")
    public ModelAndView incluirDieta(Prato prato){
        pratoService.save(prato);
        var listaPratos = pratoService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("listaPratos", listaPratos);
        dados.put("novoPrato", new Prato());
        return new ModelAndView("redirect:/prato", dados);
    }
    @GetMapping("/delete/{id}")
    public ModelAndView deletar(@PathVariable("id") long id) {
        pratoService.delete(id);
        return new ModelAndView("redirect:/prato");
    }
}
