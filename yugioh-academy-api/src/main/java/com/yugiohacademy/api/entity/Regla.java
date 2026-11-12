package com.yugiohacademy.api.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "regla")
public class Regla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_regla")
    private Integer idRegla;

    @Column(name = "titulo", nullable = false, length = 150)
    private String titulo;

    @Column(name = "categoria", length = 80)
    private String categoria;

    @Column(name = "contenido", columnDefinition = "TEXT")
    private String contenido;

    @Column(name = "ejemplo", columnDefinition = "TEXT")
    private String ejemplo;

    @Column(name = "fuente", length = 500)
    private String fuente;

    public Regla() {
    }

    public Integer getIdRegla() {
        return idRegla;
    }

    public void setIdRegla(Integer idRegla) {
        this.idRegla = idRegla;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getEjemplo() {
        return ejemplo;
    }

    public void setEjemplo(String ejemplo) {
        this.ejemplo = ejemplo;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }
}
