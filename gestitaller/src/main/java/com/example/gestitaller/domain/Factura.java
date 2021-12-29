package com.example.gestitaller.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "factura")
public class Factura {

    @Id
    public long id;
    @Column
    public LocalDate fechaFactura;
    @Column
    public long idRecambio;
    @Column
    public int cantidad;
    @Column
    public boolean pagada;
    @Column
    public long idCliente;
    @Column
    public long idMoto;

}
