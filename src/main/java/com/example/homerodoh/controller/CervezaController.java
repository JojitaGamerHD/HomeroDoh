package com.example.homerodoh.controller;

import com.example.homerodoh.dto.CervezaDTO;
import com.example.homerodoh.model.Cerveza;
import com.example.homerodoh.service.CervezaService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cervezas")
public class CervezaController {

    private static final Logger logger =
            LoggerFactory.getLogger(CervezaController.class);

    private final CervezaService cervezaService;

    public CervezaController(CervezaService cervezaService) {
        this.cervezaService = cervezaService;
    }

    @GetMapping
    public ResponseEntity<List<Cerveza>> listar() {

        logger.info("Listando todas las cervezas");

        return ResponseEntity.ok(cervezaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {

        logger.info("Buscando cerveza con ID: {}", id);

        Cerveza cerveza = cervezaService.getById(id);

        if (cerveza == null) {

            logger.warn("Cerveza no encontrada con ID: {}", id);

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cerveza);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<CervezaDTO>> listarDTO() {

        logger.info("Listando cervezas DTO");

        return ResponseEntity.ok(cervezaService.getCervezasDTO());
    }

    @PostMapping
    public ResponseEntity<Cerveza> crear(
            @Valid @RequestBody Cerveza cerveza) {

        logger.info("Creando cerveza: {}", cerveza.getNombre());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cervezaService.save(cerveza));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody Cerveza cerveza) {

        logger.info("Actualizando cerveza con ID: {}", id);

        cerveza.setId(id);

        Cerveza actualizada = cervezaService.update(cerveza);

        if (actualizada == null) {

            logger.warn("No se pudo actualizar. ID no encontrado: {}", id);

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

        logger.warn("Eliminando cerveza con ID: {}", id);

        if (cervezaService.getById(id) == null) {

            logger.warn("No se pudo eliminar. ID no encontrado: {}", id);

            return ResponseEntity.notFound().build();
        }

        cervezaService.delete(id);

        return ResponseEntity.noContent().build();
    }
}