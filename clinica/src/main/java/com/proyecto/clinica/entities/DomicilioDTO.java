package com.proyecto.clinica.entities;

import lombok.Getter;
import lombok.Setter;


public class DomicilioDTO {
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String calle;

    @Getter @Setter
    private String numero;

    @Getter @Setter
    private String localidad;

    @Getter @Setter
    private String provincia;
}
