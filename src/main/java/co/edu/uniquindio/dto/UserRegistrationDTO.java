package co.edu.uniquindio.dto;

import co.edu.uniquindio.enums.Rol;
import co.edu.uniquindio.enums.UserStatus;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class UserRegistrationDTO {
    private String email;
    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, message = "La longitud mínima es 8 caracteres")
    @Pattern(
            regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*$",
            message = "La contraseña debe contener al menos un número, una letra minúscula y una letra mayúscula"
    )
    private String password;
    private String fullName;
    @Past(message = "La fecha debe estar en pasado")
    private LocalDate dateOfBirth;
    private Rol rol;
}
