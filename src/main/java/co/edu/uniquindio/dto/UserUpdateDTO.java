package co.edu.uniquindio.dto;


import co.edu.uniquindio.enums.Rol;
import co.edu.uniquindio.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Stack;
import java.util.UUID;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDTO {
    private String fullName;
    private String email;
    private Date dateOfBirth;
    private Rol rol;
    private String password;
    private UserStatus status;
}
