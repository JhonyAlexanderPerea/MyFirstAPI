package co.edu.uniquindio.dto;

import co.edu.uniquindio.enums.Rol;
import co.edu.uniquindio.enums.UserStatus;
import lombok.Data;
import java.time.LocalDate;

@Data
public class UserRegistrationDTO {
    private String email;
    private String password;
    private String fullName;
    private LocalDate dateBirth;
    private Rol rol;
}
