package com.zenware;

import com.zenware.model.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {

    @Test
    void aplicarImpuesto_valido() {
        Producto producto = new Producto(1L, "Pantalla", 100.0);
        producto.aplicarImpuesto(10);
        assertEquals(110.0, producto.getPrecio());
    }

    @Test
    void aplicarImpuesto_fueraDeRango() {
        Producto producto = new Producto(2L, "Mouse", 50.0);
        assertThrows(IllegalArgumentException.class, () -> producto.aplicarImpuesto(60));
    }
}
