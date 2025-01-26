package com.blogger.service;

import com.blogger.model.User;
import com.blogger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found!"));
    }

    User createUser(User user){
        return userRepository.save(user);
    }

    User updateUser(Long id, User user){
        User updatedUser = getUserById(id);
        updatedUser.setName(user.getName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPassword(user.getPassword());

        return userRepository.save(updatedUser);
    }

    void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

    void deleteAllUsers(){
        userRepository.deleteAll();
    }
}
