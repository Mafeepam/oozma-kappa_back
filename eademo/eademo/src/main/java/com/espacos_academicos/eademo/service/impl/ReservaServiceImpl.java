package com.espacos_academicos.eademo.service.impl;

import com.espacos_academicos.eademo.entity.Reservas;
import com.espacos_academicos.eademo.repository.ReservasRepository;
import com.espacos_academicos.eademo.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservasRepository reservasRepository;

    @Override
    public List<Reservas> buscarTodasReservas() {
        return reservasRepository.findAll();
    }

    @Override
    public Reservas criarReserva(Reservas reserva) {
        // Verifica se já existe reserva para o mesmo dia e espaço
        List<Reservas> reservasDoDia = reservasRepository.findByDataAndEspaco(reserva.getData(), reserva.getEspaco());

        // Validação simples: se existir uma reserva com mesmo horário, rejeita
        // (Você pode aprimorar essa lógica para verificar sobreposição de intervalos.)
        for (Reservas r : reservasDoDia) {
            if (r.getHoraInicio().equals(reserva.getHoraInicio()) && r.getHoraFim().equals(reserva.getHoraFim())) {
                throw new ResponseStatusException(HttpStatus.CONFLICT,
                        "Já existe uma reserva para este dia, horário e espaço.");
            }
        }
        return reservasRepository.save(reserva);
    }
}
