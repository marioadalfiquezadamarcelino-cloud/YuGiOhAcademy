
package com.yugiohacademy.api.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtAuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        // Obtener la cabecera Authorization
        String authorizationHeader =
                request.getHeader("Authorization");

        // Comprobar que contiene un token Bearer
        if (authorizationHeader != null
                && authorizationHeader.startsWith("Bearer ")) {

            String token = authorizationHeader.substring(7);

            // Comprobar si el token es válido
            if (jwtService.validarToken(token)
                    && SecurityContextHolder.getContext()
                    .getAuthentication() == null) {

                // Obtener el correo del usuario
                String correo = jwtService.obtenerCorreo(token);

                // Crear la autenticación
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                correo,
                                null,
                                Collections.emptyList()
                        );

                authentication.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request)
                );

                // Guardar la autenticación en Spring Security
                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);
            }
        }

        // Continuar con la siguiente fase de la petición
        filterChain.doFilter(request, response);
    }
}
