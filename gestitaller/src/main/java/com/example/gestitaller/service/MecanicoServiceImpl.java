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
    public List<Mecanico> findAll() {
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
    public void addMecanico(Mecanico mecanico) {

    }
}
