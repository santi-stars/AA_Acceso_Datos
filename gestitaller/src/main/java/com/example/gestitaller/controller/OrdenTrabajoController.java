package com.example.gestitaller.controller;

import com.example.gestitaller.domain.OrdenTrabajo;
import com.example.gestitaller.exception.ErrorResponse;
import com.example.gestitaller.exception.OrdenNotFoundException;
import com.example.gestitaller.service.OrdenTrabajoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdenTrabajoController {

    @Autowired
    private OrdenTrabajoService ordenTrabajoService;

    private final Logger logger = LoggerFactory.getLogger(OrdenTrabajoController.class);

    @GetMapping("/ordenes")
    public List<OrdenTrabajo> getOrdenes() {
        logger.info("Inicio getOrdenes");
        List<OrdenTrabajo> ordenes = ordenTrabajoService.findAll();
        logger.info("Fin getOrdenes");
        return ordenes;
    }

    @GetMapping("/orden/{id}")
    public OrdenTrabajo getById(@PathVariable long id) throws OrdenNotFoundException {
        logger.info("Inicio getById " + id);
        OrdenTrabajo orden = ordenTrabajoService.findById(id);
        logger.info("Fin getById " + id);
        return orden;
    }

    @GetMapping("/ordenes/{ejecutada}")
    public List<OrdenTrabajo> getByEjecutada(@PathVariable boolean ejecutada) throws OrdenNotFoundException {
        logger.info("Inicio getByEjecutada " + ejecutada);
        List<OrdenTrabajo> ordenes = ordenTrabajoService.findByEjecutada(ejecutada);
        logger.info("Fin getByEjecutada " + ejecutada);
        return ordenes;
    }

    @DeleteMapping("/orden/{id}")
    public OrdenTrabajo deleteOrden(@PathVariable long id) throws OrdenNotFoundException {
        logger.info("Inicio deleteOrden " + id);
        OrdenTrabajo orden = ordenTrabajoService.deleteOrden(id);
        logger.info("Fin deleteOrden " + id);
        return orden;
    }

    @PostMapping("/orden")
    public OrdenTrabajo addOrden(@RequestBody OrdenTrabajo orden) {
        logger.info("Inicio addOrden");
        OrdenTrabajo newOrden = ordenTrabajoService.addOrden(orden);
        logger.info("Fin addOrden");
        return newOrden;
    }

    @PutMapping("/orden/{id}")
    public OrdenTrabajo modifyOrden(@RequestBody OrdenTrabajo orden, @PathVariable long id) throws OrdenNotFoundException {
        logger.info("Inicio modifyOrden " + id);
        OrdenTrabajo newOrden = ordenTrabajoService.modifyOrden(id, orden);
        logger.info("Fin modifyOrden " + id);
        return newOrden;
    }

    @ExceptionHandler(OrdenNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBikeNotFoundException(OrdenNotFoundException onfe) {
        ErrorResponse errorResponse = new ErrorResponse("404", onfe.getMessage());
        logger.info(onfe.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OrdenNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse("999", "Internal server error");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
