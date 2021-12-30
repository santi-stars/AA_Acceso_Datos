package com.example.gestitaller.controller;

import com.example.gestitaller.domain.Cliente;
import com.example.gestitaller.domain.Mecanico;
import com.example.gestitaller.service.ClienteService;
import com.example.gestitaller.service.MecanicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        List<Cliente> clientes = clienteService.findAll();
        return clientes;
    }

    @GetMapping("cliente/{id}")
    public Cliente getById(@PathVariable long id) {
        Cliente cliente = clienteService.findById(id);
        return cliente;
    }

    @GetMapping("clientes/{nombre}")
    public List<Cliente> getByNombre(@PathVariable String nombre) {
        List<Cliente> clientes = clienteService.findByNombre(nombre);
        return clientes;
    }
}
