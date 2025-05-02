package com.espacos_academicos.eademo.controller;

import com.espacos_academicos.eademo.entity.Reservas;
import com.espacos_academicos.eademo.repository.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin(origins = "*")
public class ReservasController {

    @Autowired
    private ReservasRepository reservasRepository;

    @GetMapping
    public List<Reservas> listarReservas() {
        return reservasRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Reservas> criarReserva(@RequestBody Reservas reserva) {
        // Se necessário, aqui podem ser adicionadas validações (por exemplo, verificação de conflitos)
        Reservas novaReserva = reservasRepository.save(reserva);
        // Retorna HTTP 201 (Created) e o objeto salvo
        return ResponseEntity.status(HttpStatus.CREATED).body(novaReserva);
    }
}
