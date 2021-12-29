package com.example.gestitaller.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "orden_trabajo")
public class OrdenTrabajo {

    @Id
    public long id;
    @Column
    public boolean ejecutada;
    @Column
    public LocalDate fechaOrden;
    @Column
    public long idMecanico;
    @Column
    public long idFactura;
    @Column
    public long idMoto;

}
