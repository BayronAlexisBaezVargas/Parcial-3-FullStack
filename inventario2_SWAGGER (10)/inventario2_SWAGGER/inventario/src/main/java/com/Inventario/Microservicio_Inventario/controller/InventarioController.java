package com.Inventario.Microservicio_Inventario.controller;

import com.Inventario.Microservicio_Inventario.model.ProductoStock;
import com.Inventario.Microservicio_Inventario.service.InventarioService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//a
@RestController
@RequestMapping("/api/inventario")

public class InventarioController {

    private final InventarioService service;

    public InventarioController(InventarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductoStock> listarInventario() {
        return service.obtenerTodos();
    }

    //Actualizar producto
    @PatchMapping("/{id}")
    public ResponseEntity<ProductoStock> actualizarProducto(
            @PathVariable Long id,
            @RequestBody ProductoStock productoActualizado) {

        ProductoStock actualizado = service.actualizarProducto(id, productoActualizado);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    //Borrar producto
    @DeleteMapping("/producto/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id) {
        boolean eliminado = service.eliminarProducto(id);
        if (eliminado) {
            return ResponseEntity.ok().body("Producto eliminado correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //guardar producto
    @PostMapping
    public ProductoStock guardarProducto(@RequestBody ProductoStock productoStock){
        return service.guardarProducto(productoStock);
    }

    @GetMapping("/{id}")
    public ProductoStock obtenerProducto(@PathVariable Long id){
        return service.obtenerStock(id);
    }
}
