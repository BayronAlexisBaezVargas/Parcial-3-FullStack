package com.perfulandia.resena_perfulandia.controller;


import com.perfulandia.resena_perfulandia.model.Reseña;
import com.perfulandia.resena_perfulandia.service.ReseñaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reseñas")
public class ReseñaController {

    private final ReseñaService servicio;

    public ReseñaController(ReseñaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    @Operation(summary = "Listar todas las reseñas")
    public List<Reseña> listar() {
        return servicio.obtenerTodas();
    }

    @PostMapping
    @Operation(summary = "Crear una reseña")
    public Reseña crear(@RequestBody @Valid Reseña reseña) {
        return servicio.guardar(reseña);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una reseña")
    public void eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
    }
}
