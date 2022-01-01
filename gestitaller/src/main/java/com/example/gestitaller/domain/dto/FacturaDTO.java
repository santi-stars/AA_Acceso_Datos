package com.example.gestitaller.domain.dto;

import com.example.gestitaller.domain.Cliente;
import com.example.gestitaller.domain.Moto;
import com.example.gestitaller.domain.OrdenTrabajo;
import com.example.gestitaller.domain.Recambio;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class FacturaDTO {

    private LocalDate fechaFactura;
    private long recambio;
    private int cantidad;
    private boolean pagada;
    private long cliente;
    private long moto;
    private long ordenTrabajo;
}
