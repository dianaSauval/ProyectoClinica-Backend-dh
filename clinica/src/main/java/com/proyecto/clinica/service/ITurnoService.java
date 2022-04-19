package com.proyecto.clinica.service;

import com.proyecto.clinica.entities.TurnoDTO;
import com.proyecto.clinica.exceptions.ResourceNotFoundException;

import java.util.Set;

public interface ITurnoService {
    void crearTurno(TurnoDTO turnoDTO);
    TurnoDTO leerTurno(Long id) throws ResourceNotFoundException;
    void modificarTurno(TurnoDTO turnoDTO);
    void eliminarTurno(Long id) throws ResourceNotFoundException;
    Set<TurnoDTO> listarTodos();
}
