package com.example.gestitaller.service;

import com.example.gestitaller.domain.Cliente;
import com.example.gestitaller.domain.Mecanico;

import java.util.List;

public interface ClienteService {

    List<Cliente> findAll();

    Cliente findById(long id);

    List<Cliente> findByNombre(String nombre);

    void addCliente(Cliente cliente);
}
