package com.example.gestitaller.controller;

import com.example.gestitaller.domain.Cliente;
import com.example.gestitaller.domain.Factura;
import com.example.gestitaller.service.ClienteService;
import com.example.gestitaller.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping("/facturas")
    public List<Factura> getFacturas() {
        List<Factura> facturas = facturaService.findAll();
        return facturas;
    }

    @GetMapping("factura/{id}")
    public Factura getById(@PathVariable long id) {
        Factura factura = facturaService.findById(id);
        return factura;
    }

    @GetMapping("facturas/{pagada}")
    public List<Factura> getByPagada(@PathVariable boolean pagada) {
        List<Factura> facturas = facturaService.findByPagada(pagada);
        return facturas;
    }
}
