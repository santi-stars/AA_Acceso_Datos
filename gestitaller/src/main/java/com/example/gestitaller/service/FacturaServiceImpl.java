package com.example.gestitaller.service;

import com.example.gestitaller.domain.Cliente;
import com.example.gestitaller.domain.Factura;
import com.example.gestitaller.domain.Mecanico;
import com.example.gestitaller.exception.FacturaNotFoundException;
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
    public Factura findById(long id) throws FacturaNotFoundException {
        return facturaRepository.findById(id).orElseThrow(FacturaNotFoundException::new);
    }

    @Override
    public List<Factura> findByPagada(boolean pagada) {
        return facturaRepository.findByPagada(pagada);
    }

    @Override
    public Factura deleteFactura(long id) throws FacturaNotFoundException {
        Factura factura = facturaRepository.findById(id).orElseThrow(FacturaNotFoundException::new);
        facturaRepository.delete(factura);
        return factura;
    }

    @Override
    public Factura addFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    public Factura modifyFactura(long id, Factura newFactura) throws FacturaNotFoundException {
        Factura factura = facturaRepository.findById(id).orElseThrow(FacturaNotFoundException::new);
        factura.setFechaFactura(newFactura.getFechaFactura());
        factura.setIdRecambio(newFactura.getIdRecambio());
        factura.setCantidad(newFactura.getCantidad());
        factura.setPagada(newFactura.isPagada());
        factura.setIdCliente(newFactura.getIdCliente());
        factura.setIdMoto(newFactura.getIdMoto());

        return facturaRepository.save(factura);
    }

}
