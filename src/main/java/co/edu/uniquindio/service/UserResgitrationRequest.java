package co.edu.uniquindio.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UserResgitrationRequest(
        @NotBlank(message = "El campo no puede estar vacío")
        @Size(max = 100, message = "El nombre no puede exceder los cien caracteres")
        String fullName,

        @NotBlank(message = "El campo no puede estar vacío")
        @Email(message = "Debe ser un email válido")
        String email,

        @NotBlank(message = "El campo no puede estar vacío")
        @PastOrPresent(message = "La fecha de nacimiento no puede ser futura")
        LocalDate dateBirth,

        @NotBlank(message = "El campo no puede estar vacío")
        @Size(min = 8,message = "La longitud mínima es 8")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        @Pattern(regexp = "^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z]).*$",message = "La contraseña debe contener por lo menos un número, una letra minúscula y una letra mayúscula")
        String password

) {}
