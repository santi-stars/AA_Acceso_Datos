package com.example.gestitaller.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "recambio")
public class Recambio {

    @Id
    public long id;
    @Column
    public String descripcion;
    @Column
    public float precio;
    @Column
    public int cantidadStock;
    @Column
    public int cantidadMinima;
    @Column
    public LocalDate fechaEntrada;

}
