package com.user.demo.controllers;


import com.user.demo.models.UserModel;
import com.user.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel userModel) {
        return userService.saveUser(userModel);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping(path = "/query")
    public ArrayList<UserModel> getByPriority(@RequestParam("priority") Integer priority){
        return userService.findByPriority(priority);
    }

    @PutMapping()
    public UserModel updateUser(@RequestBody UserModel userModel) {
        return userService.saveUser(userModel);
    }

    @DeleteMapping( path = "/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        boolean ok = userService.deleteUser(id);
        if (ok) {
            return "Usuario Eliminado";
        } else{
            return "No se pudo eliminar el usuario con id: "+ id;
        }
    }
}
