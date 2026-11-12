package com.yugiohacademy.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "carta_estrategia")
public class CartaEstrategia {

    @EmbeddedId
    private CartaEstrategiaId id;

   @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("idCarta")
    @JoinColumn(name = "id_carta")
    private Carta carta;

   @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("idEstrategia")
    @JoinColumn(name = "id_estrategia")
    private Estrategia estrategia;

    @Column(name = "utilidad", columnDefinition = "TEXT")
    private String utilidad;

    @Column(name = "contexto", columnDefinition = "TEXT")
    private String contexto;

    public CartaEstrategia() {
    }

    public CartaEstrategiaId getId() {
        return id;
    }

    public void setId(CartaEstrategiaId id) {
        this.id = id;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public Estrategia getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }

    public String getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(String utilidad) {
        this.utilidad = utilidad;
    }

    public String getContexto() {
        return contexto;
    }

    public void setContexto(String contexto) {
        this.contexto = contexto;
    }
}
