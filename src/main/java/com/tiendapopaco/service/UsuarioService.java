package com.tiendapopaco.service;

import com.tiendapopaco.dto.CredentialsDto;
import com.tiendapopaco.dto.SignUpDto;
import com.tiendapopaco.dto.UsuarioDto;
import com.tiendapopaco.exception.AppException;
import com.tiendapopaco.mapper.UsuarioMapper;
import com.tiendapopaco.model.Usuario;
import com.tiendapopaco.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    private final UsuarioMapper usuarioMapper;

    public UsuarioDto login(CredentialsDto credentialsDto) {
        Usuario usuario = usuarioRepository.findByUsuario(credentialsDto.usuario())
                .orElseThrow(() -> new AppException("Usuario desconocido", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.contrasena()), usuario.getContrasena())) {
            return usuarioMapper.toUsuariorDto(usuario);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UsuarioDto register(SignUpDto usuarioDto) {
        Optional<Usuario> optionalUser = usuarioRepository.findByUsuario(usuarioDto.usuario());

        if (optionalUser.isPresent()) {
            throw new AppException("Usuario ya existe", HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = usuarioMapper.signUpToUser(usuarioDto);
        usuario.setContrasena(passwordEncoder.encode(CharBuffer.wrap(usuarioDto.contrasena())));

        Usuario savedUsuario = usuarioRepository.save(usuario);

        return usuarioMapper.toUsuariorDto(savedUsuario);
    }

    public UsuarioDto findByUsuario(String usuario) {
        Usuario user = usuarioRepository.findByUsuario(usuario)
                .orElseThrow(() -> new AppException("Usuario desconocido", HttpStatus.NOT_FOUND));
        return usuarioMapper.toUsuariorDto(user);
    }

}
