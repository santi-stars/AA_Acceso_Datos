package com.example.gestitaller.service;

import com.example.gestitaller.domain.Mecanico;
import com.example.gestitaller.domain.Moto;
import com.example.gestitaller.domain.OrdenTrabajo;

import java.util.List;

public interface OrdenTrabajoService {

    List<OrdenTrabajo> findAll();

    OrdenTrabajo findById(long id);

    List<OrdenTrabajo> findByEjecutada(boolean ejecutada);

    OrdenTrabajo deleteOrden(long id);

    OrdenTrabajo addOrden(OrdenTrabajo ordenTrabajo);

    OrdenTrabajo modifyOrden(long id, OrdenTrabajo ordenTrabajo);
}
