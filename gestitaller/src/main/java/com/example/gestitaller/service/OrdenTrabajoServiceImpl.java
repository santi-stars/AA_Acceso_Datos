package com.example.gestitaller.service;

import com.example.gestitaller.domain.Factura;
import com.example.gestitaller.domain.Mecanico;
import com.example.gestitaller.domain.Moto;
import com.example.gestitaller.domain.OrdenTrabajo;
import com.example.gestitaller.domain.dto.OrdenTrabajoDTO;
import com.example.gestitaller.exception.FacturaNotFoundException;
import com.example.gestitaller.exception.MecanicoNotFoundException;
import com.example.gestitaller.exception.MotoNotFoundException;
import com.example.gestitaller.exception.OrdenNotFoundException;
import com.example.gestitaller.repository.FacturaRepository;
import com.example.gestitaller.repository.MecanicoRepository;
import com.example.gestitaller.repository.MotoRepository;
import com.example.gestitaller.repository.OrdenTrabajoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenTrabajoServiceImpl implements OrdenTrabajoService {

    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private OrdenTrabajoRepository ordenTrabajoRepository;
    @Autowired
    private MecanicoRepository mecanicoRepository;
    @Autowired
    private MotoRepository motoRepository;

    @Override
    public List<OrdenTrabajo> findAll() {
        return ordenTrabajoRepository.findAll();
    }

    @Override
    public OrdenTrabajo findById(long id) throws OrdenNotFoundException {
        return ordenTrabajoRepository.findById(id).orElseThrow(OrdenNotFoundException::new);
    }

    @Override
    public List<OrdenTrabajo> findByEjecutada(boolean ejecutada) {
        return ordenTrabajoRepository.findByEjecutada(ejecutada);
    }

    @Override
    public OrdenTrabajo deleteOrden(long id) throws OrdenNotFoundException {
        OrdenTrabajo mecanico = ordenTrabajoRepository.findById(id).orElseThrow(OrdenNotFoundException::new);
        ordenTrabajoRepository.delete(mecanico);
        return mecanico;
    }

    @Override
    public OrdenTrabajo addOrden(OrdenTrabajoDTO newOrdenTrabajoDTO) throws
            MecanicoNotFoundException, MotoNotFoundException {

        Moto moto = motoRepository.findById(newOrdenTrabajoDTO.getMoto())
                .orElseThrow(MotoNotFoundException::new);

        Mecanico mecanico = mecanicoRepository.findById(newOrdenTrabajoDTO.getMecanico())
                .orElseThrow(MecanicoNotFoundException::new);

        ModelMapper mapper = new ModelMapper();
        OrdenTrabajo ordenTrabajo = mapper.map(newOrdenTrabajoDTO, OrdenTrabajo.class);
        ordenTrabajo.setMecanico(mecanico);
        ordenTrabajo.setMoto(moto);

        return ordenTrabajoRepository.save(ordenTrabajo);
    }

    @Override
    public OrdenTrabajo modifyOrden(long id, OrdenTrabajoDTO newOrdenTrabajoDTO) throws
            MecanicoNotFoundException, MotoNotFoundException {

        Moto moto = motoRepository.findById(newOrdenTrabajoDTO.getMoto())
                .orElseThrow(MotoNotFoundException::new);

        Mecanico mecanico = mecanicoRepository.findById(newOrdenTrabajoDTO.getMecanico())
                .orElseThrow(MecanicoNotFoundException::new);

        ModelMapper mapper = new ModelMapper();
        OrdenTrabajo ordenTrabajo = mapper.map(newOrdenTrabajoDTO, OrdenTrabajo.class);
        ordenTrabajo.setId(id);
        ordenTrabajo.setMecanico(mecanico);
        ordenTrabajo.setMoto(moto);

        return ordenTrabajoRepository.save(ordenTrabajo);
    }

    @Override
    public OrdenTrabajo modifyOrdenEjecutada(long id, boolean ejecutada) throws OrdenNotFoundException {
        OrdenTrabajo ordenTrabajo = ordenTrabajoRepository.findById(id).orElseThrow(OrdenNotFoundException::new);
        ordenTrabajo.setEjecutada(ejecutada);
        return ordenTrabajoRepository.save(ordenTrabajo);
    }
}
