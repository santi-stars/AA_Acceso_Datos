package com.example.gestitaller.controller;

import com.example.gestitaller.domain.Mecanico;
import com.example.gestitaller.exception.ErrorResponse;
import com.example.gestitaller.exception.MecanicoNotFoundException;
import com.example.gestitaller.service.MecanicoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MecanicoController {

    @Autowired
    private MecanicoService mecanicoService;

    private final Logger logger = LoggerFactory.getLogger(MecanicoController.class);

    @GetMapping("/mecanicos")   //http://localhost:8081/mecanicos?nombre=Santi
    public List<Mecanico> getMecanicos(@RequestParam(value = "nombre", defaultValue = "0") String nombre) throws MecanicoNotFoundException {
        List<Mecanico> mecanicos;

        if (nombre.equals("0")) {
            return mecanicos = mecanicoService.findAllMecanicos();
        } else {
            return mecanicos = mecanicoService.findByNombre(nombre);
        }
    }

    @GetMapping("/mecanico/{id}")
    public Mecanico getMecanico(@PathVariable long id) throws MecanicoNotFoundException {
        Mecanico mecanico = mecanicoService.findMecanico(id);
        return mecanico;
    }

    @GetMapping("/mecanicos/{nombre}")
    public List<Mecanico> getMecanico(@PathVariable String nombre) throws MecanicoNotFoundException {
        List<Mecanico> mecanicos = mecanicoService.findByNombre(nombre);
        return mecanicos;
    }

    @DeleteMapping("/mecanico/{id}")
    public Mecanico deleteMecanico(@PathVariable long id) throws MecanicoNotFoundException {
        Mecanico mecanico = mecanicoService.deleteMecanico(id);
        return mecanico;
    }

    @PostMapping("/mecanico")
    public Mecanico addMecanico(@RequestBody Mecanico mecanico) {
        Mecanico newMecanico = mecanicoService.addMecanico(mecanico);
        return newMecanico;
    }

    @PutMapping("/mecanico/{id}")
    public Mecanico modifyMecanico(@RequestBody Mecanico mecanico, @PathVariable long id) throws MecanicoNotFoundException {
        Mecanico newMecanico = mecanicoService.modifyMecanico(id, mecanico);
        return newMecanico;
    }

    @ExceptionHandler(MecanicoNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBikeNotFoundException(MecanicoNotFoundException mnfe) {
        ErrorResponse errorResponse = new ErrorResponse("404", mnfe.getMessage());
        logger.info(mnfe.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MecanicoNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse("999", "Internal server error");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
