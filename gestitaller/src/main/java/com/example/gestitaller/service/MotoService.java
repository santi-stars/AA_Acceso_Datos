package com.example.gestitaller.service;

import com.example.gestitaller.domain.Cliente;
import com.example.gestitaller.domain.Mecanico;
import com.example.gestitaller.domain.Moto;

import java.util.List;

public interface MotoService {

    List<Moto> findAll();

    Moto findById(long id);

    List<Moto> findByMarca(String marca);

    Moto deleteMoto(long id);

    Moto addMoto(Moto moto);

    Moto modifyMoto(long id, Moto moto);
}
