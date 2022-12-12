package br.univille.sisacademia.controller;

import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sisacademia.dto.DietaDTO;
import br.univille.sisacademia.entity.Dieta;
import br.univille.sisacademia.entity.Prato;
import br.univille.sisacademia.service.DietaService;
import br.univille.sisacademia.service.PratoService;
import br.univille.sisacademia.service.UsuarioService;

@Controller
@RequestMapping("/dieta/{user_id}")
public class DietaController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PratoService pratoService;

    @Autowired
    private DietaService service;

    @GetMapping
    public ModelAndView index(@PathVariable("user_id") long user_id) {
        var usuarioAtual = usuarioService.findById(user_id);

        var listaDietas = service.getAll();
        var listaPratos = pratoService.getAll();

        HashMap<String, Object> dados = new HashMap<>();

        dados.put("usuarioAtual", usuarioAtual);
        dados.put("listaDietas", listaDietas);
        dados.put("listaPratos", listaPratos);
        
        return new ModelAndView("dieta/index", dados);
    }

    @GetMapping("/novo")
    public ModelAndView novoDieta(@PathVariable("user_id") long id, Long user_id){
        var novaDieta = new DietaDTO();
        var listaDietas = service.getAll();
        var listaPratos = pratoService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("novaDieta", novaDieta);
        dados.put("novoPrato", new Prato());
        dados.put("listaDietas", listaDietas);
        dados.put("listaPratos", listaPratos);
  
        return new ModelAndView("dieta/form", dados);    
    }

    @GetMapping("/selecionar/{dieta_id}")
    public ModelAndView selecionarDieta(@PathVariable("user_id") Long user_id, @PathVariable("dieta_id") Long dieta_id) {
        var umUsuario = usuarioService.findById(user_id);
        Date date = Date.from(java.time.LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());

        service.findById(dieta_id).setDataInicio(date);

        umUsuario.setDietaAtual(service.findById(dieta_id));
        usuarioService.save(umUsuario);

        return new ModelAndView("redirect:/home/{user_id}");
    }

    @PostMapping(params = "save")
    public ModelAndView save(@PathVariable("user_id") long user_id, Dieta dieta, DietaDTO dietaDTO) {
        service.save(dieta, dietaDTO);

        return new ModelAndView("redirect:/dieta/{user_id}");
    }
    
    @PostMapping(params = "incpratodieta")
    public ModelAndView incluirPrato(@PathVariable("user_id") long user_id, DietaDTO dieta) {
        dieta.getListaPratos().add(dieta.getPratoSelecionado());

        var listaPratos = pratoService.getAll();
        var listaDietas = service.getAll();

        HashMap<String, Object> dados = new HashMap<>();

        dados.put("dieta", dieta);
        dados.put("novoPrato", dieta.getPratoSelecionado());
        dados.put("novaDieta", dieta);
        dados.put("listaPratos", listaPratos);
        dados.put("listaDietas", listaDietas);

        return new ModelAndView("dieta/form", dados);
    }
    @GetMapping("/escolher/{id}")
    public ModelAndView escolher(@PathVariable("id") long id, @PathVariable("user_id") long user_id) {
        var usuarioAtual = usuarioService.findById(user_id);
        var umaDieta = service.findById(id);
        var listaDietas = service.getAll();

        System.out.println(umaDieta.getNome());

        HashMap<String, Object> dados = new HashMap<>();

        dados.put("umaDieta", umaDieta);
        dados.put("usuarioAtual", usuarioAtual);
        dados.put("listaDietas", listaDietas);

        return new ModelAndView("dieta/index", dados);
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
}
