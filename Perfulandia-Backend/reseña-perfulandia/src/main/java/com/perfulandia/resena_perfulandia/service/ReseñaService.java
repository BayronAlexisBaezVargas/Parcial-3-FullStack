package com.perfulandia.resena_perfulandia.service;

import com.perfulandia.resena_perfulandia.model.Reseña;
import com.perfulandia.resena_perfulandia.repository.ReseñaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReseñaService {

    private final ReseñaRepository repository;

    public ReseñaService(ReseñaRepository repository) {
        this.repository = repository;
    }

    public List<Reseña> obtenerTodas() {
        return repository.findAll();
    }

    public Reseña guardar(Reseña reseña) {
        return repository.save(reseña);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
