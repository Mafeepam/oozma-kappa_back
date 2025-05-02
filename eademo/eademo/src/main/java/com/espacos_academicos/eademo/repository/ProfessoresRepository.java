package com.espacos_academicos.eademo.repository;

import com.espacos_academicos.eademo.entity.Professores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessoresRepository extends JpaRepository<Professores, Long> {
    Optional<Professores> findByEmail(String email);
}
