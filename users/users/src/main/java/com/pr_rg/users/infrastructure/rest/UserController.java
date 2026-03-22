package com.pr_rg.users.infrastructure.rest;

import com.pr_rg.users.application.UserService;
import com.pr_rg.users.domain.model.users.User;
import com.pr_rg.users.domain.model.usersDto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDTO userDTO) {
        // Convertimos el DTO a Entidad antes de pasarla al servicio
        User newUser = new User();
        newUser.setName(userDTO.name());
        newUser.setEmail(userDTO.email());

        User savedUser = userService.createUser(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getUserById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
