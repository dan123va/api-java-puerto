package com.daniel.backend.controller;

import com.daniel.backend.document.User;
import com.daniel.backend.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@Tag(name = "Usuarios", description = "Administración de clientes")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Operation(summary = "Listar usuarios", description = "Obtiene todos los usuarios registrados.")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping
    @Operation(summary = "Crear un usuario", description = "Registra un nuevo cliente.")
    public User createUser(
            @RequestBody User user
    ) {
        return userService.save(user);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consultar un usuario", description = "Obtiene un usuario mediante su identificador.")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        Optional<User> user = userService.findById(id);

        if (!user.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user.get());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un usuario", description = "Actualiza la información de un usuario existente.")
        public ResponseEntity<User> updateUser(
            @PathVariable String id,
            @RequestBody User user
    ) {

        Optional<User> updatedUser =
            userService.update(id, user);

        if (!updatedUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedUser.get());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un usuario", description = "Elimina un usuario mediante su identificador.")
    public ResponseEntity<Void> deleteUser(
            @PathVariable String id
    ) {

        boolean deleted = userService.deleteById(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
