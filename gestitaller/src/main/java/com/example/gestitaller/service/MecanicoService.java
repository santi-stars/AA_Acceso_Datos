package com.example.gestitaller.service;

import com.example.gestitaller.domain.Mecanico;

import java.util.List;

public interface MecanicoService {

    List<Mecanico> findAllMecanicos();

    Mecanico findMecanico(long id);

    List<Mecanico> findByNombre(String nombre);

    Mecanico deleteMecanico(long id);

    Mecanico addMecanico(Mecanico mecanico);

    Mecanico modifyMecanico(long id, Mecanico mecanico);
}
