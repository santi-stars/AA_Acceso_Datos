package com.example.gestitaller.service;

import com.example.gestitaller.domain.Factura;
import com.example.gestitaller.domain.Mecanico;
import com.example.gestitaller.repository.FacturaRepository;
import com.example.gestitaller.repository.MecanicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public List<Factura> findAll() {
        return facturaRepository.findAll();
    }

    @Override
    public Factura findById(long id) {
        return facturaRepository.findById(id);
    }

    @Override
    public List<Factura> findByPagada(boolean pagada) {
        return facturaRepository.findByPagada(pagada);
    }

    @Override
    public void addFactura(Factura factura) {

    }
}
