package com.espacos_academicos.eademo.service;

import com.espacos_academicos.eademo.dto.PerfilDTO;
import com.espacos_academicos.eademo.entity.Usuario;
import com.espacos_academicos.eademo.entity.Professores;
import com.espacos_academicos.eademo.repository.UsuarioRepository;
import com.espacos_academicos.eademo.repository.ProfessoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PerfilService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProfessoresRepository professoresRepository;

    public PerfilDTO buscarPerfilPorId(Long id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (!usuarioOpt.isPresent()) {
            throw new RuntimeException("Usuário não encontrado!");
        }
        Usuario usuario = usuarioOpt.get();

        Optional<Professores> professorOpt = professoresRepository.findByEmail(usuario.getEmail());

        PerfilDTO perfil = new PerfilDTO();
        perfil.setId(usuario.getId());
        perfil.setEmail(usuario.getEmail());
        perfil.setSenha(usuario.getSenha());
        perfil.setFuncao(usuario.getFuncao());

        if (professorOpt.isPresent()) {
            Professores professor = professorOpt.get();
            perfil.setNome(professor.getNome());
            perfil.setCurso(professor.getCurso());
            // perfil.setTelefone(professor.getTelefone()); // somente se o campo existir na entidade Professores
        }
        return perfil;
    }
}
