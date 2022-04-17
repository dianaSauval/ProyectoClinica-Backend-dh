package com.proyecto.clinica.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "domicilios")
@ToString
public class Domicilio {
    @Id
    @SequenceGenerator(name = "domicilio_sequence", sequenceName = "domicilio_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domicilio_sequence")
    @Getter @Setter @Column(name = "id", nullable = false)
    private Long id;

    @Getter @Setter @Column(name = "calle")
    private String calle;

    @Getter @Setter @Column(name = "numero")
    private String numero;

    @Getter @Setter @Column(name = "localidad")
    private String localidad;

    @Getter @Setter @Column(name = "provincia")
    private String provincia;

    public Domicilio(String calle, String numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Domicilio() {
    }
}
