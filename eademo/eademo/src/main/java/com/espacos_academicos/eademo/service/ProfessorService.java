package com.espacos_academicos.eademo.service;

import com.espacos_academicos.eademo.entity.Professores;
import com.espacos_academicos.eademo.repository.ProfessoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessoresRepository professoresRepository;

    /**
     * Atualiza os dados de um professor pelo ID.
     * @param id ID do professor a ser atualizado.
     * @param professorAtualizado Objeto contendo os novos dados do professor.
     * @return Objeto atualizado ou null se o professor não for encontrado.
     */
    public Professores atualizarProfessor(Long id, Professores professorAtualizado) {
        Optional<Professores> professorOpt = professoresRepository.findById(id);
        if (professorOpt.isPresent()) {
            Professores professor = professorOpt.get();
            professor.setNome(professorAtualizado.getNome());
            professor.setEmail(professorAtualizado.getEmail());
            professor.setCurso(professorAtualizado.getCurso());
            return professoresRepository.save(professor);
        }
        return null; // Retorno null caso o professor não seja encontrado
    }

    /**
     * Exclui um professor pelo ID.
     * @param id ID do professor a ser excluído.
     * @return true se o professor foi excluído, false se não foi encontrado.
     */
    public boolean excluirProfessor(Long id) {
        if (professoresRepository.existsById(id)) {
            professoresRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
