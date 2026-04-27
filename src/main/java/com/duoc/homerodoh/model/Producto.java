package com.duoc.homerodoh.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    private Long id; 

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotNull(message = "El precio no puede ser nulo")
    private Double precio;

    @NotBlank(message = "La categoría no puede estar vacía")
    private String categoria;
}