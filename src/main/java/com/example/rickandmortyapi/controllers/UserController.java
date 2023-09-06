package com.example.rickandmortyapi.controllers;

import com.example.rickandmortyapi.entities.User;
import com.example.rickandmortyapi.services.UserService;
import com.example.rickandmortyapi.utils.CustomException;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService USER_SERVICE;

    public UserController(UserService userService) {
        this.USER_SERVICE = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        try {
            return USER_SERVICE.getUsers();
        } catch (Exception e) {
            throw new CustomException("Error al obtener usuarios");
        }
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id) {
        try {
            return USER_SERVICE.getUserById(id);
        } catch (Exception e) {
            throw new CustomException("Error al obtener usuario por id");
        }
    }

    @GetMapping("/lastname/{lastname}")
    public Optional<User> getUserByLastname(@PathVariable("lastname") String lastname) {
        try {
            return USER_SERVICE.getUserByLastname(lastname);
        } catch (Exception e) {
            throw new CustomException("Error al obtener usuario por apellido");
        }
    }

    @PostMapping()
    public void saveUser(@RequestBody User user) {
        try {
            USER_SERVICE.saveUser(user);
        } catch (Exception e) {
            throw new CustomException("Error al guardar usuario");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        try {
            USER_SERVICE.deleteUser(id);
        } catch (Exception e) {
            throw new CustomException("Error al eliminar usuario");
        }
    }

}
