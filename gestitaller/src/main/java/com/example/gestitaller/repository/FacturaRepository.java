package com.example.gestitaller.repository;

import com.example.gestitaller.domain.Factura;
import com.example.gestitaller.domain.Mecanico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends CrudRepository <Factura, Long> {
    List<Factura> findAll();

    List<Factura> findByPagada(boolean pagada);
}
