package com.proyecto.clinica.service;

import com.proyecto.clinica.entities.Domicilio;
import com.proyecto.clinica.repository.impl.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService {
    private final DomicilioRepository domicilioRepository;

    @Autowired
    public DomicilioService(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    public Domicilio guardar(Domicilio d) {
        return domicilioRepository.save(d);
    }

    public void eliminar(Long id) {
        domicilioRepository.deleteById(id);
    }

    public Optional<Domicilio> buscar(Long id) {
        return domicilioRepository.findById(id);
    }

    public List<Domicilio> listar() {
        return domicilioRepository.findAll();
    }
}
