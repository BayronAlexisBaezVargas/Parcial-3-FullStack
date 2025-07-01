package com.Inventario.Microservicio_Inventario.service;

import com.Inventario.Microservicio_Inventario.model.ProductoStock;
import com.Inventario.Microservicio_Inventario.repository.ProductoStockRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class InventarioServiceTest {
    @InjectMocks
    private InventarioService service;

    @Mock
    private ProductoStockRepository repo;

    public InventarioServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        when(repo.findAll()).thenReturn(List.of(new ProductoStock(1L, 50, "Esika")));
        List<ProductoStock> resultado = service.obtenerTodos();
        assertEquals(1, resultado.size());
    }

}
