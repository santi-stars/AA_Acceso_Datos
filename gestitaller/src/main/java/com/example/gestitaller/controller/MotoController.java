package com.example.gestitaller.controller;

import com.example.gestitaller.domain.Cliente;
import com.example.gestitaller.domain.Moto;
import com.example.gestitaller.exception.ClienteNotFoundException;
import com.example.gestitaller.exception.ErrorResponse;
import com.example.gestitaller.exception.MotoNotFoundException;
import com.example.gestitaller.service.ClienteService;
import com.example.gestitaller.service.MotoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MotoController {

    @Autowired
    private MotoService motoService;

    private final Logger logger = LoggerFactory.getLogger(MotoController.class);

    @GetMapping("/motos")
    public List<Moto> getMotos() {
        List<Moto> motos = motoService.findAll();
        return motos;
    }

    @GetMapping("/moto/{id}")
    public Moto getById(@PathVariable long id) throws MotoNotFoundException {
        Moto moto = motoService.findById(id);
        return moto;
    }

    @GetMapping("/motos/{marca}")
    public List<Moto> getByMarca(@PathVariable String marca) throws MotoNotFoundException {
        List<Moto> motos = motoService.findByMarca(marca);
        return motos;
    }

    @DeleteMapping("/moto/{id}")
    public Moto deleteMoto(@PathVariable long id) throws MotoNotFoundException {
        Moto moto = motoService.deleteMoto(id);
        return moto;
    }

    @PostMapping("/moto")
    public Moto addMoto(@RequestBody Moto moto) {
        Moto newMoto = motoService.addMoto(moto);
        return newMoto;
    }

    @PutMapping("/moto/{id}")
    public Moto modifyMoto(@RequestBody Moto moto, @PathVariable long id) throws MotoNotFoundException {
        Moto newMoto = motoService.modifyMoto(id, moto);
        return newMoto;
    }

    @ExceptionHandler(MotoNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBikeNotFoundException(MotoNotFoundException mnfe) {
        ErrorResponse errorResponse = new ErrorResponse("404", mnfe.getMessage());
        logger.info(mnfe.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MotoNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse("999", "Internal server error");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
