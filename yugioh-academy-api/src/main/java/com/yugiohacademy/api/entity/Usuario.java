package com.yugiohacademy.api.entity;

 import jakarta.persistence.*;
 import java.time.LocalDateTime;

 import com.fasterxml.jackson.annotation.JsonProperty;   

    
@Entity 
@Table (name = "usuario")
public class Usuario {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column (name = "id_usuario")
private Long idUsuario; 

@Column (name = "nombre", nullable =  false, length = 100)
private String nombre;

@Column(name = "correo", nullable = false, unique = true, length = 150)
private String correo;

@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
@Column(name = "contrasena", nullable = false, length = 255)
private String contrasena;

@Column (name = "fecha_registro")
private LocalDateTime fechaRegistro;

@Column (name = "activo" )
private Boolean activo;

public Usuario(){
}

public Long getIdUsuario() {
    return idUsuario;
}

public void setIdUsuario(Long idUsuario) {
    this.idUsuario = idUsuario;
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

public LocalDateTime getFechaRegistro() {
    return fechaRegistro;
}

public void setFechaRegistro(LocalDateTime fechaRegistro) {
    this.fechaRegistro = fechaRegistro;
}

public Boolean getActivo() {
    return activo;
}

public void setActivo(Boolean activo) {
    this.activo = activo;
}


}
