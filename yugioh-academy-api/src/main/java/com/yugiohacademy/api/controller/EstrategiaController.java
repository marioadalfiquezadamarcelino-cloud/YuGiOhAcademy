
package com.yugiohacademy.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yugiohacademy.api.entity.Estrategia;
import com.yugiohacademy.api.service.EstrategiaService;

@RestController
@RequestMapping("/api/estrategias")
public class EstrategiaController {

    private final EstrategiaService estrategiaService;

    public EstrategiaController(EstrategiaService estrategiaService) {
        this.estrategiaService = estrategiaService;
    }

    // Obtener todas las estrategias
    @GetMapping
    public ResponseEntity<List<Estrategia>> obtenerTodas() {
        return ResponseEntity.ok(estrategiaService.obtenerTodas());
    }

    // Obtener una estrategia por ID
    @GetMapping("/{id}")
    public ResponseEntity<Estrategia> obtenerPorId(@PathVariable Integer id) {
        return estrategiaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Registrar una estrategia
    @PostMapping
    public ResponseEntity<Estrategia> guardar(@RequestBody Estrategia estrategia) {
        Estrategia nuevaEstrategia = estrategiaService.guardar(estrategia);
        return ResponseEntity.ok(nuevaEstrategia);
    }

    // Actualizar una estrategia
    @PutMapping("/{id}")
    public ResponseEntity<Estrategia> actualizar(
            @PathVariable Integer id,
            @RequestBody Estrategia estrategia) {

        return estrategiaService.obtenerPorId(id)
                .map(estrategiaExistente -> {
                    estrategia.setIdEstrategia(id);
                    return ResponseEntity.ok(estrategiaService.guardar(estrategia));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar una estrategia
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

        if (estrategiaService.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        estrategiaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
