package co.edu.uniquindio.service;

import co.edu.uniquindio.dto.UserRegistrationDTO;
import co.edu.uniquindio.dto.UserResponseDTO;
import co.edu.uniquindio.dto.PasswordUpdateDTO;
import co.edu.uniquindio.enums.Rol;
import co.edu.uniquindio.mappers.UserMapper;
import co.edu.uniquindio.model.User;
import co.edu.uniquindio.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserServiceImp(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<UserResponseDTO> getUserById(UUID id) {
        try {
            UUID uuid = UUID.fromString(String.valueOf(id));
            return userRepository.findById(uuid)
                    .map(user -> new UserResponseDTO(user.getId(), user.getFullName(), user.getEmail(), user.getDateOfBirth(), user.getRol(), user.getStatus()));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }

    @Override
    public UserResponseDTO registerUser(UserRegistrationDTO dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Correo ya registrado");
        }

        User user = User.builder()
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .fullName(dto.getFullName())
                .dateOfBirth(dto.getDateBirth())
                .rol(dto.getRol())
                .status(dto.getStatus())
                .build();

        userRepository.save(user);
        return userMapper.convertToDTO(user);
    }


    @Override
    public void deleteUserById(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponseDTO updateUserPassword(UUID id, PasswordUpdateDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!Objects.equals(dto.getCurrentPassword(), user.getPassword())) {
            throw new RuntimeException("Contraseña actual incorrecta");
        }

        user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        userRepository.save(user);
        return userMapper.convertToDTO(user);
    }


}
