
package com.yugiohacademy.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yugiohacademy.api.entity.TipoInvocacion;
import com.yugiohacademy.api.repository.TipoInvocacionRepository;

@Service
@Transactional(readOnly = true)
public class TipoInvocacionService {

    private final TipoInvocacionRepository tipoInvocacionRepository;

    public TipoInvocacionService(TipoInvocacionRepository tipoInvocacionRepository) {
        this.tipoInvocacionRepository = tipoInvocacionRepository;
    }

    public List<TipoInvocacion> obtenerTodas() {
        return tipoInvocacionRepository.findAll();
    }

    public Optional<TipoInvocacion> obtenerPorId(Integer id) {
        return tipoInvocacionRepository.findById(id);
    }

    @Transactional
    public TipoInvocacion guardar(TipoInvocacion tipoInvocacion) {
        return tipoInvocacionRepository.save(tipoInvocacion);
    }

    @Transactional
    public void eliminar(Integer id) {
        tipoInvocacionRepository.deleteById(id);
    }
}
