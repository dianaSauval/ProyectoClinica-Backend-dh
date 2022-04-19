package com.proyecto.clinica.controller;

import com.proyecto.clinica.entities.Odontologo;
import com.proyecto.clinica.entities.OdontologoDTO;
import com.proyecto.clinica.exceptions.ResourceNotFoundException;
import com.proyecto.clinica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api/odontologos")
public class OdontologoController {

    @Autowired
    OdontologoService odontologoService;

    @PostMapping()
    public ResponseEntity<?> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        odontologoService.crearOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDTO getOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        return odontologoService.leerOdontologo(id);
    }

    /*
    @GetMapping("/{nombre}")
    public OdontologoDTO getOdontologoPorNombre(@PathVariable String nombre) {
        return odontologoService.buscarOdontologoPorNombre(nombre);
    }

     */

    @PutMapping()
    public ResponseEntity<?> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        odontologoService.modificarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<OdontologoDTO> getTodosOdontologos() {

        return odontologoService.listarTodos();
    }
}
