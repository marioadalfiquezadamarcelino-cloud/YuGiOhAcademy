
package com.yugiohacademy.api.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    // Duración del token: 24 horas
    private static final long EXPIRATION_TIME = 1000L * 60 * 60 * 24;

    // Obtener la clave para firmar los tokens
    private SecretKey getSigningKey() {

        return Keys.hmacShaKeyFor(
                secretKey.getBytes(StandardCharsets.UTF_8));
    }

    // Generar un token JWT
    public String generarToken(String correo) {

        Date fechaActual = new Date();

        Date fechaExpiracion = new Date(
                fechaActual.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .subject(correo)
                .issuedAt(fechaActual)
                .expiration(fechaExpiracion)
                .signWith(getSigningKey())
                .compact();
    }

    // Obtener el correo guardado en el token
    public String obtenerCorreo(String token) {

        return obtenerClaims(token).getSubject();
    }

    // Comprobar si el token es válido
    public boolean validarToken(String token) {

        if (token == null || token.isBlank()) {
            return false;
        }

        try {
            obtenerClaims(token);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    // Leer la información del token
    private Claims obtenerClaims(String token) {

        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
