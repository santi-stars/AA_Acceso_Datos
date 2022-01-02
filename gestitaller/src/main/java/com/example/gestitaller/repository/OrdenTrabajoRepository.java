package com.example.gestitaller.repository;

import com.example.gestitaller.domain.OrdenTrabajo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenTrabajoRepository extends CrudRepository<OrdenTrabajo, Long> {
    List<OrdenTrabajo> findAll();

    List<OrdenTrabajo> findByEjecutada(boolean ejecutada);
}
