package com.example.gestitaller.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    public Cliente cliente;
    @OneToMany(mappedBy = "moto")
    @JsonBackReference(value = "moto-factura")
    private List<Factura> facturas;
    @OneToMany(mappedBy = "moto")
    @JsonBackReference(value = "moto-orden_trabajo")
    private List<OrdenTrabajo> ordenTrabajos;

}
