package com.JMR.LobotomyEnterprises.Controller;

import com.JMR.LobotomyEnterprises.DAO.FuncionarioDAO;
import com.JMR.LobotomyEnterprises.model.Funcionario;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class funcionarioController {

    private final FuncionarioDAO funcionarioDAO;

    public funcionarioController(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    @PostMapping
    public Funcionario create(@RequestBody Funcionario funcionario) {
        return funcionarioDAO.create(funcionario);
    }

    @GetMapping
    public List<Funcionario> findAll() {
        return funcionarioDAO.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Funcionario> findById(@PathVariable Long id) {
        return funcionarioDAO.findById(id);
    }

    @GetMapping("/buscar")
    public List<Funcionario> findByFilters(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cpf,
            @RequestParam(required = false) Long setorId,
            @RequestParam(required = false) Long cargoId,
            @RequestParam(required = false) Double salarioMin,
            @RequestParam(required = false) Double salarioMax
    ) {
        return funcionarioDAO.findByFilters(
                nome,
                cpf,
                setorId,
                cargoId,
                salarioMin,
                salarioMax
        );
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        int rows = funcionarioDAO.update(id, funcionario);

        if (rows == 0) {
            return "Funcionário não encontrado";
        }

        return "Funcionário atualizado com sucesso";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        int rows = funcionarioDAO.delete(id);

        if (rows == 0) {
            return "Funcionário não encontrado";
        }

        return "Funcionário deletado com sucesso";
    }
}
