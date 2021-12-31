package com.example.gestitaller.service;

import com.example.gestitaller.domain.Cliente;
import com.example.gestitaller.domain.Mecanico;
import com.example.gestitaller.domain.Moto;
import com.example.gestitaller.exception.MotoNotFoundException;

import java.util.List;

public interface MotoService {

    List<Moto> findAll();

    Moto findById(long id) throws MotoNotFoundException;

    List<Moto> findByMarca(String marca) throws MotoNotFoundException;

    Moto deleteMoto(long id) throws MotoNotFoundException;

    Moto addMoto(Moto moto);

    Moto modifyMoto(long id, Moto moto) throws MotoNotFoundException;
}
