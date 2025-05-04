package com.petadoption.petportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";  // Returns login.html
    }

    @PostMapping("/perform_login")
    public String performLogin(@RequestParam String username, @RequestParam String password) {
        // Authentication logic goes here (e.g., check username and password)
        return "redirect:/home"; // After login, redirect to home
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";  // Returns home.html
    }
}
