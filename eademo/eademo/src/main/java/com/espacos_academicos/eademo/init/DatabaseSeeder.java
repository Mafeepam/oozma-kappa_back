package com.espacos_academicos.eademo.init;

import com.espacos_academicos.eademo.entity.Usuario;
import com.espacos_academicos.eademo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        if (usuarioRepository.count() == 0) {
            // Criando usuário Admin
            Usuario admin = new Usuario();
            admin.setEmail("admin@ucsal.br");
            admin.setSenha("admin123");
            admin.setFuncao("admin");
            usuarioRepository.save(admin);

            // Criando usuário Professor
            Usuario professor = new Usuario();
            professor.setEmail("fernando.borges@pro.ucsal.br");
            professor.setSenha("1234");
            professor.setFuncao("professor");
            usuarioRepository.save(professor);

            System.out.println("Usuários semeados com sucesso!");
        }
    }
}
