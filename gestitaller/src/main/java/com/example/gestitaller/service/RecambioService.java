package com.example.gestitaller.service;

import com.example.gestitaller.domain.Mecanico;
import com.example.gestitaller.domain.OrdenTrabajo;
import com.example.gestitaller.domain.Recambio;
import com.example.gestitaller.exception.RecambioNotFoundException;

import java.util.List;

public interface RecambioService {

    List<Recambio> findAll();

    Recambio findById(long id) throws RecambioNotFoundException;

    List<Recambio> findByCantidadStock(int cantidadStock) throws RecambioNotFoundException;

    Recambio deleteRecambio(long id) throws RecambioNotFoundException;

    Recambio addRecambio(Recambio recambio);

    Recambio modifyRecambio(long id, Recambio recambio) throws RecambioNotFoundException;
}
