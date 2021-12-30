package com.example.gestitaller.controller;

import com.example.gestitaller.domain.Mecanico;
import com.example.gestitaller.repository.MecanicoRepository;
import com.example.gestitaller.service.MecanicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MecanicoController {

    @Autowired
    private MecanicoService mecanicoService;

    @GetMapping("/mecanicos")
    public List<Mecanico> getMecanicos() {
        List<Mecanico> mecanicos = mecanicoService.findAll();
        return mecanicos;
    }

    @GetMapping("mecanico/{id}")
    public Mecanico getMecanico(@PathVariable long id){
        Mecanico mecanico= mecanicoService.findMecanico(id);
        return mecanico;
    }

    @GetMapping("mecanicos/{nombre}")
    public List<Mecanico> getMecanico(@PathVariable String nombre){
        List<Mecanico> mecanicos = mecanicoService.findByNombre(nombre);
        return mecanicos;
    }
}
