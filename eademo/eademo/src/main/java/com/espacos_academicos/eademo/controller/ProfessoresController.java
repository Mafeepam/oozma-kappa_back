package com.espacos_academicos.eademo.controller;

import com.espacos_academicos.eademo.entity.Professores;
import com.espacos_academicos.eademo.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/professores")
@CrossOrigin(origins = "*")
public class ProfessoresController {

    @Autowired
    private ProfessorService professorService;

    @PutMapping("/{id}")
    public ResponseEntity<Professores> atualizarProfessor(@PathVariable Long id, @RequestBody Professores professorAtualizado) {
        Professores atualizado = professorService.atualizarProfessor(id, professorAtualizado);
        return atualizado != null ? ResponseEntity.ok(atualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProfessor(@PathVariable Long id) {
        return professorService.excluirProfessor(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
