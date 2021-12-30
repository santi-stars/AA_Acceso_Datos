package com.example.gestitaller.service;

import com.example.gestitaller.domain.Mecanico;
import com.example.gestitaller.domain.OrdenTrabajo;
import com.example.gestitaller.repository.MecanicoRepository;
import com.example.gestitaller.repository.OrdenTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenTrabajoServiceImpl implements OrdenTrabajoService {

    @Autowired
    private OrdenTrabajoRepository ordenTrabajoRepository;

    @Override
    public List<OrdenTrabajo> findAll() {
        return ordenTrabajoRepository.findAll();
    }

    @Override
    public OrdenTrabajo findById(long id) {
        return ordenTrabajoRepository.findById(id);
    }

    @Override
    public List<OrdenTrabajo> findByEjecutada(boolean ejecutada) {
        return ordenTrabajoRepository.findByEjecutada(ejecutada);
    }

    @Override
    public void addOrdenTrabajo(OrdenTrabajo ordenTrabajo) {

    }
}
