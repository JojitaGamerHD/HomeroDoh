package com.example.homerodoh.controller;

import com.example.homerodoh.dto.CervezaDTO;
import com.example.homerodoh.model.Cerveza;
import com.example.homerodoh.service.CervezaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cervezas")
public class CervezaController {

    private final CervezaService cervezaService;

    public CervezaController(CervezaService cervezaService) {
        this.cervezaService = cervezaService;
    }

    @GetMapping
    public ResponseEntity<List<Cerveza>> listar() {
        return ResponseEntity.ok(cervezaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {

        Cerveza cerveza = cervezaService.getById(id);

        if (cerveza == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cerveza);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<CervezaDTO>> listarDTO() {
        return ResponseEntity.ok(cervezaService.getCervezasDTO());
    }

    @PostMapping
    public ResponseEntity<Cerveza> crear(@Valid @RequestBody Cerveza cerveza) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cervezaService.save(cerveza));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody Cerveza cerveza) {

        cerveza.setId(id);

        Cerveza actualizada = cervezaService.update(cerveza);

        if (actualizada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

        if (cervezaService.getById(id) == null) {
            return ResponseEntity.notFound().build();
        }

        cervezaService.delete(id);

        return ResponseEntity.noContent().build();
    }
}