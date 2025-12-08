package com.JMR.LobotomyEnterprises.Controller;

import com.JMR.LobotomyEnterprises.DAO.SetorDAO;
import com.JMR.LobotomyEnterprises.model.Setor;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller 
@RequestMapping("/setores")
public class setorController {

    private final SetorDAO setorDAO;

    public setorController(SetorDAO setorDAO) {
        this.setorDAO = setorDAO;
    }

    @GetMapping
    public String listarSetores(Model model) {
        List<Setor> setores = setorDAO.findAll();
        model.addAttribute("setores", setores);
        return "setores"; 
    }


    @GetMapping("/novosetor")
    public String novoSetor(Model model) {
        model.addAttribute("setor", new Setor());
        return "novosetor";
    }

    @PostMapping("/novosetor")
    public String criarSetor(@ModelAttribute Setor setor) {
        setorDAO.create(setor);
        return "redirect:/setores";
    }

    @GetMapping("/editar/{id}")
    public String editarSetor(@PathVariable Long id, Model model) {
        Setor s = setorDAO.findById(id).orElse(null);
        model.addAttribute("setor", s);
        return "novosetor";
    }

    @PostMapping("/editar/{id}")
    public String atualizarSetor(@PathVariable Long id, @ModelAttribute Setor setor) {
        setorDAO.update(id, setor);
        return "redirect:/setores";
    }


    @GetMapping("/deletar/{id}")
    public String deletarSetor(@PathVariable Long id) {
        setorDAO.delete(id);
        return "redirect:/setores";
    }

    @GetMapping("/buscar")
    public String buscarSetor(@RequestParam Long id, Model model) {
        Setor s = setorDAO.findById(id).orElse(null);
        model.addAttribute("setor", s);
        return "setorID";
    }
    

    @GetMapping("/filtrar")
    public String filtrarSetores(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String idSetor, 
            Model model) {

        List<Setor> filtrados = setorDAO.findByFilters(nome, idSetor);
        model.addAttribute("setores", filtrados);
        return "setores"; 
    }
}