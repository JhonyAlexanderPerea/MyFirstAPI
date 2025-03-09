package co.edu.uniquindio.controller;

import co.edu.uniquindio.dto.PasswordUpdateDTO;
import co.edu.uniquindio.dto.UserRegistrationDTO;
import co.edu.uniquindio.dto.UserResponseDTO;
import co.edu.uniquindio.dto.UserUpdateDTO;
import co.edu.uniquindio.service.UserServiceImp;
import java.util.UUID;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImp userServiceImp;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        return ResponseEntity.ok(userServiceImp.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable UUID id) {
        return userServiceImp.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> registerUser(@Valid @RequestBody UserRegistrationDTO dto) {
        return ResponseEntity.status(201).body(userServiceImp.registerUser(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userServiceImp.deleteUserById(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/password")
    public ResponseEntity<UserResponseDTO> updatePassword(@PathVariable UUID id, @RequestBody PasswordUpdateDTO dto) {
        return ResponseEntity.ok(userServiceImp.updateUserPassword(id, dto));
    }

    @PutMapping("")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable UUID id, @RequestBody UserUpdateDTO dto) {
        return ResponseEntity.ok(userServiceImp.updateUser(id,dto));
    }
}
