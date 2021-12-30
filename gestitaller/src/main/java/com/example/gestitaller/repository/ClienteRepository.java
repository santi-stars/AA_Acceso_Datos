package com.example.gestitaller.repository;

import com.example.gestitaller.domain.Cliente;
import com.example.gestitaller.domain.Mecanico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    List<Cliente> findAll();

    Cliente findById(long id);

    List<Cliente> findByNombre(String nombre);
}
