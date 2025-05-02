package com.espacos_academicos.eademo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservas", schema = "scea")
public class Reservas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Define o formato esperado para a data recebida via JSON (por exemplo, "2025-05-01")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate data;

    // Define o formato esperado para a hora de início (por exemplo, "08:00:00")
    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    // Define o formato esperado para a hora de término (por exemplo, "10:00:00")
    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "hora_fim", nullable = false)
    private LocalTime horaFim;

    @Column(nullable = false)
    private String espaco;

    // Construtor padrão (geralmente gerado implicitamente se não existir outro)
    public Reservas() { }

    // Getters e Setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) { this.id = id; }

    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) { this.data = data; }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }
    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }

    public LocalTime getHoraFim() {
        return horaFim;
    }
    public void setHoraFim(LocalTime horaFim) { this.horaFim = horaFim; }

    public String getEspaco() {
        return espaco;
    }
    public void setEspaco(String espaco) { this.espaco = espaco; }
}
