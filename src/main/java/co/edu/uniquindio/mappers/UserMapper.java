package co.edu.uniquindio.mappers;

import co.edu.uniquindio.dto.UserRegistrationDTO;
import co.edu.uniquindio.dto.UserResponseDTO;
import co.edu.uniquindio.model.User;
import co.edu.uniquindio.enums.UserStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(target = "status", source = "status")
    @Mapping(target = "dateOfBirth", source = "dateOfBirth")
    UserResponseDTO convertFromUserToDTO(User user);

    //  @Mapping(target = "status", source = "UserStatus") // Estado predeterminado
    @Mapping(target = "dateOfBirth", source = "dateOfBirth")
    User convertFromDTOToUser(UserRegistrationDTO dto);
}
