package com.example.gestitaller.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "moto")
public class Moto {

    @Id
    public long id;
    @Column
    public String marca;
    @Column
    public String modelo;
    @Column
    public float cilindrada;
    @Column
    public LocalDate fechaMatriculacion;
    @Column
    public long idCliente;

}
