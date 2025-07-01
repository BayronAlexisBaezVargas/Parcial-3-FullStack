package com.perfulandia.perfumeria_carrito.controller;

import com.perfulandia.perfumeria_carrito.model.Carrito;
import com.perfulandia.perfumeria_carrito.service.CarritoService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;
//a
@Tag(name = "Carrito", description = "API REST para el manejo de los carritos")
@RestController
@RequestMapping("/api/v1/carritos")
public class CarritoController {
    //instancia del servicio
    private final CarritoService service;

    //Constructor
    public CarritoController(CarritoService service){
        this.service = service;
    }


    //Operation: para documentar endpoints especificos o metodos
    @Operation(summary = "Obtener todos los carritos", description = "Obtiene todos los carritos almacenados en la base de datos")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa")
    @GetMapping
    public List<Carrito> listar(){
        return service.listar();
    }

    //Documentacion de request tipo Post del ms carrito con apiresponses para colocar mas de una exepcion y sabes que pasa conc ada una
    @Operation(summary = "Crea un nuevo carrito")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Carrito creado"),
            @ApiResponse(responseCode = "400", description = "Error al crear el carrito"),
            @ApiResponse(responseCode = "500", description = "Error interno al crear el carrito")
    })
    @PostMapping
    public Carrito guardar(@RequestBody Carrito carrito){
        return service.guardar(carrito);
    }

    @Operation(summary = "Obtener un carrito por su id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Carrito encontrado"),
            @ApiResponse(responseCode = "404", description = "Carrito no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al obtener el carrito")
    })
    @GetMapping("/{id}")
    public Carrito buscar(@PathVariable long id){
        return service.buscarPorId(id);
    }

    @Operation(summary = "Eliminar un carrito")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Carrito eliminado"),
            @ApiResponse(responseCode = "404", description = "Carrito no encontrado para actualizar"),
            @ApiResponse(responseCode = "400", description = "Error al actualizar el carrito")
    })
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable long id){
        service.eliminar(id);
    }

    @Operation(summary = "Actualizar un carrito")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Carrito actualizado"),
            @ApiResponse(responseCode = "404", description = "Carrito no encontrado para actualizar"),
            @ApiResponse(responseCode = "400", description = "Error al actualizar el carrito"),
            @ApiResponse(responseCode = "409", description = "Conflicto al actualizar el carrito"),
            @ApiResponse(responseCode = "500", description = "Error interno al actualizar el carrito"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<Carrito> actualizar(@PathVariable long id, @RequestBody Carrito carrito){
        Carrito actualizado = service.Actualizar(id,carrito);
        return ResponseEntity.ok(actualizado);
    }

}
