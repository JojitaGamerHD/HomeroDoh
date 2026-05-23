package com.example.homerodoh.controller;

import com.example.homerodoh.dto.CervezaDTO;
import com.example.homerodoh.model.Cerveza;
import com.example.homerodoh.service.CervezaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cervezas")
@Slf4j
public class CervezaController {

    private final CervezaService cervezaService;

    public CervezaController(CervezaService cervezaService) {
        this.cervezaService = cervezaService;
    }

    @GetMapping
    public ResponseEntity<List<Cerveza>> listar() {

        log.info("Listando todas las cervezas");

        return ResponseEntity.ok(cervezaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cerveza> buscar(@PathVariable Integer id) {

        log.info("Buscando cerveza con ID: {}", id);

        return ResponseEntity.ok(cervezaService.getById(id));
    }

    @GetMapping("/dto")
    public ResponseEntity<List<CervezaDTO>> listarDTO() {

        log.info("Listando cervezas DTO");

        return ResponseEntity.ok(cervezaService.getCervezasDTO());
    }

    @PostMapping
    public ResponseEntity<Cerveza> crear(
            @Valid @RequestBody Cerveza cerveza) {

        log.info("Creando cerveza: {}", cerveza.getNombre());

        Cerveza nueva = cervezaService.save(cerveza);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cerveza> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody Cerveza cerveza) {

        log.info("Actualizando cerveza con ID: {}", id);

        cerveza.setId(id);

        return ResponseEntity.ok(cervezaService.update(cerveza));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

        log.warn("Eliminando cerveza con ID: {}", id);

        cervezaService.delete(id);

        return ResponseEntity.noContent().build();
    }
}