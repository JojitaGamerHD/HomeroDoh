package com.example.homerodoh.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cerveza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String nombre;

    @NotNull
    private Double precio;

    @NotBlank
    private String tipo; // Lager, IPA, etc

    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;
}