package com.proyecto.clinica.service;

import com.proyecto.clinica.entities.Domicilio;
import com.proyecto.clinica.entities.Odontologo;
import com.proyecto.clinica.repository.impl.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {
    private final OdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo guardar(Odontologo o) {
        return odontologoRepository.save(o);
    }

    public void eliminar(Long id) { odontologoRepository.deleteById(id);}


    public Optional<Odontologo> buscar(Long id) {
        return odontologoRepository.findById(id);
    }


    public List<Odontologo> listar() {
        return odontologoRepository.findAll();
    }

    public Odontologo buscarOdontologoPorNombre(String nombre){
        return odontologoRepository.buscarOdontologoPorNombre(nombre).get();
    }

    public Odontologo actualizar(Odontologo o) {
        return odontologoRepository.save(o);
    }

}
