package com.example.gestitaller.controller;

import com.example.gestitaller.domain.Cliente;
import com.example.gestitaller.domain.Moto;
import com.example.gestitaller.domain.OrdenTrabajo;
import com.example.gestitaller.repository.OrdenTrabajoRepository;
import com.example.gestitaller.service.ClienteService;
import com.example.gestitaller.service.OrdenTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdenTrabajoController {

    @Autowired
    private OrdenTrabajoService ordenTrabajoService;

    @GetMapping("/ordenes")
    public List<OrdenTrabajo> getOrdenes() {
        List<OrdenTrabajo> ordenes = ordenTrabajoService.findAll();
        return ordenes;
    }

    @GetMapping("/orden/{id}")
    public OrdenTrabajo getById(@PathVariable long id) {
        OrdenTrabajo orden = ordenTrabajoService.findById(id);
        return orden;
    }

    @GetMapping("/ordenes/{ejecutada}")
    public List<OrdenTrabajo> getByEjecutada(@PathVariable boolean ejecutada) {
        List<OrdenTrabajo> ordenes = ordenTrabajoService.findByEjecutada(ejecutada);
        return ordenes;
    }

    @DeleteMapping("/orden/{id}")
    public OrdenTrabajo deleteOrden(@PathVariable long id) {
        OrdenTrabajo orden = ordenTrabajoService.deleteOrden(id);
        return orden;
    }

    @PostMapping("/orden")
    public OrdenTrabajo addOrden(@RequestBody OrdenTrabajo orden) {
        OrdenTrabajo newOrden = ordenTrabajoService.addOrden(orden);
        return newOrden;
    }

    @PutMapping("/orden/{id}")
    public OrdenTrabajo modifyOrden(@RequestBody OrdenTrabajo orden, @PathVariable long id) {
        OrdenTrabajo newOrden = ordenTrabajoService.modifyOrden(id, orden);
        return newOrden;
    }
}
