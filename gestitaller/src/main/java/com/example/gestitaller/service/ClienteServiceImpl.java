package com.example.gestitaller.service;

import com.example.gestitaller.domain.Cliente;
import com.example.gestitaller.domain.Mecanico;
import com.example.gestitaller.repository.ClienteRepository;
import com.example.gestitaller.repository.MecanicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> findByNombre(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }

    @Override
    public void addCliente(Cliente cliente) {

    }
}