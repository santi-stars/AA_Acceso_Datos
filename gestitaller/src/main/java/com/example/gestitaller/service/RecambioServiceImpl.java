package com.example.gestitaller.service;

import com.example.gestitaller.domain.Mecanico;
import com.example.gestitaller.domain.Recambio;
import com.example.gestitaller.repository.MecanicoRepository;
import com.example.gestitaller.repository.RecambioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecambioServiceImpl implements RecambioService {

    @Autowired
    private RecambioRepository recambioRepository;

    @Override
    public List<Recambio> findAll() {
        return recambioRepository.findAll();
    }

    @Override
    public Recambio findById(long id) {
        return recambioRepository.findById(id);
    }

    @Override
    public List<Recambio> findByCantidadStock(int cantidadStock) {
        return recambioRepository.findByCantidadStock(cantidadStock);
    }

    @Override
    public void addRecambio(Recambio recambio) {

    }
}
