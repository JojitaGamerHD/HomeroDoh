package com.example.homerodoh.controller;

import com.example.homerodoh.model.Cerveza;
import com.example.homerodoh.service.CervezaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cervezas")
public class CervezaController {

    @Autowired
    private CervezaService cervezaService;

    @GetMapping
    public ResponseEntity<List<Cerveza>> listar() {
        return ResponseEntity.ok(cervezaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        Cerveza c = cervezaService.getById(id);
        if (c == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(c);
    }

    @PostMapping
    public ResponseEntity<Cerveza> crear(@Valid @RequestBody Cerveza cerveza) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cervezaService.save(cerveza));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @Valid @RequestBody Cerveza cerveza) {
        cerveza.setId(id);
        Cerveza actualizado = cervezaService.update(cerveza);

        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado);
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