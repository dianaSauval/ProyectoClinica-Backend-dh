package com.proyecto.clinica.controller;

import com.proyecto.clinica.entities.Odontologo;
import com.proyecto.clinica.entities.Paciente;
import com.proyecto.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping()
    public ResponseEntity<Paciente> guardar(@RequestBody Paciente p) {
        return ResponseEntity.ok(pacienteService.guardar(p));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Long id) {
        Paciente p = pacienteService.buscar(id).orElse(null);

        return ResponseEntity.ok(p);
    }

    @PutMapping()
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente p) { // ResponseEntity<Paciente> indica que retornamos un Paciente en body
        ResponseEntity<Paciente> response = null;

        if (p.getId() != null && pacienteService.buscar(p.getId()).isPresent())
            response = ResponseEntity.ok(pacienteService.actualizar(p));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (pacienteService.buscar(id).isPresent()) {
            pacienteService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listar() {
        return ResponseEntity.ok(pacienteService.listar());
    }


}
