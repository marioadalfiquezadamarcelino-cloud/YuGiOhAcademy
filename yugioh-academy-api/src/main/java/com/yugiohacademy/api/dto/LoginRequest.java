package com.yugiohacademy.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    
    @NotBlank (message = "El correo electrónico es obligatorio")
    @Email (message = "El correo electrónico no es válido")
    private String correo;

    @NotBlank (message = "La contraseña es obligatoria")
    private String contrasena;

    public LoginRequest(){
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    
}
