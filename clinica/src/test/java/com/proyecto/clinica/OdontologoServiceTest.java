package com.proyecto.clinica;

import com.proyecto.clinica.entities.Odontologo;
import com.proyecto.clinica.entities.OdontologoDTO;
import com.proyecto.clinica.exceptions.ResourceNotFoundException;
import com.proyecto.clinica.service.OdontologoService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    @Test
    public void crearOdontologoTest() throws ResourceNotFoundException {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Javier");
        odontologoDTO.setApellido("Velazquez");
        odontologoDTO.setId(33L);
        odontologoService.crearOdontologo(odontologoDTO);

        OdontologoDTO odontologoDTO1 = odontologoService.leerOdontologo(33L);
        Assert.assertTrue(odontologoDTO1 != null);
    }

    @Test
    public void eliminarOdontologoTest() throws ResourceNotFoundException {
        OdontologoDTO odontologoDTO1 = odontologoService.leerOdontologo(33L);
        odontologoService.eliminarOdontologo(33L);
        Assert.assertNull(odontologoDTO1);

    }

    @Test
    @Transactional
    public void traerTodos() {
        Set<OdontologoDTO> odontologoDTOS = odontologoService.listarTodos();
        Assert.assertTrue(!odontologoDTOS.isEmpty());
        Assert.assertNotNull(odontologoService.listarTodos().size());
        System.out.println(odontologoDTOS);
    }


}
