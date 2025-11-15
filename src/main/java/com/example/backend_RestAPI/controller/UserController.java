package com.example.backend_RestAPI.controller;

import com.example.backend_RestAPI.dto.UserDTO;
import com.example.backend_RestAPI.model.User;
import com.example.backend_RestAPI.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Void> saveUser(@Valid @RequestBody UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    /* Recupera as informações de todos os users*/
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    /* Recupera as informações de um user especifico*/
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUserById(@RequestParam Integer id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Integer id, @RequestBody UserDTO userUpdateDTO) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("user not found with id: " + id)
        );

        if(userUpdateDTO.getName() != null){
            user.setName(userUpdateDTO.getName());
        }

        if(userUpdateDTO.getEmail() != null){
            user.setEmail(userUpdateDTO.getEmail());
        }

        if(userUpdateDTO.getPassword() != null){
            user.setPassword(userUpdateDTO.getPassword());
        }

        userRepository.save(user);
        return ResponseEntity.ok().build();
    }


}
