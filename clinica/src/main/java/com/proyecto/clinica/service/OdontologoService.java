package com.proyecto.clinica.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.clinica.entities.Domicilio;
import com.proyecto.clinica.entities.DomicilioDTO;
import com.proyecto.clinica.entities.Odontologo;
import com.proyecto.clinica.entities.OdontologoDTO;
import com.proyecto.clinica.exceptions.ResourceNotFoundException;
import com.proyecto.clinica.repository.impl.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService{

    @Autowired
    private OdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper objectMapper;

    private void guardarOdontologo(OdontologoDTO odontologoDTO){
        Odontologo odontologo = objectMapper.convertValue(odontologoDTO,Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    /*public OdontologoDTO buscarOdontologoPorNombre(String nombre){
        return odontologoRepository.buscarOdontologoPorNombre(nombre).get();
    }

     */


    @Override
    public void crearOdontologo(OdontologoDTO odontologoDTO) {
        guardarOdontologo(odontologoDTO);
    }

    @Override
    public OdontologoDTO leerOdontologo(Long id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if(odontologo.isPresent()){
            odontologoDTO=objectMapper.convertValue(odontologo, OdontologoDTO.class);
        }else{
            throw new ResourceNotFoundException("No existe un odontologo con el id " + id);
        }

        return odontologoDTO;
    }

    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) {
        guardarOdontologo(odontologoDTO);
    }

    @Override
    public void eliminarOdontologo(Long id) throws ResourceNotFoundException {
        if (leerOdontologo(id)==null){
            throw new ResourceNotFoundException("No existe un odontologo con el id " + id);
        }
        odontologoRepository.deleteById(id);
    }

    @Override
    public Set<OdontologoDTO> listarTodos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologoDTOS = new HashSet<>();
        for (Odontologo odontologo: odontologos){
            odontologoDTOS.add(objectMapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologoDTOS;
    }
}
