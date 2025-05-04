package com.petadoption.petportal.controller;

import com.petadoption.petportal.model.Pet;
import com.petadoption.petportal.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/pets")
    public String viewPets(Model model) {
        model.addAttribute("pets", petService.getAllPets());
        return "adopt-pet";
    }

    @GetMapping("/pets/{id}")
    public String petDetails(@PathVariable Long id, Model model) {
        model.addAttribute("pet", petService.getPetById(id));
        return "pet-details";
    }

    @GetMapping("/pets/add")
    public String addPetForm(Model model) {
        model.addAttribute("pet", new Pet());
        return "add-pet";
    }

    @PostMapping("/pets/add")
    public String addPet(@ModelAttribute Pet pet) {
        petService.savePet(pet);
        return "redirect:/pets";
    }

    @GetMapping("/pets/delete/{id}")
    public String deletePet(@PathVariable Long id) {
        petService.deletePetById(id);
        return "redirect:/pets";
    }
}
