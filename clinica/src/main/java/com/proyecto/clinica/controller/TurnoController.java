package com.proyecto.clinica.controller;

import com.proyecto.clinica.entities.DomicilioDTO;
import com.proyecto.clinica.entities.Turno;
import com.proyecto.clinica.entities.TurnoDTO;
import com.proyecto.clinica.exceptions.ResourceNotFoundException;
import com.proyecto.clinica.service.OdontologoService;
import com.proyecto.clinica.service.PacienteService;
import com.proyecto.clinica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api/turnos")
public class TurnoController {

    @Autowired
    TurnoService turnoService;

    @Autowired
    PacienteService pacienteService;

    @Autowired
    OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<?> crearTurno(@RequestBody TurnoDTO turnoDTO) {
        turnoService.crearTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> getTurno(@PathVariable Long id) throws ResourceNotFoundException {
        TurnoDTO turnoDTO = turnoService.leerTurno(id);
        if (turnoDTO != null){
            return ResponseEntity.ok(turnoDTO);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @PutMapping()
    public ResponseEntity<?> modificarTurno(@RequestBody TurnoDTO turnoDTO) {
        turnoService.modificarTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<TurnoDTO> getTodosTurnos() {

        return turnoService.listarTodos();
    }
}
