package com.proyecto.clinica;

import com.proyecto.clinica.entities.Domicilio;
import com.proyecto.clinica.entities.OdontologoDTO;
import com.proyecto.clinica.entities.Paciente;
import com.proyecto.clinica.entities.PacienteDTO;
import com.proyecto.clinica.exceptions.ResourceNotFoundException;
import com.proyecto.clinica.service.PacienteService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;

    @Test
    public void crearOdontologoTest() throws ResourceNotFoundException {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Alberto");
        pacienteDTO.setApellido("Nuñez");
        pacienteDTO.setId(33L);
        pacienteService.crearPaciente(pacienteDTO);

        PacienteDTO pacienteDTO1 = pacienteService.leerPaciente(33L);
        Assert.assertTrue(pacienteDTO1 != null);
    }

    @Test
    public void eliminarOdontologoTest() throws ResourceNotFoundException {
        PacienteDTO pacienteDTO = pacienteService.leerPaciente(33L);
        pacienteService.eliminarPaciente(33L);
        Assert.assertNull(pacienteDTO);

    }

    @Test
    @Transactional
    public void traerTodos() {
        Set<PacienteDTO> pacienteDTOS = pacienteService.listarTodos();
        Assert.assertTrue(!pacienteDTOS.isEmpty());
        Assert.assertNotNull(pacienteService.listarTodos().size());
        System.out.println(pacienteDTOS);
    }
}
