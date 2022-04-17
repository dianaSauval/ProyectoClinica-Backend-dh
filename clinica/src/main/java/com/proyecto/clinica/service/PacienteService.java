package com.proyecto.clinica.service;

import com.proyecto.clinica.entities.Odontologo;
import com.proyecto.clinica.entities.Paciente;
import com.proyecto.clinica.repository.impl.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        //p.setFechaIngreso(new Date());
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

    public Paciente buscarPacientePorDNI(Integer dni){
        return pacienteRepository.buscarPacientePorDNI(dni).get();
    }

    public Paciente actualizar(Paciente p) {
        return pacienteRepository.save(p);
    }
}
