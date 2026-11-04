package com.yugiohacademy.api.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yugiohacademy.api.entity.Usuario;
import com.yugiohacademy.api.repository.UsuarioRepository;

@RestController 
@RequestMapping ("/api/usuarios")
public class UsuarioController {
    
    public final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping ("/perfil")
    public ResponseEntity<?> obtenerPerfil(Authentication authentication){
        
        String correo = authentication.getName();

        Usuario usuario = usuarioRepository.findByCorreo(correo).orElse(null);

        if (usuario == null || !Boolean.TRUE.equals(usuario.getActivo())){

            return ResponseEntity.
            status(HttpStatus.UNAUTHORIZED)
            .body(Map.of("mensaje", "Usuario no encontrado o inactivo. "));
        }

        return  ResponseEntity.ok(Map.of(
            "idUsuario", usuario.getIdUsuario(),
            "nombre", usuario.getNombre(),
            "correo", usuario.getCorreo()
        ));
    }
}
