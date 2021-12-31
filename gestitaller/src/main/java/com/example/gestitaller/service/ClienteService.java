package com.example.gestitaller.service;

import com.example.gestitaller.domain.Cliente;
import com.example.gestitaller.domain.Mecanico;
import com.example.gestitaller.exception.ClienteNotFoundException;

import java.util.List;

public interface ClienteService {

    List<Cliente> findAllClientes();

    List<Cliente> findAllClientes(String nombre, String apellido, String dni);

    Cliente findById(long id) throws ClienteNotFoundException;

    List<Cliente> findByNombre(String nombre) throws ClienteNotFoundException;

    Cliente deleteCliente(long id) throws ClienteNotFoundException;

    Cliente addCliente(Cliente cliente);

    Cliente modifyCliente(long id, Cliente cliente) throws ClienteNotFoundException;
}
