
package com.duoc.homerodoh.controller;
import com.duoc.homerodoh.model.Producto;
import com.duoc.homerodoh.service.HomeroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class HomeroController {

    @Autowired
    private HomeroService service;

    @GetMapping
    public ResponseEntity<List<Producto>> obtenerTodos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        Producto producto = service.obtenerPorId(id);

        if (producto == null) {
            return ResponseEntity
                    .status(404)
                    .body("Producto no encontrado");
        }

        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public ResponseEntity<?> guardar(@Valid @RequestBody Producto producto) {
        Producto nuevo = service.guardar(producto);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id,
                                        @Valid @RequestBody Producto producto) {

        Producto actualizado = service.actualizar(id, producto);

        if (actualizado == null) {
            return ResponseEntity
                    .status(404)
                    .body("Producto no encontrado");
        }

        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        boolean eliminado = service.eliminar(id);

        if (!eliminado) {
            return ResponseEntity
                    .status(404)
                    .body("Producto no encontrado");
        }

        return ResponseEntity.ok("Producto eliminado correctamente");
    }
}