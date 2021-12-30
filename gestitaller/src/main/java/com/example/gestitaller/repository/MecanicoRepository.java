package com.example.gestitaller.repository;

import com.example.gestitaller.domain.Mecanico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MecanicoRepository extends CrudRepository<Mecanico, Long> {
    List<Mecanico> findAll();

    Mecanico findById(long id);

    List<Mecanico> findByNombre(String nombre);
}
