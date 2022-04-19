package com.proyecto.clinica.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

public class TurnoDTO {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private Date fecha;

    @Getter @Setter
    private LocalTime hora;

    @Getter @Setter
    private Paciente paciente;

    @Getter @Setter
    private Odontologo odontologo;
}
