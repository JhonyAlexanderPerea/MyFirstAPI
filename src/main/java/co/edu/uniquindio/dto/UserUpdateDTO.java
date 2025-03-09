package co.edu.uniquindio.dto;


import co.edu.uniquindio.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UUID;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDTO {
    private UUID id;
    private String fullName;
    private String email;
    private Date dateOfBirth;
    private Rol rol;
}
