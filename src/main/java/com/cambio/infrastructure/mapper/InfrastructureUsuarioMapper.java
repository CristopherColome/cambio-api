package com.cambio.infrastructure.mapper;

import com.cambio.domain.model.Rol;
import com.cambio.domain.model.Usuario;
import com.cambio.infrastructure.model.sql.RolTable;
import com.cambio.infrastructure.model.sql.UsuarioTable;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InfrastructureUsuarioMapper {

    Usuario usuarioTableToUsuario(UsuarioTable usuarioTable);

    UsuarioTable usuarioToUsuarioTable(Usuario usuario);

    Rol rolTableToRol(RolTable rolTable);

    RolTable rolToRolTable(Rol rol);
}
