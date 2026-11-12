
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
        protected boolean shouldNotFilter(HttpServletRequest request) {

                String ruta = request.getServletPath();

                return ruta.equals("/api/auth/registro")
                                || ruta.equals("/api/auth/login")
                                || request.getMethod().equals("OPTIONS");
        }

        @Override
        protected void doFilterInternal(
                        HttpServletRequest request,
                        HttpServletResponse response,
                        FilterChain filterChain)
                        throws ServletException, IOException {

                String authorizationHeader = request.getHeader("Authorization");

                if (authorizationHeader != null
                                && authorizationHeader.startsWith("Bearer ")) {

                        String token = authorizationHeader.substring(7);

                        if (jwtService.validarToken(token)
                                        && SecurityContextHolder.getContext()
                                                        .getAuthentication() == null) {

                                String correo = jwtService.obtenerCorreo(token);

                                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                                correo,
                                                null,
                                                Collections.emptyList());

                                authentication.setDetails(
                                                new WebAuthenticationDetailsSource()
                                                                .buildDetails(request));

                                SecurityContextHolder.getContext()
                                                .setAuthentication(authentication);
                        }
                }

                filterChain.doFilter(request, response);
        }
}
