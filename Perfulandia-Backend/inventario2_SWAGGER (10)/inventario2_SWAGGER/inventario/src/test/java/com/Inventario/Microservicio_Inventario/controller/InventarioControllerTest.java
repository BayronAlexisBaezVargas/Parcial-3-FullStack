package com.Inventario.Microservicio_Inventario.controller;

import com.Inventario.Microservicio_Inventario.service.InventarioService;
import com.Inventario.Microservicio_Inventario.model.ProductoStock;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.ArgumentMatchers.any;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;


@WebMvcTest(InventarioController.class)
public class InventarioControllerTest {
//a
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private InventarioService service;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void testGetAll() throws Exception {
        when(service.obtenerTodos()).thenReturn(List.of(new ProductoStock(1L, 100, "Axe")));
        mockMvc.perform(get("/api/inventario"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Axe"));
    }

    @Test
    void testPost() throws Exception {
        ProductoStock P = new ProductoStock(2L, 150, "Rexona");
        when(service.guardarProducto(any(ProductoStock.class))).thenReturn(new ProductoStock(2L, 150, "Rexona"));
        mockMvc.perform(post("/api/inventario")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(P)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Rexona"));
    }

    @Test
    void testDelete() throws Exception {
        when(service.eliminarProducto(1L)).thenReturn(true);
        mockMvc.perform(delete("/api/inventario/producto/1"))
                .andExpect(status().isOk());
    }
}
