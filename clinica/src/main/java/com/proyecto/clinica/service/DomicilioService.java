package com.proyecto.clinica.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.clinica.entities.Domicilio;
import com.proyecto.clinica.entities.DomicilioDTO;
import com.proyecto.clinica.exceptions.ResourceNotFoundException;
import com.proyecto.clinica.repository.impl.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DomicilioService implements IDomicilioService{

    @Autowired
    private DomicilioRepository domicilioRepository;

    @Autowired
    ObjectMapper objectMapper;

    private void guardarDomicilio(DomicilioDTO domicilioDTO){
        Domicilio domicilio = objectMapper.convertValue(domicilioDTO,Domicilio.class);
        domicilioRepository.save(domicilio);
    }


    @Override
    public void crearDomicilio(DomicilioDTO domicilioDTO) {
        guardarDomicilio(domicilioDTO);
    }

    @Override
    public DomicilioDTO leerDomicilio(Long id) throws ResourceNotFoundException {
        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        DomicilioDTO domicilioDTO = null;
        if(domicilio.isPresent()){
            domicilioDTO=objectMapper.convertValue(domicilio, DomicilioDTO.class);
        }else{
            throw new ResourceNotFoundException("No existe un domicilio con el id " + id);
        }
        return domicilioDTO;
    }




    @Override
    public void modificarDomicilio(DomicilioDTO domicilioDTO) {
        guardarDomicilio(domicilioDTO);
    }

    @Override
    public void eliminarDomicilio(Long id) throws ResourceNotFoundException {
        if (leerDomicilio(id)==null){
            throw new ResourceNotFoundException("No existe un domicilio con el id " + id);
        }

        domicilioRepository.deleteById(id);
    }

    @Override
    public Set<DomicilioDTO> listarTodos() {
        List<Domicilio> domicilios = domicilioRepository.findAll();
        Set<DomicilioDTO> domicilioDTOS = new HashSet<>();
        for (Domicilio domicilio: domicilios){
            domicilioDTOS.add(objectMapper.convertValue(domicilio, DomicilioDTO.class));
        }
        return domicilioDTOS;
    }
}
