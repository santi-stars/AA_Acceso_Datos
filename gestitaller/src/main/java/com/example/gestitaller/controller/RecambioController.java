package com.example.gestitaller.controller;

import com.example.gestitaller.domain.Cliente;
import com.example.gestitaller.domain.OrdenTrabajo;
import com.example.gestitaller.domain.Recambio;
import com.example.gestitaller.exception.ClienteNotFoundException;
import com.example.gestitaller.exception.ErrorResponse;
import com.example.gestitaller.exception.RecambioNotFoundException;
import com.example.gestitaller.service.ClienteService;
import com.example.gestitaller.service.RecambioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecambioController {

    @Autowired
    private RecambioService recambioService;

    private final Logger logger = LoggerFactory.getLogger(RecambioController.class);

    @GetMapping("/recambios")
    public List<Recambio> getRecambios() {
        List<Recambio> recambios = recambioService.findAll();
        return recambios;
    }

    @GetMapping("/recambio/{id}")
    public Recambio getById(@PathVariable long id) throws RecambioNotFoundException {
        Recambio recambio = recambioService.findById(id);
        return recambio;
    }

    @GetMapping("/recambios/{cantidad}")
    public List<Recambio> getByCantidadStock(@PathVariable int cantidad) throws RecambioNotFoundException {
        List<Recambio> recambios = recambioService.findByCantidadStock(cantidad);
        return recambios;
    }

    @DeleteMapping("/recambio/{id}")
    public Recambio deleteOrden(@PathVariable long id) throws RecambioNotFoundException {
        Recambio recambio = recambioService.deleteRecambio(id);
        return recambio;
    }

    @PostMapping("/recambio")
    public Recambio addOrden(@RequestBody Recambio recambio) {
        Recambio newRecambio = recambioService.addRecambio(recambio);
        return newRecambio;
    }

    @PutMapping("/recambio/{id}")
    public Recambio modifyOrden(@RequestBody Recambio recambio, @PathVariable long id) throws RecambioNotFoundException {
        Recambio newRecambio = recambioService.modifyRecambio(id, recambio);
        return newRecambio;
    }

    @ExceptionHandler(RecambioNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBikeNotFoundException(RecambioNotFoundException rnfe) {
        ErrorResponse errorResponse = new ErrorResponse("404", rnfe.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RecambioNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse("999", "Internal server error");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
