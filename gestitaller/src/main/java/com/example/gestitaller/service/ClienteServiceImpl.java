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
    public Cliente deleteCliente(long id) {
        Cliente cliente = clienteRepository.findById(id);
        clienteRepository.delete(cliente);
        return cliente;
    }

    @Override
    public Cliente addCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente modifyCliente(long id, Cliente newCliente) {
        Cliente cliente = clienteRepository.findById(id);
        cliente.setNombre(newCliente.getNombre());
        cliente.setApellido(newCliente.getApellido());
        cliente.setEdad(newCliente.getEdad());
        cliente.setDni(newCliente.getDni());
        cliente.setDireccion(newCliente.getDireccion());
        cliente.setClienteVip(newCliente.isClienteVip());

        return clienteRepository.save(cliente);
    }

}