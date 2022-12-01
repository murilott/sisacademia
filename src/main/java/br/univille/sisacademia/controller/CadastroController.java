package br.univille.sisacademia.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sisacademia.entity.Usuario;
import br.univille.sisacademia.service.UsuarioService;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ModelAndView index(){
        var listaUsuarios = service.getAll();

        return new ModelAndView("cadastro/index", "listaUsuarios", listaUsuarios);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var usuario = new Usuario();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("usuario", usuario);

        return new ModelAndView("cadastro/form", dados);    }

    @PostMapping(params = "form")
    public ModelAndView save(@Valid Usuario usuario, BindingResult bindingResult) {
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("usuario", usuario);

        if ( bindingResult.hasErrors() ) {
            return new ModelAndView("cadastro/form", dados);
        }
        
        service.save(usuario);
        
        return new ModelAndView("redirect:/home/" + usuario.getId());
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id, BindingResult bindingResult) {
        var umUsuario = service.findById(id);
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("usuario", umUsuario);

        if ( bindingResult.hasErrors() ) {
            return new ModelAndView("cadastro/form", dados);
        }

        return new ModelAndView("cadastro/form", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deletar(@PathVariable("id") long id) {
        service.delete(id);
        return new ModelAndView("redirect:/home");
    }

}
