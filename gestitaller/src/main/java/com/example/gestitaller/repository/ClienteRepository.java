package com.example.gestitaller.repository;

import com.example.gestitaller.domain.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    List<Cliente> findAll();

    List<Cliente> findByNombre(String nombre);

    List<Cliente> findByNombreOrApellidoOrDni(String nombre, String apellido, String dni);
}
