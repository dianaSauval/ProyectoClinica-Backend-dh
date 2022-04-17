package com.proyecto.clinica.controller;

import com.proyecto.clinica.entities.Odontologo;
import com.proyecto.clinica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @PostMapping()
    public ResponseEntity<Odontologo> guardar(@RequestBody Odontologo o) {
        return ResponseEntity.ok(odontologoService.guardar(o));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscar(@PathVariable Long id) {
        Odontologo o = odontologoService.buscar(id).orElse(null);

        return ResponseEntity.ok(o);
    }

    @PutMapping()
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo o) {
        ResponseEntity<Odontologo> response = null;

        if (o.getId() != null && odontologoService.buscar(o.getId()).isPresent())
            response = ResponseEntity.ok(odontologoService.actualizar(o));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (odontologoService.buscar(id).isPresent()) {
            odontologoService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> listar() {
        return ResponseEntity.ok(odontologoService.listar());
    }
}
