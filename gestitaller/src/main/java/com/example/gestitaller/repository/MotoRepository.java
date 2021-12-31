package com.example.gestitaller.repository;

import com.example.gestitaller.domain.Mecanico;
import com.example.gestitaller.domain.Moto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotoRepository extends CrudRepository<Moto, Long> {
    List<Moto> findAll();

    List<Moto> findByMarca(String marca);
}
