package com.example.gestitaller.controller;

import com.example.gestitaller.domain.Mecanico;
import com.example.gestitaller.service.MecanicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MecanicoController {

    @Autowired
    private MecanicoService mecanicoService;

    @GetMapping("/mecanicos")   //http://localhost:8081/mecanicos?nombre=Santi
    public List<Mecanico> getMecanicos(@RequestParam(value = "nombre", defaultValue = "0") String nombre) {
        List<Mecanico> mecanicos;

        if (nombre.equals("0")) {
            return mecanicos = mecanicoService.findAllMecanicos();
        } else {
            return mecanicos = mecanicoService.findByNombre(nombre);
        }
    }

    @GetMapping("/mecanico/{id}")
    public Mecanico getMecanico(@PathVariable long id) {
        Mecanico mecanico = mecanicoService.findMecanico(id);
        return mecanico;
    }

    @GetMapping("/mecanicos/{nombre}")
    public List<Mecanico> getMecanico(@PathVariable String nombre) {
        List<Mecanico> mecanicos = mecanicoService.findByNombre(nombre);
        return mecanicos;
    }

    @DeleteMapping("/mecanico/{id}")
    public Mecanico deleteMecanico(@PathVariable long id) {
        Mecanico mecanico = mecanicoService.deleteMecanico(id);
        return mecanico;
    }

    @PostMapping("/mecanico")
    public Mecanico addMecanico(@RequestBody Mecanico mecanico) {
        Mecanico newMecanico = mecanicoService.addMecanico(mecanico);
        return newMecanico;
    }

    @PutMapping("/mecanico/{id}")
    public Mecanico modifyMecanico(@RequestBody Mecanico mecanico, @PathVariable long id) {
        Mecanico newMecanico = mecanicoService.modifyMecanico(id, mecanico);
        return newMecanico;
    }
}
