package com.proyecto.clinica;

import com.proyecto.clinica.entities.Odontologo;
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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;


    public void cargarDataSet() {
        this.odontologoService.guardar(new Odontologo("Santiago", "Paz", 3455647));


    }

    @Test
    public void guardarOdontologo() {
        this.cargarDataSet();
        Odontologo o = odontologoService.guardar(new Odontologo("Juan", "Ramirez", 348971960));
        Assert.assertTrue(o.getId() != null);
    }

    @Test
    public void eliminarOdontologoTest() {
        odontologoService.eliminar(66L);
        Assert.assertTrue(odontologoService.buscar(66L).isEmpty());

    }

    @Test
    @Transactional
    public void traerTodos() {
        List<Odontologo> odontologos = odontologoService.listar();
        Assert.assertTrue(!odontologos.isEmpty());
        Assert.assertNotNull(odontologoService.listar().size());
        System.out.println(odontologos);
    }


}
