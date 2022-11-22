package br.univille.sisacademia.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sisacademia.service.DietaService;
import br.univille.sisacademia.service.RotinaService;
import br.univille.sisacademia.service.UsuarioService;

@Controller
@RequestMapping("/home")
public class HomeController {

    private UsuarioService service;

    private RotinaService rotinaService;

    private DietaService dietaService;

    @GetMapping
    public ModelAndView index(){
        var listaUsuarios = service.getAll();
        var listaDietas = dietaService.getAll();
        var listaRotinas = rotinaService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("listaDietas", listaDietas);
        dados.put("listaRotinas", listaRotinas);
        dados.put("listaUsuarios", listaUsuarios);

        return new ModelAndView("home/index", dados);
    }

    
}
