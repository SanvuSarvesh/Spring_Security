package com.example.SpringSecurity.Controllers;

import com.example.SpringSecurity.Models.User;
import com.example.SpringSecurity.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add_user")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/getOne")
    public User getById(@RequestParam String username){
        return userService.getOne(username);
    }
}
