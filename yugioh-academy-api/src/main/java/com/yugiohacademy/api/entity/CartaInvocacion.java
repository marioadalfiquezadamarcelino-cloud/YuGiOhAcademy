package com.yugiohacademy.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "carta_invocacion")
public class CartaInvocacion {

    @EmbeddedId
    private CartaInvocacionId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("idCarta")
    @JoinColumn(name = "id_carta")
    private Carta carta;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("idInvocacion")
    @JoinColumn(name = "id_invocacion")
    private TipoInvocacion tipoInvocacion;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    public CartaInvocacion() {
    }

    public CartaInvocacionId getId() {
        return id;
    }

    public void setId(CartaInvocacionId id) {
        this.id = id;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public TipoInvocacion getTipoInvocacion() {
        return tipoInvocacion;
    }

    public void setTipoInvocacion(TipoInvocacion tipoInvocacion) {
        this.tipoInvocacion = tipoInvocacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
