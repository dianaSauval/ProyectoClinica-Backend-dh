package com.proyecto.clinica.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.clinica.entities.Paciente;
import com.proyecto.clinica.entities.PacienteDTO;
import com.proyecto.clinica.entities.Turno;
import com.proyecto.clinica.entities.TurnoDTO;
import com.proyecto.clinica.exceptions.ResourceNotFoundException;
import com.proyecto.clinica.repository.impl.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    ObjectMapper objectMapper;

    public void guardarTurno(TurnoDTO turnoDTO) {
        Turno turno = objectMapper.convertValue(turnoDTO,Turno.class);
        turnoRepository.save(turno);
    }


    @Override
    public void crearTurno(TurnoDTO turnoDTO) {
        guardarTurno(turnoDTO);
    }

    @Override
    public TurnoDTO leerTurno(Long id) throws ResourceNotFoundException {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if(turno.isPresent()){
            turnoDTO=objectMapper.convertValue(turno, TurnoDTO.class);
        }else{
            throw new ResourceNotFoundException("No existe un turno con el id " + id);
        }
        return turnoDTO;
    }

    @Override
    public void modificarTurno(TurnoDTO turnoDTO) {
        guardarTurno(turnoDTO);
    }

    @Override
    public void eliminarTurno(Long id) throws ResourceNotFoundException {
        if (leerTurno(id)==null){
            throw new ResourceNotFoundException("No existe un turno con el id " + id);
        }

        turnoRepository.deleteById(id);
    }

    @Override
    public Set<TurnoDTO> listarTodos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnoDTOS = new HashSet<>();
        for (Turno turno: turnos){
            turnoDTOS.add(objectMapper.convertValue(turno, TurnoDTO.class));
        }
        return turnoDTOS;
    }
}
