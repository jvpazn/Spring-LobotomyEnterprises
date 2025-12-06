package com.JMR.LobotomyEnterprises.Controller;

import com.JMR.LobotomyEnterprises.DAO.FuncionarioDAO;
import com.JMR.LobotomyEnterprises.model.Funcionario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/funcionarios")
public class funcionarioController {

    private final FuncionarioDAO funcionarioDAO;

    public funcionarioController(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    @GetMapping
    public String listarFuncionarios(Model model) {
        List<Funcionario> funcionarios = funcionarioDAO.findAll();
        model.addAttribute("funcionarios", funcionarios);
        return "funcionarios"; 
    }


    @GetMapping("/novofuncionario")
    public String novoFuncionario(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "novofuncionario"; 
    }


    @PostMapping("/novofuncionario")
    public String criarFuncionario(@ModelAttribute Funcionario funcionario) {
        funcionarioDAO.create(funcionario);
        return "redirect:/funcionarios";
    }


    @GetMapping("/editar/{id}")
    public String editarFuncionario(@PathVariable Long id, Model model) {
        Funcionario f = funcionarioDAO.findById(id).orElse(null);
        model.addAttribute("funcionario", f);
        return "funcionario-form";
    }


    @PostMapping("/editar/{id}")
    public String atualizarFuncionario(@PathVariable Long id, @ModelAttribute Funcionario funcionario) {
        funcionarioDAO.update(id, funcionario);
        return "redirect:/funcionarios";
    }


    @GetMapping("/deletar/{id}")
    public String deletarFuncionario(@PathVariable Long id) {
        funcionarioDAO.delete(id);
        return "redirect:/funcionarios";
    }


    @GetMapping("/buscar")
    public String buscarFuncionario(@RequestParam Long id, Model model) {
        Funcionario f = funcionarioDAO.findById(id).orElse(null);
        model.addAttribute("funcionario", f);
        return "funcionario-busca"; // novo template para exibir resultado
    }


    @GetMapping("/filtrar")
    public String filtrarFuncionario(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cpf,
            @RequestParam(required = false) Long setorId,
            @RequestParam(required = false) Long cargoId,
            @RequestParam(required = false) Double salarioMin,
            @RequestParam(required = false) Double salarioMax,
            Model model) {

        List<Funcionario> filtrados = funcionarioDAO.findByFilters(
                nome, cpf, setorId, cargoId, salarioMin, salarioMax
        );
        model.addAttribute("funcionarios", filtrados);
        return "funcionarios"; 
    }
}
