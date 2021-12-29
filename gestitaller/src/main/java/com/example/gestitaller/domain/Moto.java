package com.example.gestitaller.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "moto")
public class Moto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column
    public String marca;
    @Column
    public String modelo;
    @Column
    public float cilindrada;
    @Column(name = "fecha_matriculacion")
    public LocalDate fechaMatriculacion;
    @Column(name = "id_cliente")
    public long idCliente;

}
