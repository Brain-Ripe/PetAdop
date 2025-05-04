package com.petadoption.petportal.repository;

import com.petadoption.petportal.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
