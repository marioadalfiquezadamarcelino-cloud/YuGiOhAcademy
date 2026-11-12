
package com.yugiohacademy.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yugiohacademy.api.entity.CartaInvocacion;
import com.yugiohacademy.api.entity.CartaInvocacionId;
import com.yugiohacademy.api.repository.CartaInvocacionRepository;

@Service
@Transactional(readOnly = true)
public class CartaInvocacionService {

    private final CartaInvocacionRepository cartaInvocacionRepository;

    public CartaInvocacionService(CartaInvocacionRepository cartaInvocacionRepository) {
        this.cartaInvocacionRepository = cartaInvocacionRepository;
    }

    public List<CartaInvocacion> obtenerTodas() {
        return cartaInvocacionRepository.findAll();
    }

    public Optional<CartaInvocacion> obtenerPorId(CartaInvocacionId id) {
        return cartaInvocacionRepository.findById(id);
    }

    @Transactional
    public CartaInvocacion guardar(CartaInvocacion cartaInvocacion) {
        return cartaInvocacionRepository.save(cartaInvocacion);
    }

    @Transactional
    public void eliminar(CartaInvocacionId id) {
        cartaInvocacionRepository.deleteById(id);
    }
}
