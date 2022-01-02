package com.example.gestitaller.service;

import com.example.gestitaller.domain.OrdenTrabajo;
import com.example.gestitaller.domain.dto.OrdenTrabajoDTO;
import com.example.gestitaller.exception.FacturaNotFoundException;
import com.example.gestitaller.exception.MecanicoNotFoundException;
import com.example.gestitaller.exception.MotoNotFoundException;
import com.example.gestitaller.exception.OrdenNotFoundException;

import java.util.List;

public interface OrdenTrabajoService {

    List<OrdenTrabajo> findAll();

    OrdenTrabajo findById(long id) throws OrdenNotFoundException;

    List<OrdenTrabajo> findByEjecutada(boolean ejecutada) throws OrdenNotFoundException;

    OrdenTrabajo deleteOrden(long id) throws OrdenNotFoundException;

    OrdenTrabajo addOrden(OrdenTrabajoDTO newOrdenTrabajoDTO) throws
            MecanicoNotFoundException, MotoNotFoundException, FacturaNotFoundException;

    OrdenTrabajo modifyOrden(long id, OrdenTrabajoDTO ordenTrabajoDTO) throws OrdenNotFoundException,
            MecanicoNotFoundException, MotoNotFoundException, FacturaNotFoundException;

    OrdenTrabajo modifyOrdenEjecutada(long id, boolean ejecutada) throws OrdenNotFoundException;
}
