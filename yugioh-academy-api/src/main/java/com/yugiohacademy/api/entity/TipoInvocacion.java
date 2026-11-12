package com.yugiohacademy.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_invocacion")
public class TipoInvocacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_invocacion")
    private Integer idInvocacion;

    @Column(name = "nombre", nullable = false, unique = true, length = 80)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "requisitos", columnDefinition = "TEXT")
    private String requisitos;

    public TipoInvocacion() {
    }

    public Integer getIdInvocacion() {
        return idInvocacion;
    }

    public void setIdInvocacion(Integer idInvocacion) {
        this.idInvocacion = idInvocacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }
}
