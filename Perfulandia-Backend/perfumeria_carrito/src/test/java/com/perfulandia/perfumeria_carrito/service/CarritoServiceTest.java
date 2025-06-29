package com.perfulandia.perfumeria_carrito.service;

import com.perfulandia.perfumeria_carrito.model.Carrito;
import com.perfulandia.perfumeria_carrito.repository.CarritoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//librerias necesarias para mockito
import org.mockito.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CarritoServiceTest {
    //Creamos una instancia de carritoservice y inyectamos mocks
    @InjectMocks
    private CarritoService carritoService;

    @Mock
    private CarritoRepository repo;

    public CarritoServiceTest(){
        //Abriendo e inicializando los mocks anotados
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Test 1 Buscar todo")
    void testBuscarTodo(){
        //Simulando cunado se llama a findAll y Repo devuelve una lsita con juego
        when(repo.findAll()).thenReturn(List.of(new Carrito(1L,12,62000,"Versage")));
        //llamando al servicio que sera probado
        List<Carrito> carritos = carritoService.listar();
        //verificar que el resultado sea exactamente 1 elemento
        assertEquals(1,carritos.size());
    }

    @Test
    @DisplayName("Test 2 guardar")
    void testsave(){
        Carrito c = new Carrito(null,12,62000,"Versage");
        when(repo.save(any())).thenReturn(new Carrito(1L,12,62000,"Versage"));
        Carrito resultado = carritoService.guardar(c);
        assertEquals(1L,resultado.getId());
    }


}
