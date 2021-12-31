package com.example.gestitaller.service;

import com.example.gestitaller.domain.OrdenTrabajo;
import com.example.gestitaller.exception.OrdenNotFoundException;

import java.util.List;

public interface OrdenTrabajoService {

    List<OrdenTrabajo> findAll();

    OrdenTrabajo findById(long id) throws OrdenNotFoundException;

    List<OrdenTrabajo> findByEjecutada(boolean ejecutada) throws OrdenNotFoundException;

    OrdenTrabajo deleteOrden(long id) throws OrdenNotFoundException;

    OrdenTrabajo addOrden(OrdenTrabajo ordenTrabajo);

    OrdenTrabajo modifyOrden(long id, OrdenTrabajo ordenTrabajo) throws OrdenNotFoundException;
}
