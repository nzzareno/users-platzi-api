package com.example.rickandmortyapi.services;

import com.example.rickandmortyapi.entities.User;
import com.example.rickandmortyapi.repositories.UserRepository;
import com.example.rickandmortyapi.utils.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository USER_REPOSITORY;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.USER_REPOSITORY = userRepository;
    }

    public List<User> getUsers() {
        return USER_REPOSITORY.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return USER_REPOSITORY.findById(id).stream().findFirst();
    }

    public Optional<User> getUserByLastname(String lastname) {
        List<User> usuarios = USER_REPOSITORY.findAll();
        return usuarios.stream().filter(u -> u.getLastname().equals(lastname)).findFirst();

    }

    public void saveUser(User user) {
        List<User> usuarios = USER_REPOSITORY.findAll();
        boolean exists = usuarios.stream().anyMatch(u -> u.getEmail().equals(user.getEmail()));
        if (!exists) {
            USER_REPOSITORY.save(user);
        } else {
            throw new CustomException("El usuario ya existe");
        }
    }

    public void deleteUser(Long id) {
        USER_REPOSITORY.deleteById(id);
    }

}
