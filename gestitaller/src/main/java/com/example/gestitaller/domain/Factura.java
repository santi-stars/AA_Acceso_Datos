package com.example.gestitaller.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(name = "fecha_factura")
    public LocalDate fechaFactura;
    @Column(name = "id_recambio")
    public long idRecambio;
    @Column
    public int cantidad;
    @Column
    public boolean pagada;
    @Column(name = "id_cliente")
    public long idCliente;
    @Column(name = "id_moto")
    public long idMoto;

}
