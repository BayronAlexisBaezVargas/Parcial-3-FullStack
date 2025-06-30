package com.Inventario.Microservicio_Inventario.service;

import com.Inventario.Microservicio_Inventario.model.ProductoStock;
import com.Inventario.Microservicio_Inventario.repository.ProductoStockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;

@Service
public class InventarioService {

    private final ProductoStockRepository repository;

    public InventarioService(ProductoStockRepository repository){
        this.repository = repository;
    }

    public ProductoStock obtenerStock(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ProductoStock actualizarProducto(Long id, ProductoStock datosActualizados) {
        Optional<ProductoStock> optional = repository.findById(id);

        if (optional.isEmpty()) {
            return null;
        }

        ProductoStock producto = optional.get();

        if (datosActualizados.getNombre() != null) {
            producto.setNombre(datosActualizados.getNombre());
        }

        // Supongamos que -1 significa "no actualizar stock"
        if (datosActualizados.getStock() >= 0) {
            producto.setStock(datosActualizados.getStock());
        }

        return repository.save(producto);
    }



    public boolean eliminarProducto(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }



    public List<ProductoStock> obtenerTodos() {
        return repository.findAll();
    }

    public ProductoStock guardarProducto(ProductoStock productoStock){
        return repository.save(productoStock);
    }
}
