package com.example.gestitaller.service;

import com.example.gestitaller.domain.Mecanico;

import java.util.List;

public interface MecanicoService {

    List<Mecanico> findAll();

    Mecanico findMecanico(long id);

    void addMecanico(Mecanico mecanico);
}
