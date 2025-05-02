package com.espacos_academicos.eademo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
public class ConfiguracaoSeguranca {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/admin/**").hasAuthority("admin")
                .requestMatchers("/api/professores/**").hasAuthority("professor")
                .anyRequest().permitAll()
            )
            .httpBasic(Customizer.withDefaults()); // ✅ forma correta para Spring Security 6+

        return http.build();
    }
}
