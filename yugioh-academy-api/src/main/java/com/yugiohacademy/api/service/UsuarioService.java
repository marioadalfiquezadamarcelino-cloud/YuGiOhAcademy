
package com.yugiohacademy.api.service;

import com.yugiohacademy.api.dto.RegistroRequest;
import com.yugiohacademy.api.dto.LoginRequest;
import com.yugiohacademy.api.entity.Usuario;
import com.yugiohacademy.api.repository.UsuarioRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Locale;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder) {

        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Registrar un usuario
    public Usuario registrarUsuario(RegistroRequest request) {

        String correo = request.getCorreo()
                .trim()
                .toLowerCase(Locale.ROOT);

        if (usuarioRepository.existsByCorreo(correo)) {
            throw new IllegalArgumentException(
                    "El correo electrónico ya está registrado."
            );
        }

        Usuario usuario = new Usuario();

        usuario.setNombre(request.getNombre().trim());
        usuario.setCorreo(correo);

        usuario.setContrasena(
                passwordEncoder.encode(request.getContrasena())
        );

        usuario.setFechaRegistro(LocalDateTime.now());
        usuario.setActivo(true);

        return usuarioRepository.save(usuario);
    }

    // Iniciar sesión
    public Usuario iniciarSesion(LoginRequest request) {

        String correo = request.getCorreo()
                .trim()
                .toLowerCase(Locale.ROOT);

        // Buscar el usuario por correo
        Usuario usuario = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Correo o contraseña incorrectos."
                ));

        // Comprobar si la cuenta está activa
        if (!Boolean.TRUE.equals(usuario.getActivo())) {
            throw new IllegalArgumentException(
                    "La cuenta está desactivada."
            );
        }

        // Comparar la contraseña introducida con BCrypt
        boolean contrasenaCorrecta = passwordEncoder.matches(
                request.getContrasena(),
                usuario.getContrasena()
        );

        if (!contrasenaCorrecta) {
            throw new IllegalArgumentException(
                    "Correo o contraseña incorrectos."
            );
        }

        return usuario;
    }
}
