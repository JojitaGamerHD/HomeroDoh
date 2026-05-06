package com.example.homerodoh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.homerodoh.model.Cerveza;
import com.example.homerodoh.repository.CervezaRepository;
import com.example.homerodoh.dto.CervezaDTO;

import java.util.List;

@Service
public class CervezaService {

    @Autowired
    private CervezaRepository cervezaRepository;

    public List<Cerveza> getAll() {
        return cervezaRepository.findAll();
    }

    public Cerveza getById(Integer id) {
        return cervezaRepository.findById(id).orElse(null);
    }

    public Cerveza save(Cerveza cerveza) {
        return cervezaRepository.save(cerveza);
    }

    public Cerveza update(Cerveza cerveza) {
        if (!cervezaRepository.existsById(cerveza.getId())) {
            return null;
        }
        return cervezaRepository.save(cerveza);
    }

    public void delete(Integer id) {
        cervezaRepository.deleteById(id);
    }

    // 🔥 Método DTO (nivel prueba alto)
    public List<CervezaDTO> getCervezasDTO() {
        return cervezaRepository.findAll().stream()
                .filter(c -> c.getMarca() != null)
                .map(c -> new CervezaDTO(
                        c.getNombre(),
                        c.getPrecio(),
                        c.getMarca().getNombre()
                ))
                .toList();
    }
}