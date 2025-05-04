package com.petadoption.petportal.controller;

import com.petadoption.petportal.model.Pet;
import com.petadoption.petportal.service.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/pets")
    public String getPets(Model model) {
        model.addAttribute("pets", petService.getAllPets());
        return "pet_list"; // Shows a list of pets available for adoption
    }

    @GetMapping("/addPet")
    public String showAddPetPage() {
        return "add_pet"; // Show a page for staff to add pets
    }

    @PostMapping("/addPet")
    public String addPet(Pet pet) {
        petService.savePet(pet);
        return "redirect:/pets"; // Redirect to the pet list after adding
    }

    @PostMapping("/removePet")
    public String removePet(Long id) {
        petService.deletePet(id);
        return "redirect:/pets"; // Redirect to the pet list after removing
    }
}
