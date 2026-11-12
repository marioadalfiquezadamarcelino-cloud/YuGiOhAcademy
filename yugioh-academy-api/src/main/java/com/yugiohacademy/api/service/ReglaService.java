
package com.yugiohacademy.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yugiohacademy.api.entity.Regla;
import com.yugiohacademy.api.repository.ReglaRepository;

@Service
@Transactional(readOnly = true)
public class ReglaService {

    private final ReglaRepository reglaRepository;

    public ReglaService(ReglaRepository reglaRepository) {
        this.reglaRepository = reglaRepository;
    }

    public List<Regla> obtenerTodas() {
        return reglaRepository.findAll();
    }

    public Optional<Regla> obtenerPorId(Integer id) {
        return reglaRepository.findById(id);
    }

    @Transactional
    public Regla guardar(Regla regla) {
        return reglaRepository.save(regla);
    }

    @Transactional
    public void eliminar(Integer id) {
        reglaRepository.deleteById(id);
    }
}
