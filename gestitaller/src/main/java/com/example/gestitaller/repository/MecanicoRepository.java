package com.example.gestitaller.repository;

import com.example.gestitaller.domain.Mecanico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MecanicoRepository extends CrudRepository<Mecanico, Long> {
    List<Mecanico> findAll();

    List<Mecanico> findByNombre(String nombre);
}
