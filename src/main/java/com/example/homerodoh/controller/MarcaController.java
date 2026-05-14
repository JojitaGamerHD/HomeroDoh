package com.example.homerodoh.controller;

import com.example.homerodoh.model.Marca;
import com.example.homerodoh.service.MarcaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/marcas")
public class MarcaController {

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public ResponseEntity<List<Marca>> listar() {
        return ResponseEntity.ok(marcaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {

        Marca marca = marcaService.getById(id);

        if (marca == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(marca);
    }

    @PostMapping
    public ResponseEntity<Marca> crear(@Valid @RequestBody Marca marca) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(marcaService.save(marca));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody Marca marca) {

        marca.setId(id);

        Marca actualizada = marcaService.update(marca);

        if (actualizada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

        if (marcaService.getById(id) == null) {
            return ResponseEntity.notFound().build();
        }

        marcaService.delete(id);

        return ResponseEntity.noContent().build();
    }
}