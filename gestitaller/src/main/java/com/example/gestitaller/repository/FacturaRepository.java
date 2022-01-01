package com.example.gestitaller.repository;

import com.example.gestitaller.domain.Cliente;
import com.example.gestitaller.domain.Factura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacturaRepository extends CrudRepository <Factura, Long> {
    List<Factura> findAll();

    List<Factura> findByPagada(boolean pagada);

    List<Factura> findByCliente(Cliente cliente);
}
