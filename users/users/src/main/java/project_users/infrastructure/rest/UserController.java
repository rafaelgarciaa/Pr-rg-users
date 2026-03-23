package project_users.infrastructure.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import project_users.application.UserService;
import project_users.domain.model.users.User;
import project_users.domain.model.usersDto.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@Tag(name = "Customer Controller", description = "Endpoints para la gestion de usuarios")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Crear un nuevo usuario", description = "Registra un usuario en el sistema")
    @PostMapping
    public UserDTO create(@Valid @RequestBody UserDTO userDTO) {
        // Directamente pasamos el DTO al servicio si este lo soporta
        User savedUser = userService.createUser(userDTO);
        return UserDTO.fromEntity(savedUser);
    }

    @Operation(summary = "Listar todos los usuarios")
    @GetMapping
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Obtener usuario por ID")
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getUserById(id).orElseThrow();
    }

    @Operation(summary = "Eliminar un usuario")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}