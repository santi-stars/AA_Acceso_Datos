package com.example.gestitaller.service;

import com.example.gestitaller.domain.Mecanico;
import com.example.gestitaller.domain.Moto;

import java.util.List;

public interface MotoService {

    List<Moto> findAll();

    Moto findById(long id);

    List<Moto> findByMarca(String marca);

    void addMoto(Moto moto);
}
