
package com.espacos_academicos.eademo.repository;

import com.espacos_academicos.eademo.entity.Professores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessoresRepository extends JpaRepository<Professores, Long> {
    // aqui você pode adicionar métodos customizados depois, se quiser
}
