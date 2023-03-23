package com.user.demo.services;

import com.user.demo.models.UserModel;
import com.user.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getAllUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public Optional<UserModel> findById(Long id){
        return userRepository.findById(id);
    }

    public ArrayList<UserModel> findByPriority(Integer priority){
        return userRepository.findByPriority(priority);
    }

    public boolean deleteUser(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception err){
            return false;
        }
    }
}
