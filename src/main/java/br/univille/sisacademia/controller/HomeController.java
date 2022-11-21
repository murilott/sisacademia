package br.univille.sisacademia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sisacademia.service.UsuarioService;

@Controller
@RequestMapping("/home")
public class HomeController {

    private UsuarioService service;

    @GetMapping
    public ModelAndView index(){
        var listaUsuarios = service.getAll();

        return new ModelAndView("home/index", "listaUsuarios", listaUsuarios);
    }

    
}
