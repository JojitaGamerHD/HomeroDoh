package com.duoc.homerodoh.repository;

import com.duoc.homerodoh.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HomeroRepository {

    private List<Producto> lista = new ArrayList<>();
    private Long contadorId = 1L;
    public List<Producto> obtenerTodos() {
        return lista;
    }

    public Producto obtenerPorId(Long id) {
        for (Producto p : lista) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public Producto guardar(Producto producto) {
        producto.setId(contadorId++);
        lista.add(producto);
        return producto;
    }

    public boolean eliminar(Long id) {
        for (Producto p : lista) {
            if (p.getId().equals(id)) {
                lista.remove(p);
                return true;
            }
        }
        return false;
    }

    public Producto actualizar(Long id, Producto productoActualizado) {
        for (Producto p : lista) {
            if (p.getId().equals(id)) {
                p.setNombre(productoActualizado.getNombre());
                p.setPrecio(productoActualizado.getPrecio());
                p.setCategoria(productoActualizado.getCategoria());
                return p;
            }
        }
        return null;
    }
}