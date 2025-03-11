package co.edu.uniquindio.service;

import co.edu.uniquindio.dto.PasswordUpdateDTO;
import co.edu.uniquindio.dto.UserRegistrationDTO;
import co.edu.uniquindio.dto.UserResponseDTO;
import co.edu.uniquindio.dto.UserUpdateDTO;
import co.edu.uniquindio.model.User;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Page<UserResponseDTO> getUsers(int page, int size);
    Optional<UserResponseDTO> getUserById(@PathVariable String id);
    UserResponseDTO registerUser(UserRegistrationDTO dto);
    void deleteUserById(@PathVariable String id);
    UserResponseDTO updateUserPassword(@PathVariable String id, PasswordUpdateDTO dto);
    UserResponseDTO updateUser(@PathVariable String id, UserUpdateDTO dto);
}
