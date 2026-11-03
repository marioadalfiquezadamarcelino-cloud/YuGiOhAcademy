package com.yugiohacademy.api.repository;

import com.yugiohacademy.api.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

// Buscar un usuario por su correo
Optional<Usuario> findByCorreo(String correo);

//Comprobar si un correo ya está registrado
 boolean existsByCorreo(String correo);
    
}