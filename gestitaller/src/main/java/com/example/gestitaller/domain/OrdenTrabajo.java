package com.example.gestitaller.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orden_trabajo")
public class OrdenTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column
    public boolean ejecutada;
    @Column(name = "fecha_orden")
    public LocalDate fechaOrden;
    @Column(name = "id_mecanico")
    public long idMecanico;
    @Column(name = "id_factura")
    public long idFactura;
    @Column(name = "id_moto")
    public long idMoto;

}
