package com.tiendapopaco.controller;

import com.tiendapopaco.config.UsuarioAuthenticationProvider;
import com.tiendapopaco.dto.CredentialsDto;
import com.tiendapopaco.dto.SignUpDto;
import com.tiendapopaco.dto.UsuarioDto;
import com.tiendapopaco.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.net.URI;

@CrossOrigin
@RequiredArgsConstructor
@RestController
public class AuthController {

    private final UsuarioService usuarioService;
    private final UsuarioAuthenticationProvider usuarioAuthenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<UsuarioDto> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        UsuarioDto usuarioDto = usuarioService.login(credentialsDto);
        usuarioDto.setToken(usuarioAuthenticationProvider.createToken(usuarioDto));
        return ResponseEntity.ok(usuarioDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioDto> register(@RequestBody @Valid SignUpDto user) {
        UsuarioDto createdUser = usuarioService.register(user);
        createdUser.setToken(usuarioAuthenticationProvider.createToken(createdUser));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }

}
