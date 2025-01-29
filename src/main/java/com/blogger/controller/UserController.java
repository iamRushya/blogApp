package com.blogger.controller;

import com.blogger.model.User;
import com.blogger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/id")
    public User updateUser(@RequestBody User user, @PathVariable Long id){
        return  userService.updateUser(id,user);
    }

    @DeleteMapping
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }

    @DeleteMapping
    public void deleteAllUsers(){
        userService.deleteAllUsers();
    }
}
