package com.proyecto.clinica.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "turnos")
@ToString
public class Turno {
    @Id
    @SequenceGenerator(name = "turno_sequence", sequenceName = "turno_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
    @Getter @Setter @Column(name = "id", nullable = false)
    private Long id;

    @Getter @Setter @Column(name = "fecha")
    private Date fecha;

    @Getter @Setter @Column(name = "hora")
    private LocalTime hora;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "paciente_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Paciente paciente;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "odontologo_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Odontologo odontologo;

    public Turno() {
    }

    public Turno(Date fecha, LocalTime hora, Paciente paciente, Odontologo odontologo) {
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.odontologo = odontologo;
    }
}
