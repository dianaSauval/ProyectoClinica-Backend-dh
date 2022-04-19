package com.proyecto.clinica.controller;

import com.proyecto.clinica.entities.Domicilio;
import com.proyecto.clinica.entities.DomicilioDTO;
import com.proyecto.clinica.entities.Odontologo;
import com.proyecto.clinica.entities.PacienteDTO;
import com.proyecto.clinica.exceptions.ResourceNotFoundException;
import com.proyecto.clinica.service.DomicilioService;
import com.proyecto.clinica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/domicilios")
public class DomicilioController {

    @Autowired
    DomicilioService domicilioService;

    @PostMapping()
    public ResponseEntity<?> crearDomicilio(@RequestBody DomicilioDTO domicilioDTO) {
        domicilioService.crearDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DomicilioDTO getDomicilio(@PathVariable Long id) throws ResourceNotFoundException {
        return domicilioService.leerDomicilio(id);
    }

    @PutMapping()
    public ResponseEntity<?> modificarPaciente(@RequestBody DomicilioDTO domicilioDTO) {
        domicilioService.modificarDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDomicilio(@PathVariable Long id) throws ResourceNotFoundException {
        domicilioService.eliminarDomicilio(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<DomicilioDTO> getTodosDomicilios() {

        return domicilioService.listarTodos();
    }

}
