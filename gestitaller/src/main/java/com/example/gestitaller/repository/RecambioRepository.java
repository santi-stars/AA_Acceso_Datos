package com.example.gestitaller.repository;

import com.example.gestitaller.domain.Recambio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecambioRepository extends CrudRepository<Recambio, Long> {
    List<Recambio> findAll();

    List<Recambio> findByCantidadStock(int cantidadStock);
}
