package com.petadoption.petportal.service;

import com.petadoption.petportal.model.Pet;
import com.petadoption.petportal.repository.PetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;


    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Iterable<Pet> getAllPets() {
        return petRepository.findAll();  // Get all pets from the DB
    }

    public Pet savePet(Pet pet) {
        return petRepository.save(pet);  // Save a new pet to the DB
    }

    public void deletePet(Long id) {
        petRepository.deleteById(id);  // Remove pet by id from the DB
    }
}
