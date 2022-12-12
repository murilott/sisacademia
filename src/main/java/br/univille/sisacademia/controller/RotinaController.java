package br.univille.sisacademia.controller;

//import java.lang.ProcessBuilder.Redirect;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sisacademia.dto.RotinaDTO;
import br.univille.sisacademia.entity.Rotina;
import br.univille.sisacademia.entity.Treino;
import br.univille.sisacademia.service.ExercicioService;
import br.univille.sisacademia.service.RotinaService;
import br.univille.sisacademia.service.TreinoService;
import br.univille.sisacademia.service.UsuarioService;

@Controller
@RequestMapping("/rotina/{user_id}")
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
    public ModelAndView index(@PathVariable("user_id") long user_id) {
        var usuarioAtual = usuarioService.findById(user_id);

        var listaRotinas = service.getAll();
        var listaTreinos = treinoService.getAll();
        var listaExercicios = exercicioService.getAll();

        HashMap<String, Object> dados = new HashMap<>();

        dados.put("usuarioAtual", usuarioAtual);
        dados.put("listaRotinas", listaRotinas);
        dados.put("listaTreinos", listaTreinos);
        dados.put("listaExercicios", listaExercicios);
        
        return new ModelAndView("rotina/index", dados);
    }

    @GetMapping("/novo")
    public ModelAndView novoRotina(@PathVariable("user_id") long id, Long user_id) {
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

    @GetMapping("/selecionar/{rotina_id}")
    public ModelAndView selecionarRotina(@PathVariable("user_id") Long user_id, @PathVariable("rotina_id") Long rotina_id) {
        var umUsuario = usuarioService.findById(user_id);
        Date date = Date.from(java.time.LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        service.findById(rotina_id).setDataInicio(date);

        umUsuario.setRotinaAtual(service.findById(rotina_id));
        usuarioService.save(umUsuario);

        return new ModelAndView("redirect:/home/{user_id}");
    }

    @PostMapping(params = "save")
    public ModelAndView save(@PathVariable("user_id") long user_id, Rotina rotina, RotinaDTO rotinaDTO) {
        service.save(rotina, rotinaDTO);

        return new ModelAndView("redirect:/rotina/{user_id}");
    }

    @PostMapping(params = "inctreinorotina")
    public ModelAndView incluirTreino(@PathVariable("user_id") long user_id, RotinaDTO rotina) {
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

    @GetMapping("/escolher/{id}")
    public ModelAndView escolher(@PathVariable("id") long id, @PathVariable("user_id") long user_id) {
        var usuarioAtual = usuarioService.findById(user_id);
        var umaRotina = service.findById(id);
        var listaRotinas = service.getAll();

        System.out.println(umaRotina.getNome());

        HashMap<String, Object> dados = new HashMap<>();

        dados.put("umaRotina", umaRotina);
        dados.put("usuarioAtual", usuarioAtual);
        dados.put("listaRotinas", listaRotinas);

        return new ModelAndView("rotina/index", dados);
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
