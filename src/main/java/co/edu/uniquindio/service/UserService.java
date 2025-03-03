package co.edu.uniquindio.service;

import co.edu.uniquindio.dto.PasswordUpdateDTO;
import co.edu.uniquindio.dto.UserRegistrationDTO;
import co.edu.uniquindio.dto.UserResponseDTO;
import co.edu.uniquindio.model.User;
import java.util.UUID;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List <UserResponseDTO> getAllUsers();
    Optional<UserResponseDTO> getUserById(@PathVariable UUID id);
    UserResponseDTO registerUser(UserRegistrationDTO dto);
    void deleteUserById(@PathVariable UUID id);
    UserResponseDTO updateUserPassword(@PathVariable UUID id, PasswordUpdateDTO dto);

}
