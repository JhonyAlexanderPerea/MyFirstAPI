package co.edu.uniquindio.service;

import co.edu.uniquindio.dto.UserRegistrationDTO;
import co.edu.uniquindio.dto.UserResponseDTO;
import co.edu.uniquindio.dto.PasswordUpdateDTO;
import co.edu.uniquindio.model.User;
import co.edu.uniquindio.repository.UserRepository;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
   // private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        //this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public Optional<UserResponseDTO> getUserById(UUID id) {
        try {
            UUID uuid = UUID.fromString(String.valueOf(id));
            return userRepository.findById(uuid)
                    .map(user -> new UserResponseDTO(user.getId(), user.getFullName(), user.getEmail(), user.getDateOfBirth(), user.getRol()));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }


    public UserResponseDTO registerUser(UserRegistrationDTO dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Correo ya registrado");
        }

        User user = User.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .fullName(dto.getFullName())
                .dateOfBirth(dto.getDateBirth())
                .rol(User.Rol.valueOf(dto.getRol().toUpperCase()))
                .build();

        userRepository.save(user);
        return convertToDTO(user);
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    public UserResponseDTO updateUserPassword(UUID id, PasswordUpdateDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!Objects.equals(dto.getCurrentPassword(), user.getPassword())) {
            throw new RuntimeException("Contraseña actual incorrecta");
        }

        user.setPassword(dto.getNewPassword());
        userRepository.save(user);
        return convertToDTO(user);
    }

    private UserResponseDTO convertToDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO(user.getId(), user.getFullName(), user.getEmail(), user.getDateOfBirth(), user.getRol());
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setFullName(user.getFullName());
        dto.setDateBirth(user.getDateOfBirth());
        dto.setRol(user.getRol());
        return dto;
    }
}
