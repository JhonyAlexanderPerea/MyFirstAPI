package co.edu.uniquindio.service;

import co.edu.uniquindio.enums.Rol;

import java.time.LocalDate;

public record UserResponse(
        Long id,
        String fullName,
        LocalDate dateBirth,
        String email,
        Rol rol

) {}

