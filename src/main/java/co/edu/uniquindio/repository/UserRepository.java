package co.edu.uniquindio.repository;

import co.edu.uniquindio.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
