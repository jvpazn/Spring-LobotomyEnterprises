package com.JMR.LobotomyEnterprises.Controller;

import com.JMR.LobotomyEnterprises.DAO.SetorDAO;
import com.JMR.LobotomyEnterprises.model.Setor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setores")
public class setorController {

    private final SetorDAO setorDAO;

    public setorController(SetorDAO setorDAO) {
        this.setorDAO = setorDAO;
    }

    @PostMapping
    public ResponseEntity<Setor> create(@RequestBody Setor setor) {
        return ResponseEntity.ok(setorDAO.create(setor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Setor> findById(@PathVariable Long id) {
        return setorDAO.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Setor>> findByFilters(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String idSetor
    ) {
        return ResponseEntity.ok(setorDAO.findByFilters(nome, idSetor));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Setor>> findAll() {
        return ResponseEntity.ok(setorDAO.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Setor setor) {
        int rows = setorDAO.update(id, setor);
        if (rows == 0) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        int rows = setorDAO.delete(id);
        if (rows == 0) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }
}