package com.espacos_academicos.eademo.controller;

import com.espacos_academicos.eademo.entity.Reservas;
import com.espacos_academicos.eademo.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reservas> listarReservas() {
        return reservaService.buscarTodasReservas();
    }

    @PostMapping
    public ResponseEntity<Reservas> criarReserva(@RequestBody Reservas reserva) {
        Reservas novaReserva = reservaService.criarReserva(reserva);
        return ResponseEntity.ok(novaReserva);
    }
}
