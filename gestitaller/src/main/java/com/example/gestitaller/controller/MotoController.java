package com.example.gestitaller.controller;

import com.example.gestitaller.domain.Cliente;
import com.example.gestitaller.domain.Moto;
import com.example.gestitaller.service.ClienteService;
import com.example.gestitaller.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MotoController {

    @Autowired
    private MotoService motoService;

    @GetMapping("/motos")
    public List<Moto> getMotos() {
        List<Moto> motos = motoService.findAll();
        return motos;
    }

    @GetMapping("/moto/{id}")
    public Moto getById(@PathVariable long id) {
        Moto moto = motoService.findById(id);
        return moto;
    }

    @GetMapping("/motos/{marca}")
    public List<Moto> getByMarca(@PathVariable String marca) {
        List<Moto> motos = motoService.findByMarca(marca);
        return motos;
    }

    @DeleteMapping("/moto/{id}")
    public Moto deleteMoto(@PathVariable long id) {
        Moto moto = motoService.deleteMoto(id);
        return moto;
    }

    @PostMapping("/moto")
    public Moto addMoto(@RequestBody Moto moto) {
        Moto newMoto = motoService.addMoto(moto);
        return newMoto;
    }

    @PutMapping("/moto/{id}")
    public Moto modifyMoto(@RequestBody Moto moto, @PathVariable long id) {
        Moto newMoto = motoService.modifyMoto(id, moto);
        return newMoto;
    }
}
