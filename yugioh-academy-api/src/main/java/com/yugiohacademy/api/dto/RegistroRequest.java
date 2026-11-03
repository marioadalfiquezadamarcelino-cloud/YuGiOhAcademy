package com.yugiohacademy.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegistroRequest {
    @NotBlank (message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre puede superar los 100 carateres")
    private String nombre;

    @NotBlank (message = "El correo electónico es obligatorio")
    @Email  (message = "El formato del correo electrónico no es válido")
    @Size (max = 150 , message = "El correo no puede superar los 150 caracteres")
    private String correo;

    @NotBlank (message = "La contraseña es obligatoria")
    @Size (min = 8, max = 100, message = "La contraseña debe tener entre 8 y 100 caracteres" )
    private String contrasena;

    public RegistroRequest(){
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
