package com.proyecto.clinica.controller;

import com.proyecto.clinica.entities.Odontologo;
import com.proyecto.clinica.entities.OdontologoDTO;
import com.proyecto.clinica.entities.Paciente;
import com.proyecto.clinica.entities.PacienteDTO;
import com.proyecto.clinica.exceptions.ResourceNotFoundException;
import com.proyecto.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api/pacientes")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping()
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDTO pacienteDTO) {
        pacienteService.crearPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO getPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        return pacienteService.leerPaciente(id);
    }


    /*@GetMapping("/{dni}")
    public PacienteDTO getPacientePorDNI(@PathVariable int dni) {
        return pacienteService.buscarPacientePorDNI(dni);
    }

     */




    @PutMapping()
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        pacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<PacienteDTO> getTodosPacientes() {

        return pacienteService.listarTodos();
    }

}
