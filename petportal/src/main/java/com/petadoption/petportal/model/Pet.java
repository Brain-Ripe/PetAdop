package com.petadoption.petportal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Pet {

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    
    private Long id;
    private String name;
    private String description;
    private boolean adopted;

    // ✅ JPA requires this no-arg constructor
    public Pet() {
    }

    public Pet(String name, String description, boolean adopted) {
        this.name = name;
        this.description = description;
        this.adopted = adopted;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isAdopted() { return adopted; }
    public void setAdopted(boolean adopted) { this.adopted = adopted; }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", adopted=" + adopted +
                '}';
    }
}
