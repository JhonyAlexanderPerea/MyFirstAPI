package co.edu.uniquindio.dto;

import co.edu.uniquindio.enums.Rol;
import co.edu.uniquindio.enums.UserStatus;
import co.edu.uniquindio.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private String id;
    private String fullName;
    private String email;
    private LocalDate dateOfBirth;
    private Rol rol;
    private UserStatus status;
}
