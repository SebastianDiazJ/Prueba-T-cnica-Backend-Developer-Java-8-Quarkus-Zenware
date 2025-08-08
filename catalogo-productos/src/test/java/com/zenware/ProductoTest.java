package com.zenware.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {

    @Test
    void aplicarImpuesto_valido() {
        Producto producto = new Producto(1L, "Pantalla", 100.0);
        producto.aplicarImpuesto(10.0);
        assertEquals(110.0, producto.getPrecio(), 0.01); // tolerancia para double
    }

    @Test
    void aplicarImpuesto_fueraDeRangoBajo() {
        Producto producto = new Producto(2L, "Mouse", 50.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            producto.aplicarImpuesto(-5);
        });
        assertTrue(exception.getMessage().contains("Porcentaje incorrecto"));
    }

    @Test
    void aplicarImpuesto_fueraDeRangoAlto() {
        Producto producto = new Producto(3L, "Teclado", 70.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            producto.aplicarImpuesto(60);
        });
        assertTrue(exception.getMessage().contains("Porcentaje incorrecto"));
    }
}
