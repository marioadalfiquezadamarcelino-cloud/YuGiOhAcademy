
package com.yugiohacademy.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yugiohacademy.api.entity.CartaEstrategia;
import com.yugiohacademy.api.entity.CartaEstrategiaId;
import com.yugiohacademy.api.repository.CartaEstrategiaRepository;

@Service
@Transactional(readOnly = true)
public class CartaEstrategiaService {

    private final CartaEstrategiaRepository cartaEstrategiaRepository;

    public CartaEstrategiaService(CartaEstrategiaRepository cartaEstrategiaRepository) {
        this.cartaEstrategiaRepository = cartaEstrategiaRepository;
    }

    public List<CartaEstrategia> obtenerTodas() {
        return cartaEstrategiaRepository.findAll();
    }

    public Optional<CartaEstrategia> obtenerPorId(CartaEstrategiaId id) {
        return cartaEstrategiaRepository.findById(id);
    }

    @Transactional
    public CartaEstrategia guardar(CartaEstrategia cartaEstrategia) {
        return cartaEstrategiaRepository.save(cartaEstrategia);
    }

    @Transactional
    public void eliminar(CartaEstrategiaId id) {
        cartaEstrategiaRepository.deleteById(id);
    }
}
