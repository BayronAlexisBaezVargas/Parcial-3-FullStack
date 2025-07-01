package com.perfulandia.resena_perfulandia.service;

import com.perfulandia.resena_perfulandia.model.Reseña;
import com.perfulandia.resena_perfulandia.repository.ReseñaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ReseñaServiceTest {
@InjectMocks
    private ReseñaService service;

@Mock
    private ReseñaRepository repo;

public ReseñaServiceTest(){
    MockitoAnnotations.openMocks(this);
}

@Test
@DisplayName("test 1 buscar todo ")
    void testFindAll(){
    when(repo.findAll()).thenReturn(List.of(new Reseña(1L, "muy buenas las colonias huelen muy bien",10,"ian badilla")));
    List<Reseña> resultado = service.obtenerTodas();

    assertEquals(1,resultado.size());

}


}
