package com.yugiohacademy.api.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Column;
@Embeddable
public class CartaEstrategiaId implements Serializable {

@Column(name = "id_carta")
private Integer idCarta;

@Column(name = "id_estrategia")
private Integer idEstrategia;

    public CartaEstrategiaId() {
    }

    public CartaEstrategiaId(Integer idCarta, Integer idEstrategia) {
        this.idCarta = idCarta;
        this.idEstrategia = idEstrategia;
    }

    public Integer getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(Integer idCarta) {
        this.idCarta = idCarta;
    }

    public Integer getIdEstrategia() {
        return idEstrategia;
    }

    public void setIdEstrategia(Integer idEstrategia) {
        this.idEstrategia = idEstrategia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartaEstrategiaId)) return false;

        CartaEstrategiaId that = (CartaEstrategiaId) o;

        return Objects.equals(idCarta, that.idCarta)
                && Objects.equals(idEstrategia, that.idEstrategia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCarta, idEstrategia);
    }
}
