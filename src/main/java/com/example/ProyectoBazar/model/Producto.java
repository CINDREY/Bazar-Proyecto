package com.example.ProyectoBazar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long codigoProd;
    private String nombreProd;
    private String marca;
    private Double costo;
    private Long cantidadDisponible;

    public Producto() {
    }

    public Producto(Long codigoProd, String nombreProd, String marca, Double costo, Long cantidadDisponible) {
        this.codigoProd = codigoProd;
        this.nombreProd = nombreProd;
        this.marca = marca;
        this.costo = costo;
        this.cantidadDisponible = cantidadDisponible;
    }

    

    
    
    
    
    
}
