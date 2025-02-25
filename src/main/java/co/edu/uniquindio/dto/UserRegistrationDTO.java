package co.edu.uniquindio.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UserRegistrationDTO {
    private String email;
    private String password;
    private String fullName;
    private LocalDate dateBirth;
    private String rol;
}
