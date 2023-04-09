package com.example.SpringSecurity.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SignInController {
    @GetMapping("/signin")
    public String signInPage(){
        return "This is our signin page.";
    }
    // We have to add thymeleaf dependency
    // 02:04:10
}
