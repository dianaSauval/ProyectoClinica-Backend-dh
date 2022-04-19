package com.proyecto.clinica.repository.impl;

import com.proyecto.clinica.entities.Paciente;
import com.proyecto.clinica.entities.PacienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    /*@Query("SELECT p FROM pacientes where p.dni = ?1")
    Optional<PacienteDTO>buscarPacientePorDNI(Integer dni);

     */


}
