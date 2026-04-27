package com.duoc.homerodoh.service;

import com.duoc.homerodoh.model.Producto;
import com.duoc.homerodoh.repository.HomeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeroService {

    @Autowired
    private HomeroRepository repository;

    public List<Producto> obtenerTodos() {
        return repository.obtenerTodos();
    }

    public Producto obtenerPorId(Long id) {
        return repository.obtenerPorId(id);
    }

    public Producto guardar(Producto producto) {
        return repository.guardar(producto);
    }

    public boolean eliminar(Long id) {
        return repository.eliminar(id);
    }

    public Producto actualizar(Long id, Producto producto) {
        return repository.actualizar(id, producto);
    }
}