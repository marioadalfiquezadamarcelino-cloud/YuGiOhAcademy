
package com.yugiohacademy.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yugiohacademy.api.entity.TipoInvocacion;
import com.yugiohacademy.api.service.TipoInvocacionService;

@RestController
@RequestMapping("/api/tipos-invocacion")
public class TipoInvocacionController {

    private final TipoInvocacionService tipoInvocacionService;

    public TipoInvocacionController(TipoInvocacionService tipoInvocacionService) {
        this.tipoInvocacionService = tipoInvocacionService;
    }

    // Obtener todos los tipos de invocación
    @GetMapping
    public ResponseEntity<List<TipoInvocacion>> obtenerTodas() {
        return ResponseEntity.ok(tipoInvocacionService.obtenerTodas());
    }

    // Obtener un tipo de invocación por ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoInvocacion> obtenerPorId(@PathVariable Integer id) {
        return tipoInvocacionService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Registrar un tipo de invocación
    @PostMapping
    public ResponseEntity<TipoInvocacion> guardar(
            @RequestBody TipoInvocacion tipoInvocacion) {

        TipoInvocacion nuevoTipo = tipoInvocacionService.guardar(tipoInvocacion);
        return ResponseEntity.ok(nuevoTipo);
    }

    // Actualizar un tipo de invocación
    @PutMapping("/{id}")
    public ResponseEntity<TipoInvocacion> actualizar(
            @PathVariable Integer id,
            @RequestBody TipoInvocacion tipoInvocacion) {

        return tipoInvocacionService.obtenerPorId(id)
                .map(tipoExistente -> {
                    tipoInvocacion.setIdInvocacion(id);
                    return ResponseEntity.ok(
                            tipoInvocacionService.guardar(tipoInvocacion));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un tipo de invocación
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

        if (tipoInvocacionService.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        tipoInvocacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
