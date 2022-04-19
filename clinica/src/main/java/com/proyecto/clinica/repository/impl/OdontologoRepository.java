package com.proyecto.clinica.repository.impl;

import com.proyecto.clinica.entities.Odontologo;
import com.proyecto.clinica.entities.OdontologoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {

    /*@Query("SELECT o FROM odontologo where o.nombre = ?1")
    Optional<OdontologoDTO>buscarOdontologoPorNombre(String nombre);

     */


}
