package com.proyecto.clinica.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class PacienteDTO {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String apellido;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private int dni;

    @Getter @Setter
    private Date fechaIngreso;

    @Getter @Setter
    private Domicilio domicilio;

}
