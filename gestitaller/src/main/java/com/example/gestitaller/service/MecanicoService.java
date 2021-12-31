package com.example.gestitaller.service;

import com.example.gestitaller.domain.Mecanico;
import com.example.gestitaller.exception.MecanicoNotFoundException;

import java.util.List;

public interface MecanicoService {

    List<Mecanico> findAllMecanicos();

    Mecanico findMecanico(long id) throws MecanicoNotFoundException;

    List<Mecanico> findByNombre(String nombre) throws MecanicoNotFoundException;

    Mecanico deleteMecanico(long id) throws MecanicoNotFoundException;

    Mecanico addMecanico(Mecanico mecanico);

    Mecanico modifyMecanico(long id, Mecanico mecanico) throws MecanicoNotFoundException;
}
