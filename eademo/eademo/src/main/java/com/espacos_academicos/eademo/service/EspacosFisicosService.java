package com.espacos_academicos.eademo.service;

import com.espacos_academicos.eademo.entity.EspacosFisicos;
import com.espacos_academicos.eademo.repository.EspacosFisicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspacosFisicosService {

    @Autowired
    private EspacosFisicosRepository espacosFisicosRepository;

    public List<EspacosFisicos> listarEspacos() {
        return espacosFisicosRepository.findAll();
    }

    public Optional<EspacosFisicos> buscarPorId(Long id) {
        return espacosFisicosRepository.findById(id);
    }

    public EspacosFisicos criarEspaco(EspacosFisicos espaco) {
        // Aqui você pode adicionar validações ou outra lógica
        return espacosFisicosRepository.save(espaco);
    }

    public EspacosFisicos atualizarEspaco(Long id, EspacosFisicos espacoAtualizado) {
        return espacosFisicosRepository.findById(id)
                .map(espaco -> {
                    espaco.setNome(espacoAtualizado.getNome());
                    espaco.setTipo(espacoAtualizado.getTipo());
                    espaco.setCapacidade(espacoAtualizado.getCapacidade());
                    return espacosFisicosRepository.save(espaco);
                })
                .orElseThrow(() -> new RuntimeException("Espaço não encontrado."));
    }

    public void excluirEspaco(Long id) {
        espacosFisicosRepository.deleteById(id);
    }
}
