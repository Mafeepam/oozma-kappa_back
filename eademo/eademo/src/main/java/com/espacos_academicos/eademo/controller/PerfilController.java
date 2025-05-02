package com.espacos_academicos.eademo.controller;

import com.espacos_academicos.eademo.dto.PerfilDTO;
import com.espacos_academicos.eademo.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping("/{id}")
    public ResponseEntity<PerfilDTO> getPerfil(@PathVariable Long id) {
        PerfilDTO perfil = perfilService.buscarPerfilPorId(id);
        return ResponseEntity.ok(perfil);
    }
}
