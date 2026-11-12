package com.yugiohacademy.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yugiohacademy.api.entity.Estrategia;
import com.yugiohacademy.api.repository.EstrategiaRepository;

@Service
@Transactional(readOnly = true)
public class EstrategiaService {

    private final EstrategiaRepository estrategiaRepository;

    public EstrategiaService(EstrategiaRepository estrategiaRepository) {
        this.estrategiaRepository = estrategiaRepository;
    }

    public List<Estrategia> obtenerTodas() {
        return estrategiaRepository.findAll();
    }

    public Optional<Estrategia> obtenerPorId(Integer id) {
        return estrategiaRepository.findById(id);
    }

    @Transactional
    public Estrategia guardar(Estrategia estrategia) {
        return estrategiaRepository.save(estrategia);
    }

    @Transactional
    public void eliminar(Integer id) {
        estrategiaRepository.deleteById(id);
    }
}
