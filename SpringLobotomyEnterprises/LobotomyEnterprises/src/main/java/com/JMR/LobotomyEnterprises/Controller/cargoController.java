package com.JMR.LobotomyEnterprises.Controller;

import com.JMR.LobotomyEnterprises.DAO.CargoDAO;
import com.JMR.LobotomyEnterprises.model.Cargo;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller 
@RequestMapping("/cargos")
public class cargoController {

    private final CargoDAO cargoDAO;

    public cargoController(CargoDAO cargoDAO) {
        this.cargoDAO = cargoDAO;
    }


    @GetMapping
    public String listarCargos(Model model) {
        List<Cargo> cargos = cargoDAO.findAll();
        model.addAttribute("cargos", cargos);
        return "cargos"; 
    }


    @GetMapping("/novocargo")
    public String novoCargo(Model model) {
        model.addAttribute("cargo", new Cargo());
        return "novocargo"; 
    }

    @PostMapping("/novocargo")
    public String criarCargo(@ModelAttribute Cargo cargo) {
        cargoDAO.create(cargo);
        return "redirect:/cargos";
    }

    @GetMapping("/editar/{id}")
    public String editarCargo(@PathVariable Long id, Model model) {
        Cargo c = cargoDAO.findById(id).orElse(null);
        model.addAttribute("cargo", c);
        return "novocargo";
    }


    @PostMapping("/editar/{id}")
    public String atualizarCargo(@PathVariable Long id, @ModelAttribute Cargo cargo) {
        cargoDAO.update(id, cargo);
        return "redirect:/cargos";
    }

    @GetMapping("/deletar/{id}")
    public String deletarCargo(@PathVariable Long id) {
        cargoDAO.delete(id);
        return "redirect:/cargos";
    }

    @GetMapping("/buscar")
    public String buscarCargo(@RequestParam Long id, Model model) {
        Cargo c = cargoDAO.findById(id).orElse(null);
        model.addAttribute("cargo", c);
        return "cargoID";
    }


    @GetMapping("/filtrar")
    public String filtrarCargos(
            @RequestParam(required = false) String titulo,
            Model model) {

        List<Cargo> filtrados = cargoDAO.findByFilters(titulo);
        model.addAttribute("cargos", filtrados);
        return "cargos"; 
    }

}