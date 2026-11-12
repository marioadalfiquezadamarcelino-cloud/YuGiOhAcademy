package com.yugiohacademy.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yugiohacademy.api.entity.TipoCarta;
import com.yugiohacademy.api.repository.TipoCartaRepository;

@Service
@Transactional(readOnly = true)
public class TipoCartaService {

    private final TipoCartaRepository tipoCartaRepository;

    public TipoCartaService(TipoCartaRepository tipoCartaRepository) {
        this.tipoCartaRepository = tipoCartaRepository;
    }

    public List<TipoCarta> obtenerTodas() {
        return tipoCartaRepository.findAll();
    }

    public Optional<TipoCarta> obtenerPorId(Integer id) {
        return tipoCartaRepository.findById(id);
    }

    @Transactional
    public TipoCarta guardar(TipoCarta tipoCarta) {
        return tipoCartaRepository.save(tipoCarta);
    }

    @Transactional
    public void eliminar(Integer id) {
        tipoCartaRepository.deleteById(id);
    }
}
