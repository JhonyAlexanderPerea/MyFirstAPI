package co.edu.uniquindio.dto;

import co.edu.uniquindio.enums.Rol;
import co.edu.uniquindio.enums.UserStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class UserRegistrationDTO {
    private String email;
    private String password;
    private String fullName;
    private LocalDate dateOfBirth;
    private Rol rol;
}
