package com.petadoption.petportal;

import com.petadoption.petportal.model.Pet;
import com.petadoption.petportal.repository.PetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.petadoption.petportal.model")
@EnableJpaRepositories(basePackages = "com.petadoption.petportal.repository")
public class PetportalApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetportalApplication.class, args);
    }

    @Bean
    CommandLineRunner run(PetRepository petRepository) {
        return args -> {
            petRepository.save(new Pet("Buddy", "Friendly Dog", false));
            petRepository.save(new Pet("Mittens", "Cute Cat", false));

            petRepository.findAll().forEach(System.out::println);
        };
    }
}
