package com.yugiohacademy.api.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yugiohacademy.api.entity.Carta;
import com.yugiohacademy.api.repository.CartaRepository;

@Service
@Transactional(readOnly = true)
public class CartaService {

    private final CartaRepository cartaRepository;

    public CartaService(CartaRepository cartaRepository) {
        this.cartaRepository = cartaRepository;
    }

    public List<Carta> obtenerTodas() {
        return cartaRepository.findAll();
    }

    public Optional<Carta> obtenerPorId(Integer id) {
        return cartaRepository.findById(id);
    }

    @Transactional
    public Carta guardar(Carta carta) {
        return cartaRepository.save(carta);
    }

    @Transactional
    public void eliminar(Integer id) {
        cartaRepository.deleteById(id);
    }
}
