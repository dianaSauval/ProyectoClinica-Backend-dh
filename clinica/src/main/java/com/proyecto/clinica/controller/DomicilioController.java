package com.proyecto.clinica.controller;

import com.proyecto.clinica.entities.Domicilio;
import com.proyecto.clinica.entities.Odontologo;
import com.proyecto.clinica.service.DomicilioService;
import com.proyecto.clinica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/domicilios")
public class DomicilioController {

    @Autowired
    private DomicilioService domicilioService;

    @PostMapping()
    public ResponseEntity<Domicilio> guardar(@RequestBody Domicilio domicilio) {
        return ResponseEntity.ok(domicilioService.guardar(domicilio));
    }
}
