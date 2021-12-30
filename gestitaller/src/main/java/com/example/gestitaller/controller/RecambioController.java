package com.example.gestitaller.controller;

import com.example.gestitaller.domain.Cliente;
import com.example.gestitaller.domain.Recambio;
import com.example.gestitaller.service.ClienteService;
import com.example.gestitaller.service.RecambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecambioController {

    @Autowired
    private RecambioService recambioService;

    @GetMapping("/recambios")
    public List<Recambio> getRecambios() {
        List<Recambio> recambios = recambioService.findAll();
        return recambios;
    }

    @GetMapping("recambio/{id}")
    public Recambio getById(@PathVariable long id) {
        Recambio cliente = recambioService.findById(id);
        return cliente;
    }

    @GetMapping("recambios/{cantidad}")
    public List<Recambio> getByCantidadStock(@PathVariable int cantidad) {
        List<Recambio> recambios = recambioService.findByCantidadStock(cantidad);
        return recambios;
    }
}
