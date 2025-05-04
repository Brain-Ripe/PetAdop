package com.petadoption.petportal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Static user credentials for testing purposes
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(auth -> auth
                .antMatchers("/", "/login", "/register", "/css/**", "/images/**").permitAll()
                .anyRequest().authenticated())
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard", true)
                .permitAll())
            .logout(logout -> logout
                .logoutSuccessUrl("/login").permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            // Here, we use the static username and password (admin/admin) for testing
            if (username.equals(USERNAME)) {
                return User.builder()
                    .username(USERNAME)
                    .password(passwordEncoder().encode(PASSWORD))  // Encoded static password
                    .roles("USER")  // You can add roles as needed
                    .build();
            }
            throw new UsernameNotFoundException("User not found");
        };
    }

    @Bean
    public AuthenticationManagerBuilder authenticationManagerBuilder(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = 
            http.getSharedObject(AuthenticationManagerBuilder.class);
        
        authenticationManagerBuilder
            .userDetailsService(userDetailsService())
            .passwordEncoder(passwordEncoder());
        
        return authenticationManagerBuilder;
    }
}
