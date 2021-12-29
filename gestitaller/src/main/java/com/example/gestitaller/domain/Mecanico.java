package com.example.gestitaller.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "mecanico")
public class Mecanico {

    @Id
    public long id;
    @Column
    public String nombre;
    @Column
    public String apellido;
    @Column
    public int edad;
    @Column
    public String dni;
    @Column
    public boolean disponible;
    @Column
    public LocalDate fechaContratacion;

}
