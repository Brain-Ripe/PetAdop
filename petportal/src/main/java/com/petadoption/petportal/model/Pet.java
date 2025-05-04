package com.petadoption.petportal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Pet {

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    //@Column(nullable = true) // or @Column(nullable = false) if you expect a value
    private Integer age;

    
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
