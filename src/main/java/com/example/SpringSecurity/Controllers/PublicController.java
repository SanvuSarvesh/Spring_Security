package com.example.SpringSecurity.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class PublicController {

    @GetMapping("/home")
    public String homePage(){
        return "This is our home page";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/login")
    public String loginPage(){
        return "This is our home page";
    }

    @GetMapping("/register")
    public String register(){
        return "This is our home page";
    }
}
