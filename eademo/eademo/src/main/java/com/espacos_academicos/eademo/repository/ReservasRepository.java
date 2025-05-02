package com.espacos_academicos.eademo.repository;

import com.espacos_academicos.eademo.entity.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservasRepository extends JpaRepository<Reservas, Long> {
    List<Reservas> findByDataAndEspaco(LocalDate data, String espaco);
}
