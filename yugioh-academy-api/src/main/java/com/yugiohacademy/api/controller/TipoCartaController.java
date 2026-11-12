
package com.yugiohacademy.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yugiohacademy.api.entity.TipoCarta;
import com.yugiohacademy.api.service.TipoCartaService;

@RestController
@RequestMapping("/api/tipos-cartas")
public class TipoCartaController {

    private final TipoCartaService tipoCartaService;

    public TipoCartaController(TipoCartaService tipoCartaService) {
        this.tipoCartaService = tipoCartaService;
    }

    // Obtener todos los tipos de cartas
    @GetMapping
    public ResponseEntity<List<TipoCarta>> obtenerTodas() {
        return ResponseEntity.ok(tipoCartaService.obtenerTodas());
    }

    // Obtener un tipo de carta por ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoCarta> obtenerPorId(@PathVariable Integer id) {
        return tipoCartaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Registrar un tipo de carta
    @PostMapping
    public ResponseEntity<TipoCarta> guardar(@RequestBody TipoCarta tipoCarta) {
        TipoCarta nuevoTipo = tipoCartaService.guardar(tipoCarta);
        return ResponseEntity.ok(nuevoTipo);
    }

    // Actualizar un tipo de carta
    @PutMapping("/{id}")
    public ResponseEntity<TipoCarta> actualizar(
            @PathVariable Integer id,
            @RequestBody TipoCarta tipoCarta) {

        return tipoCartaService.obtenerPorId(id)
                .map(tipoExistente -> {
                    tipoCarta.setIdTipo(id);
                    return ResponseEntity.ok(tipoCartaService.guardar(tipoCarta));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un tipo de carta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

        if (tipoCartaService.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        tipoCartaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
