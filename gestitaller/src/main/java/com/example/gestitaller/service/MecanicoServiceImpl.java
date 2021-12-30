package com.example.gestitaller.service;

import com.example.gestitaller.domain.Mecanico;
import com.example.gestitaller.repository.MecanicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MecanicoServiceImpl implements MecanicoService {

    @Autowired
    private MecanicoRepository mecanicoRepository;

    @Override
    public List<Mecanico> findAllMecanicos() {
        return mecanicoRepository.findAll();
    }

    @Override
    public Mecanico findMecanico(long id) {
        return mecanicoRepository.findById(id);
    }

    @Override
    public List<Mecanico> findByNombre(String nombre) {
        return mecanicoRepository.findByNombre(nombre);
    }

    @Override
    public Mecanico deleteMecanico(long id) {
        Mecanico mecanico = mecanicoRepository.findById(id);
        mecanicoRepository.delete(mecanico);
        return mecanico;
    }

    @Override
    public Mecanico addMecanico(Mecanico mecanico) {
        return mecanicoRepository.save(mecanico);
    }

    @Override
    public Mecanico modifyMecanico(long id, Mecanico newMecanico) {
        Mecanico mecanico = mecanicoRepository.findById(id);
        mecanico.setNombre(newMecanico.getNombre());
        mecanico.setApellido(newMecanico.getApellido());
        mecanico.setEdad(newMecanico.getEdad());
        mecanico.setDni(newMecanico.getDni());
        mecanico.setDisponible(newMecanico.isDisponible());
        mecanico.setFechaContratacion(newMecanico.getFechaContratacion());

        return mecanicoRepository.save(mecanico);
    }
}
