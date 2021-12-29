package com.example.gestitaller.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "cliente")
public class Cliente {

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
    public String direccion;
    @Column
    public boolean clienteVip;

}
