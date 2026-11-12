package com.yugiohacademy.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class CartaInvocacionId implements Serializable {

    @Column(name = "id_carta")
    private Integer idCarta;

    @Column(name = "id_invocacion")
    private Integer idInvocacion;

    public CartaInvocacionId() {
    }

    public CartaInvocacionId(Integer idCarta, Integer idInvocacion) {
        this.idCarta = idCarta;
        this.idInvocacion = idInvocacion;
    }

    public Integer getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(Integer idCarta) {
        this.idCarta = idCarta;
    }

    public Integer getIdInvocacion() {
        return idInvocacion;
    }

    public void setIdInvocacion(Integer idInvocacion) {
        this.idInvocacion = idInvocacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CartaInvocacionId))
            return false;

        CartaInvocacionId that = (CartaInvocacionId) o;

        return Objects.equals(idCarta, that.idCarta)
                && Objects.equals(idInvocacion, that.idInvocacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCarta, idInvocacion);
    }
}
