package com.proyecto.clinica.repository.impl;

import com.proyecto.clinica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}