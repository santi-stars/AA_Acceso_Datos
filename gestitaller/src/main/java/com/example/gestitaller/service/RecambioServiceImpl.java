package com.example.gestitaller.service;

import com.example.gestitaller.domain.Mecanico;
import com.example.gestitaller.domain.OrdenTrabajo;
import com.example.gestitaller.domain.Recambio;
import com.example.gestitaller.exception.RecambioNotFoundException;
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
    public Recambio findById(long id) throws RecambioNotFoundException {
        return recambioRepository.findById(id).orElseThrow(RecambioNotFoundException::new);
    }

    @Override
    public List<Recambio> findByCantidadStock(int cantidadStock) {
        return recambioRepository.findByCantidadStock(cantidadStock);
    }

    @Override
    public Recambio deleteRecambio(long id) throws RecambioNotFoundException {
        Recambio recambio = recambioRepository.findById(id).orElseThrow(RecambioNotFoundException::new);
        recambioRepository.delete(recambio);
        return recambio;
    }

    @Override
    public Recambio addRecambio(Recambio recambio) {
        return recambioRepository.save(recambio);
    }

    @Override
    public Recambio modifyRecambio(long id, Recambio newRecambio) throws RecambioNotFoundException {
        Recambio recambio = recambioRepository.findById(id).orElseThrow(RecambioNotFoundException::new);
        recambio.setDescripcion(newRecambio.getDescripcion());
        recambio.setPrecio(newRecambio.getPrecio());
        recambio.setCantidadStock(newRecambio.getCantidadStock());
        recambio.setCantidadMinima(newRecambio.getCantidadMinima());
        recambio.setFechaEntrada(newRecambio.getFechaEntrada());

        return recambioRepository.save(recambio);
    }

}
