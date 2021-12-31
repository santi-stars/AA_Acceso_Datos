package com.example.gestitaller.service;

import com.example.gestitaller.domain.Cliente;
import com.example.gestitaller.domain.Mecanico;
import com.example.gestitaller.domain.Moto;
import com.example.gestitaller.exception.MotoNotFoundException;
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
    public Moto findById(long id) throws MotoNotFoundException {
        return motoRepository.findById(id).orElseThrow(MotoNotFoundException::new);
    }

    @Override
    public List<Moto> findByMarca(String marca) {
        return motoRepository.findByMarca(marca);
    }

    @Override
    public Moto deleteMoto(long id) throws MotoNotFoundException {
        Moto moto = motoRepository.findById(id).orElseThrow(MotoNotFoundException::new);
        motoRepository.delete(moto);
        return moto;
    }

    @Override
    public Moto addMoto(Moto moto) {
        return motoRepository.save(moto);
    }

    @Override
    public Moto modifyMoto(long id, Moto newMoto) throws MotoNotFoundException {
        Moto moto = motoRepository.findById(id).orElseThrow(MotoNotFoundException::new);
        moto.setMarca(newMoto.getMarca());
        moto.setModelo(newMoto.getModelo());
        moto.setCilindrada(newMoto.getCilindrada());
        moto.setFechaMatriculacion(newMoto.getFechaMatriculacion());
        moto.setIdCliente(newMoto.getIdCliente());

        return motoRepository.save(moto);
    }

}
