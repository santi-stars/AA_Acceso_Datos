package com.example.gestitaller.controller;

import com.example.gestitaller.domain.Cliente;
import com.example.gestitaller.domain.OrdenTrabajo;
import com.example.gestitaller.repository.OrdenTrabajoRepository;
import com.example.gestitaller.service.ClienteService;
import com.example.gestitaller.service.OrdenTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("orden/{id}")
    public OrdenTrabajo getById(@PathVariable long id) {
        OrdenTrabajo orden = ordenTrabajoService.findById(id);
        return orden;
    }

    @GetMapping("ordenes/{ejecutada}")
    public List<OrdenTrabajo> getByEjecutada(@PathVariable boolean ejecutada) {
        List<OrdenTrabajo> ordenes = ordenTrabajoService.findByEjecutada(ejecutada);
        return ordenes;
    }
}
