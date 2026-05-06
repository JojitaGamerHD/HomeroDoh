package com.example.homerodoh.controller;

import com.example.homerodoh.model.Marca;
import com.example.homerodoh.service.MarcaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/marcas")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public ResponseEntity<List<Marca>> listar() {
        return ResponseEntity.ok(marcaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        Marca m = marcaService.getById(id);

        if (m == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(m);
    }

    @PostMapping
    public ResponseEntity<Marca> crear(@RequestBody Marca marca) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(marcaService.save(marca));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody Marca marca) {
        marca.setId(id);

        Marca actualizada = marcaService.update(marca);

        if (actualizada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        marcaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}