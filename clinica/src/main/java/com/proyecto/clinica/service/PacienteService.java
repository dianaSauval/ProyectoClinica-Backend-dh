package com.proyecto.clinica.service;

import com.proyecto.clinica.model.Paciente;
import com.proyecto.clinica.repository.impl.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente guardar(Paciente p) {
        return pacienteRepository.save(p);
    }

    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }

    public Optional<Paciente> buscar(Long id) {
        return pacienteRepository.findById(id);
    }

    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    public Paciente actualizar(Paciente p) {
        return pacienteRepository.save(p);
    }
}