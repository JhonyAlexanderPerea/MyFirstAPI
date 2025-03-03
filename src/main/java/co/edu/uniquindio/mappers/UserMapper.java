package co.edu.uniquindio.mappers;


import co.edu.uniquindio.dto.UserRegistrationDTO;
import co.edu.uniquindio.dto.UserResponseDTO;
import co.edu.uniquindio.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponseDTO convertToDTO(User user);

    User convertFromDTO(UserRegistrationDTO dto);

}
