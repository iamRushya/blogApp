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


   public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found!"));
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user){
        User updatedUser = getUserById(id);
        updatedUser.setName(user.getName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPassword(user.getPassword());

        return userRepository.save(updatedUser);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

    public void deleteAllUsers(){
        userRepository.deleteAll();
    }
}
