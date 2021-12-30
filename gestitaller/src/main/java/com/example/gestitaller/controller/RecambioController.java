package com.example.gestitaller.controller;

import com.example.gestitaller.domain.Cliente;
import com.example.gestitaller.domain.OrdenTrabajo;
import com.example.gestitaller.domain.Recambio;
import com.example.gestitaller.service.ClienteService;
import com.example.gestitaller.service.RecambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/recambio/{id}")
    public Recambio getById(@PathVariable long id) {
        Recambio recambio = recambioService.findById(id);
        return recambio;
    }

    @GetMapping("/recambios/{cantidad}")
    public List<Recambio> getByCantidadStock(@PathVariable int cantidad) {
        List<Recambio> recambios = recambioService.findByCantidadStock(cantidad);
        return recambios;
    }

    @DeleteMapping("/recambio/{id}")
    public Recambio deleteOrden(@PathVariable long id) {
        Recambio recambio = recambioService.deleteRecambio(id);
        return recambio;
    }

    @PostMapping("/recambio")
    public Recambio addOrden(@RequestBody Recambio recambio) {
        Recambio newRecambio = recambioService.addRecambio(recambio);
        return newRecambio;
    }

    @PutMapping("/recambio/{id}")
    public Recambio modifyOrden(@RequestBody Recambio recambio, @PathVariable long id) {
        Recambio newRecambio = recambioService.modifyRecambio(id, recambio);
        return newRecambio;
    }
}
