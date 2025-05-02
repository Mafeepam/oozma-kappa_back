package com.espacos_academicos.eademo.controller;

import com.espacos_academicos.eademo.entity.Professores;
import com.espacos_academicos.eademo.repository.ProfessoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/professores")
@CrossOrigin(origins = "*")
public class ProfessoresController {

    @Autowired
    private ProfessoresRepository professoresRepository;

    @PutMapping("/{id}")
    public ResponseEntity<Professores> atualizarProfessor(@PathVariable Long id, @RequestBody Professores professorAtualizado) {
        return professoresRepository.findById(id)
                .map(professor -> {
                    professor.setNome(professorAtualizado.getNome());
                    professor.setEmail(professorAtualizado.getEmail());
                    professor.setCurso(professorAtualizado.getCurso());
                    return ResponseEntity.ok(professoresRepository.save(professor));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProfessor(@PathVariable Long id) {
        if (professoresRepository.existsById(id)) {
            professoresRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

