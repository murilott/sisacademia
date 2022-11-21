package br.univille.sisacademia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rotina")
public class RotinaController {

    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("rotina/index");
    }
}
