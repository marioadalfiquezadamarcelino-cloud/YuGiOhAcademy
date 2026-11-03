package com.yugiohacademy.api.dto;

public class AuthResponse {
   private String mensaje;
   private String token;
   private Long idUsuario;
   private String nombre; 
   private String correo;

   public AuthResponse(){
   }

   public AuthResponse(String mensaje, String token, Long idUsuario, String nombre, String correo) {
    this.mensaje = mensaje;
    this.token = token;
    this.idUsuario = idUsuario;
    this.nombre = nombre;
    this.correo = correo;
   }

   public String getMensaje() {
    return mensaje;
   }

   public String getToken() {
    return token;
   }

   public Long getIdUsuario() {
    return idUsuario;
   }

   public String getNombre() {
    return nombre;
   }

   public String getCorreo() {
    return correo;
   }

}
