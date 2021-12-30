package com.example.gestitaller.controller;

import com.example.gestitaller.domain.Cliente;
import com.example.gestitaller.domain.Mecanico;
import com.example.gestitaller.service.ClienteService;
import com.example.gestitaller.service.MecanicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/cliente/{id}")
    public Cliente getById(@PathVariable long id) {
        Cliente cliente = clienteService.findById(id);
        return cliente;
    }

    @GetMapping("/clientes/{nombre}")
    public List<Cliente> getByNombre(@PathVariable String nombre) {
        List<Cliente> clientes = clienteService.findByNombre(nombre);
        return clientes;
    }

    @DeleteMapping("/cliente/{id}")
    public Cliente deleteCliente(@PathVariable long id) {
        Cliente cliente = clienteService.deleteCliente(id);
        return cliente;
    }

    @PostMapping("/cliente")
    public Cliente addCliente(@RequestBody Cliente cliente) {
        Cliente newCliente = clienteService.addCliente(cliente);
        return newCliente;
    }

    @PutMapping("/cliente/{id}")
    public Cliente modifyCliente(@RequestBody Cliente cliente, @PathVariable long id) {
        Cliente newCliente = clienteService.modifyCliente(id, cliente);
        return newCliente;
    }
}
