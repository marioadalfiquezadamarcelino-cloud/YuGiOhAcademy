
package com.yugiohacademy.api.service;

import com.yugiohacademy.api.dto.RegistroRequest;
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

    public Usuario registrarUsuario(RegistroRequest request) {

        // Normalizar el correo electrónico
        String correo = request.getCorreo()
                .trim()
                .toLowerCase(Locale.ROOT);

        // Comprobar si el correo ya está registrado
        if (usuarioRepository.existsByCorreo(correo)) {
            throw new IllegalArgumentException(
                    "El correo electrónico ya está registrado."
            );
        }

        // Crear el usuario
        Usuario usuario = new Usuario();

        usuario.setNombre(request.getNombre().trim());
        usuario.setCorreo(correo);

        // Encriptar la contraseña con BCrypt
        usuario.setContrasena(
                passwordEncoder.encode(request.getContrasena())
        );

        // Establecer los valores iniciales
        usuario.setFechaRegistro(LocalDateTime.now());
        usuario.setActivo(true);

        // Guardar el usuario en MariaDB
        return usuarioRepository.save(usuario);
    }
}
