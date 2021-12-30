package com.example.gestitaller.service;

import com.example.gestitaller.domain.Cliente;
import com.example.gestitaller.domain.Factura;
import com.example.gestitaller.domain.Mecanico;

import java.util.List;

public interface FacturaService {

    List<Factura> findAll();

    Factura findById(long id);

    List<Factura> findByPagada(boolean pagada);

    Factura deleteFactura(long id);

    Factura addFactura(Factura factura);

    Factura modifyFactura(long id, Factura factura);
}
