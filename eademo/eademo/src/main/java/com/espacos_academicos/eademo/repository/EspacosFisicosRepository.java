package com.espacos_academicos.eademo.repository;

import com.espacos_academicos.eademo.entity.EspacosFisicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspacosFisicosRepository extends JpaRepository<EspacosFisicos, Long> {
}
