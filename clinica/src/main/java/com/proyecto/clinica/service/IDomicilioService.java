package com.proyecto.clinica.service;

import com.proyecto.clinica.entities.Domicilio;
import com.proyecto.clinica.entities.DomicilioDTO;
import com.proyecto.clinica.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Set;

public interface IDomicilioService {


    void crearDomicilio(DomicilioDTO domicilioDTO);
    DomicilioDTO leerDomicilio(Long id) throws ResourceNotFoundException;
    void modificarDomicilio(DomicilioDTO domicilioDTO);
    void eliminarDomicilio(Long id) throws ResourceNotFoundException;
    Set<DomicilioDTO> listarTodos();
}
