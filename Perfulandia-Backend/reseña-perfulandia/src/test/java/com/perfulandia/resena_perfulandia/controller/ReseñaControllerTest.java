package com.perfulandia.resena_perfulandia.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.perfulandia.resena_perfulandia.model.Reseña;
import com.perfulandia.resena_perfulandia.service.ReseñaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@Import(ReseñaControllerTest.ReseñaServiceTestConfig.class)
public class ReseñaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ReseñaService service;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    @DisplayName("Test de obtener todas las reseñas")
    void testGetAll() throws Exception {
        when(service.obtenerTodas()).thenReturn(List.of(
                new Reseña(1L, "me gustó mucho el perfume", 10, "ian badilla")
        ));

        mockMvc.perform(get("/api/reseñas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].autor").value("ian badilla"));
    }

    @Test
    @DisplayName("Test de eliminar reseña por ID")
    void testDelete() throws Exception {
        doNothing().when(service).eliminar(1L);

        mockMvc.perform(delete("/api/reseñas/1"))
                .andExpect(status().isOk());
    }

    // Inyectamos el mock usando configuración personalizada
    @TestConfiguration
    static class ReseñaServiceTestConfig {
        @Bean
        public ReseñaService reseñaService() {
            return mock(ReseñaService.class);
        }
    }
}
