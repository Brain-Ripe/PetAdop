package com.petadoption.petportal.controller;

import org.springframework.ui.Model;


import com.petadoption.petportal.model.User;
import com.petadoption.petportal.service.UserService;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(User user) {
        return "signup";
    }

    @PostMapping("/register")
    public String register(User user) {
        userService.register(user);
        return "redirect:/login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Principal principal, Model model) {
        // Logic to show dashboard depending on role or just username
        model.addAttribute("username", principal.getName());
        return "home"; // or "customer" / "staff" depending on logic
    }

@GetMapping("/")
    public String redirectToHome() {
        return "redirect:/home";
    }
}
