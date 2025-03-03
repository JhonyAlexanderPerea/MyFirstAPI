    package co.edu.uniquindio.model;

    import com.fasterxml.jackson.annotation.JsonFormat;
    import jakarta.persistence.*;
    import jakarta.validation.constraints.*;
    import lombok.*;
    import java.time.LocalDate;
    import java.util.UUID;
    import co.edu.uniquindio.enums.Rol;
    import co.edu.uniquindio.enums.UserStatus;


    @Entity
    @Table(name = "users")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        @NotBlank(message = "El campo no puede estar vacío")
        @Column(nullable = false)
        private String fullName;

        @Email(message = "Debe ser un email válido")
        @NotBlank(message = "El email no puede estar vacío")
        @Column(nullable = false, unique = true)
        private String email;

        @NotBlank(message = "La contraseña no puede estar vacía")
        @Size(min = 8, message = "La longitud mínima es 8 caracteres")
        @Pattern(
                regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*$",
                message = "La contraseña debe contener al menos un número, una letra minúscula y una letra mayúscula"
        )
        @Column(nullable = false)
        private String password;

        @NotNull(message = "La fecha de nacimiento no puede ser nula")
        @Past(message = "La fecha de nacimiento debe estar en el pasado")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        @Column(nullable = false)
        private LocalDate dateOfBirth;

        @NotNull(message = "Debe existir un rol")
        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private Rol rol;

        @NotNull(message = "Debe existir un estado")
        @Enumerated (EnumType.STRING)
        @Column(nullable = false)
        private UserStatus status;

    }
