package com.example.gestitaller.service;

import com.example.gestitaller.domain.Mecanico;
import com.example.gestitaller.domain.OrdenTrabajo;
import com.example.gestitaller.domain.Recambio;

import java.util.List;

public interface RecambioService {

    List<Recambio> findAll();

    Recambio findById(long id);

    List<Recambio> findByCantidadStock(int cantidadStock);

    Recambio deleteRecambio(long id);

    Recambio addRecambio(Recambio recambio);

    Recambio modifyRecambio(long id, Recambio recambio);
}
