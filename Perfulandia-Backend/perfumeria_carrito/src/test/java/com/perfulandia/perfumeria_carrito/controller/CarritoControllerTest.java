package com.perfulandia.perfumeria_carrito.controller;
import com.perfulandia.perfumeria_carrito.model.Carrito;
import com.perfulandia.perfumeria_carrito.service.CarritoService;
import com.perfulandia.perfumeria_carrito.controller.CarritoController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

//anotacion para indicar que se probara el controlador
@WebMvcTest(CarritoController.class)

public class CarritoControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private CarritoService service;
    //Json a list y viceversa
    private final ObjectMapper mapper = new ObjectMapper();

    //test get
    @Test
    @DisplayName("Test de obtener todos")
    void testObtenerTodos() throws Exception{
        when(service.listar()).thenReturn(List.of(new Carrito(1L,12,62000,"Versage")));
        //ejecutar la peticion get
        mockMvc.perform(get("/api/v1/carritos"))
                .andExpect(status().isOk())//200
        //verificar que el primer elemento del json tenga el ususario versage
                .andExpect(jsonPath("$[0].usuario").value("Versage"));
    }
    //test de añadir
    @Test
    @DisplayName("Test de post")
    void testPost() throws Exception {
        Carrito c = new Carrito(1L,12,62000,"Versage");
        when(service.guardar(any())).thenReturn(new Carrito(1L,12,62000,"Versage"));
        mockMvc.perform(post("/api/v1/carritos")
                .contentType("application/json")
                .content(mapper.writeValueAsString(c)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.usuario").value("Versage"));
    }

    @Test
    @DisplayName("Test de actualizar por id")
    void testUpdate() throws Exception {
        Carrito c = new Carrito(1L,12,62000,"Versage");

        when(service.Actualizar(anyLong(),any())).thenReturn(new Carrito(1L,12,62000,"Versage"));
        mockMvc.perform(put("/api/v1/carritos/{id}",1)
                .contentType("application/json")
                .content(mapper.writeValueAsString(c)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.usuario").value("Versage"));
    }




}
