package com.example.SpringSecurity.Services;

import com.example.SpringSecurity.Models.User;
import com.example.SpringSecurity.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> list = new ArrayList<>();
    public UserService(){
        list.add(new User("sanvu08","abc","sanvu@gmail.com"));
        list.add(new User("ritu08","ritu12","ritu@gmail.com"));
        list.add(new User("abcd","bihaea3","bihar@gmail.com"));
        list.add(new User("patna","patna123","patn@gmail.com"));
    }
//    @Autowired
//    private UserRepository userRepository;

    public String addUser(User user){
        //userRepository.save(user);
        return "New user has been created.";
    }

    public List<User> getAll(){
        return list;
        //return userRepository.findAll();
    }

    public User getOne(String username){
        //List<User> list = userRepository.findAll();
        return list.stream().filter((user -> user.getUsername().equals(username)))
                .findAny().orElse(null);
    }
}
