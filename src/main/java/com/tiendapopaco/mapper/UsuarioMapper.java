package com.tiendapopaco.mapper;

import com.tiendapopaco.dto.SignUpDto;
import com.tiendapopaco.dto.UsuarioDto;
import com.tiendapopaco.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDto toUsuariorDto(Usuario usuario);

    @Mapping(target = "contrasena", ignore = true)
    Usuario signUpToUser(SignUpDto signUpDto);

}
