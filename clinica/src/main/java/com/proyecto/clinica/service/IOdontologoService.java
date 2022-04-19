package com.proyecto.clinica.service;

import com.proyecto.clinica.entities.OdontologoDTO;
import com.proyecto.clinica.exceptions.ResourceNotFoundException;

import java.util.Set;

public interface IOdontologoService {
    void crearOdontologo(OdontologoDTO odontologoDTO);
    OdontologoDTO leerOdontologo(Long id) throws ResourceNotFoundException;
    void modificarOdontologo(OdontologoDTO odontologoDTO);
    void eliminarOdontologo(Long id) throws ResourceNotFoundException;
    Set<OdontologoDTO> listarTodos();
}
