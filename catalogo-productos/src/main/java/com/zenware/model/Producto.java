package com.zenware.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Producto {

    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @Min(value = 0, message = "El precio debe ser mayor o igual a cero")
    private double precio;

    public Producto() {}

    public Producto(Long id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public void aplicarImpuesto(double porcentaje) {
        if (porcentaje < 0 || porcentaje > 50) {
            throw new IllegalArgumentException("Porcentaje incorrecto, el porcentaje debe estar entre 0% y 50%");
        }
        this.precio += this.precio * (porcentaje / 100);
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    @Override
    public String toString() {
        return "Producto{id=" + id + ", nombre='" + nombre + "', precio=" + precio + "}";
    }
}
