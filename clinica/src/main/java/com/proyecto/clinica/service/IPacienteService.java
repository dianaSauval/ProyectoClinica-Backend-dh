package com.proyecto.clinica.service;

import com.proyecto.clinica.entities.OdontologoDTO;
import com.proyecto.clinica.entities.PacienteDTO;
import com.proyecto.clinica.exceptions.ResourceNotFoundException;

import java.util.Set;

public interface IPacienteService {
    void crearPaciente(PacienteDTO pacienteDTO);
    PacienteDTO leerPaciente(Long id) throws ResourceNotFoundException;
    void modificarPaciente(PacienteDTO pacienteDTO);
    void eliminarPaciente(Long id) throws ResourceNotFoundException;
    Set<PacienteDTO> listarTodos();
}
