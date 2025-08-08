package com.zenware.repository;

import com.zenware.model.Producto;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class ProductoRepo {
    private final Map<Long, Producto> productos = new ConcurrentHashMap<>();
    private Long currentId = 0L;

    public ProductoRepo() {
        // Productos de ejemplo para pruebas
        guardar(new Producto(null, "Laptop", 1500.0));
        guardar(new Producto(null, "Mouse", 50.0));
        guardar(new Producto(null, "Teclado", 100.0));
    }

    public List<Producto> listar() {
        return new ArrayList<>(productos.values());
    }

    public Optional<Producto> buscarPorId(Long id) {
        return Optional.ofNullable(productos.get(id));
    }

    public Producto guardar(Producto producto) {
        producto.setId(++currentId);
        productos.put(producto.getId(), producto);
        return producto;
    }

    public boolean eliminar(Long id) {
        return productos.remove(id) != null;
    }
}

