/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.demo.helloworld;

import Model.User;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ricardo
 */
@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private User[] usuarios = new User[]{
        new User("ricardo", "1234", "ricardo betancourth", true),
        new User("alejandro", "1234", "alejandro castrillon", true),
        new User("cristian", "1234", "cristian herrera", false),
        new User("felipe", "1234", "felipe leon", true),
        new User("cesar", "1234", "cesar diaz", false)
    };

    @GetMapping
    public List<User> getAll() {
        return Arrays.asList(usuarios);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        for (User usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                return usuario;
            }
        }
        return null;
    }

    @PostMapping
    public User insertUser(@RequestBody User usuario) {
        List<User> users = Arrays.asList(usuarios);
        users.add(usuario);
        usuarios = users.toArray(new User[0]);
        return usuario;
    }
    
    //Como devolver errores http
}
