package com.example.gestitaller.service;

import com.example.gestitaller.domain.Mecanico;
import com.example.gestitaller.domain.Moto;
import com.example.gestitaller.repository.MecanicoRepository;
import com.example.gestitaller.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoServiceImpl implements MotoService {

    @Autowired
    private MotoRepository motoRepository;

    @Override
    public List<Moto> findAll() {
        return motoRepository.findAll();
    }

    @Override
    public Moto findById(long id) {
        return motoRepository.findById(id);
    }

    @Override
    public List<Moto> findByMarca(String marca) {
        return motoRepository.findByMarca(marca);
    }

    @Override
    public void addMoto(Moto moto) {

    }
}
