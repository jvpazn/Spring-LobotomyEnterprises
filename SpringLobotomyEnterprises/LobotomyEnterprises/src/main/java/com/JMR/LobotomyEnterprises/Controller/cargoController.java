package com.JMR.LobotomyEnterprises.Controller;

import com.JMR.LobotomyEnterprises.DAO.CargoDAO;
import com.JMR.LobotomyEnterprises.model.Cargo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/cargos")
public class cargoController {

    private final CargoDAO cargoDAO;

    public cargoController(CargoDAO cargoDAO) {
        this.cargoDAO = cargoDAO;
    }

    @PostMapping
    public ResponseEntity<Cargo> create(@RequestBody Cargo cargo) {
        return ResponseEntity.ok(cargoDAO.create(cargo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargo> findById(@PathVariable Long id) {
        return cargoDAO.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Cargo>> findByFilters(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String descricao,
            @RequestParam(required = false) Integer nivelMinimo,
            @RequestParam(required = false) String requisitos
    ) {
        return ResponseEntity.ok(
                cargoDAO.findByFilters(titulo, descricao, nivelMinimo, requisitos)
        );
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cargo>> findAll() {
        return ResponseEntity.ok(cargoDAO.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Cargo cargo) {
        int rows = cargoDAO.update(id, cargo);
        if (rows == 0) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        int rows = cargoDAO.delete(id);
        if (rows == 0) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }
}
