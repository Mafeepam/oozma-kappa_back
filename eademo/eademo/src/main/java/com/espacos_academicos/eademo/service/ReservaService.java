package com.espacos_academicos.eademo.service;

import com.espacos_academicos.eademo.entity.Reservas;

import java.util.List;

public interface ReservaService {
    List<Reservas> buscarTodasReservas();
    Reservas criarReserva(Reservas reserva);
}
