package com.proyecto.clinica.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.clinica.entities.Odontologo;
import com.proyecto.clinica.entities.OdontologoDTO;
import com.proyecto.clinica.entities.Paciente;
import com.proyecto.clinica.entities.PacienteDTO;
import com.proyecto.clinica.exceptions.ResourceNotFoundException;
import com.proyecto.clinica.repository.impl.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper objectMapper;


    /*public PacienteDTO buscarPacientePorDNI(Integer dni){
        return pacienteRepository.buscarPacientePorDNI(dni).get();
    }

     */



    private void guardarPaciente(PacienteDTO pacienteDTO){
        Paciente paciente = objectMapper.convertValue(pacienteDTO,Paciente.class);
        pacienteRepository.save(paciente);
    }

    @Override
    public void crearPaciente(PacienteDTO pacienteDTO) {
        guardarPaciente(pacienteDTO);
    }

    @Override
    public PacienteDTO leerPaciente(Long id) throws ResourceNotFoundException {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if(paciente.isPresent()){
            pacienteDTO=objectMapper.convertValue(paciente, PacienteDTO.class);
        }else{
        throw new ResourceNotFoundException("No existe un paciente con el id " + id);
    }
        return pacienteDTO;

    }

    @Override
    public void modificarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = objectMapper.convertValue(pacienteDTO,Paciente.class);
        pacienteRepository.save(paciente);
    }

    @Override
    public void eliminarPaciente(Long id) throws ResourceNotFoundException {
        if (leerPaciente(id)==null){
            throw new ResourceNotFoundException("No existe un paciente con el id " + id);
        }

        pacienteRepository.deleteById(id);
    }

    @Override
    public Set<PacienteDTO> listarTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacienteDTOS = new HashSet<>();
        for (Paciente paciente: pacientes){
            pacienteDTOS.add(objectMapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacienteDTOS;
    }
}
