package co.edu.uniquindio.mappers;

import co.edu.uniquindio.dto.UserRegistrationDTO;
import co.edu.uniquindio.dto.UserResponseDTO;
import co.edu.uniquindio.dto.UserUpdateDTO;
import co.edu.uniquindio.model.User;
import co.edu.uniquindio.enums.UserStatus;
import java.util.UUID;

import jakarta.validation.constraints.Past;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(target = "status", source = "status")

    @Past @Mapping(target = "dateOfBirth", source = "dateOfBirth")
    UserResponseDTO convertFromUserToDTO(User user);

    //  @Mapping(target = "status", source = "UserStatus") // Estado predeterminado
    @Mapping(target = "dateOfBirth", source = "dateOfBirth")
    User convertFromDTOToUser(UserRegistrationDTO dto);

  //  @Mapping(target = "id", source = "id")
  //  @Mapping(target = "status", source = "status")
    User convertFromUpdateDTOToUser(UserUpdateDTO dto);

   /* default UUID map(UUID id) {
        return id;
    }*/
}
