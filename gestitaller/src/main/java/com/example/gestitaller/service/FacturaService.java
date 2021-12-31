package com.example.gestitaller.service;

import com.example.gestitaller.domain.Factura;
import com.example.gestitaller.exception.FacturaNotFoundException;

import java.util.List;

public interface FacturaService {

    List<Factura> findAll();

    Factura findById(long id) throws FacturaNotFoundException;

    List<Factura> findByPagada(boolean pagada) throws FacturaNotFoundException;

    Factura deleteFactura(long id) throws FacturaNotFoundException;

    Factura addFactura(Factura factura);

    Factura modifyFactura(long id, Factura factura) throws FacturaNotFoundException;
}
