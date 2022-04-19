package com.proyecto.clinica.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;


public class OdontologoDTO {
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String apellido;

    @Getter @Setter
    private Integer matricula;


}
