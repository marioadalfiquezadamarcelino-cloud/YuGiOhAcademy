
package com.yugiohacademy.api.controller;

import com.yugiohacademy.api.dto.AuthResponse;
import com.yugiohacademy.api.dto.LoginRequest;
import com.yugiohacademy.api.dto.RegistroRequest;
import com.yugiohacademy.api.entity.Usuario;
import com.yugiohacademy.api.security.JwtService;
import com.yugiohacademy.api.service.UsuarioService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UsuarioService usuarioService;
    private final JwtService jwtService;

    public AuthController(
            UsuarioService usuarioService,
            JwtService jwtService) {

        this.usuarioService = usuarioService;
        this.jwtService = jwtService;
    }

    // REGISTRO
    @PostMapping("/registro")
    public ResponseEntity<?> registrarUsuario(
            @Valid @RequestBody RegistroRequest request) {

        try {
            Usuario usuario = usuarioService.registrarUsuario(request);

            String token = jwtService.generarToken(
                    usuario.getCorreo()
            );

            AuthResponse respuesta = new AuthResponse(
                    "Cuenta creada correctamente.",
                    token,
                    usuario.getIdUsuario(),
                    usuario.getNombre(),
                    usuario.getCorreo()
            );

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(respuesta);

        } catch (IllegalArgumentException e) {

            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(Map.of("mensaje", e.getMessage()));
        }
    }

    // INICIO DE SESIÓN
    @PostMapping("/login")
    public ResponseEntity<?> iniciarSesion(
            @Valid @RequestBody LoginRequest request) {

        try {
            Usuario usuario = usuarioService.iniciarSesion(request);

            String token = jwtService.generarToken(
                    usuario.getCorreo()
            );

            AuthResponse respuesta = new AuthResponse(
                    "Inicio de sesión correcto.",
                    token,
                    usuario.getIdUsuario(),
                    usuario.getNombre(),
                    usuario.getCorreo()
            );

            return ResponseEntity.ok(respuesta);

        } catch (IllegalArgumentException e) {

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("mensaje", e.getMessage()));
        }
    }
}
