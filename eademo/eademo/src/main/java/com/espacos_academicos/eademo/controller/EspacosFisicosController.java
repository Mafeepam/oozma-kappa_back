package com.espacos_academicos.eademo.controller;

import com.espacos_academicos.eademo.entity.EspacosFisicos;
import com.espacos_academicos.eademo.repository.EspacosFisicosRepository;
import com.espacos_academicos.eademo.service.EspacosFisicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/espacos")
@CrossOrigin(origins = "*")
public class EspacosFisicosController {

    @Autowired
    private EspacosFisicosService espacosFisicosService;

    @GetMapping
    public List<EspacosFisicos> listarEspacos() {
        return espacosFisicosService.listarEspacos();
    }

    @PostMapping
    public ResponseEntity<EspacosFisicos> criarEspaco(@RequestBody EspacosFisicos espaco) {
        EspacosFisicos novoEspaco = espacosFisicosService.criarEspaco(espaco);
        return ResponseEntity.ok(novoEspaco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EspacosFisicos> atualizarEspaco(@PathVariable Long id, @RequestBody EspacosFisicos espacoAtualizado) {
        try {
            EspacosFisicos espaco = espacosFisicosService.atualizarEspaco(id, espacoAtualizado);
            return ResponseEntity.ok(espaco);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEspaco(@PathVariable Long id) {
        if (espacosFisicosService.buscarPorId(id).isPresent()) {
            espacosFisicosService.excluirEspaco(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspacosFisicos> buscarEspacoPorId(@PathVariable Long id) {
        return espacosFisicosService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
