package co.edu.uniquindio.service;

import co.edu.uniquindio.model.User;
import co.edu.uniquindio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Obtener usuarios paginados
    public List<User> getUsers(int page, int size) {
        return userRepository.findAll(PageRequest.of(Math.max(0, page - 1), size)).getContent();
    }

    // Buscar usuario por ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Crear usuario con contraseña encriptada
    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("El email ya está registrado.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // Eliminar usuario por ID
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado.");
        }
        userRepository.deleteById(id);
    }

    // Actualizar usuario
    public User updateUser(Long id, User userUpdate) {
        return userRepository.findById(id).map(user -> {
            user.setFullName(userUpdate.getFullName());
            user.setDateOfBirth(userUpdate.getDateOfBirth());
            user.setRol(userUpdate.getRol());

            // Si la nueva contraseña no está vacía, la actualizamos
            if (userUpdate.getPassword() != null && !userUpdate.getPassword().isEmpty()) {
                user.setPassword(passwordEncoder.encode(userUpdate.getPassword()));
            }

            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("Usuario no encontrado."));
    }
}
