package com.cambio.application.mapper;


import com.cambio.application.model.UserDTO;
import com.cambio.domain.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicationUserMapper {

    UserDTO userToUserDTO(Usuario usuario);

    Usuario userDTOToUser(UserDTO userDTO);

}
