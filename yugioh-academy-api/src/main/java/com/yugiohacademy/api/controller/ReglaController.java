
package com.yugiohacademy.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yugiohacademy.api.entity.Regla;
import com.yugiohacademy.api.service.ReglaService;

@RestController
@RequestMapping("/api/reglas")
public class ReglaController {

    private final ReglaService reglaService;

    public ReglaController(ReglaService reglaService) {
        this.reglaService = reglaService;
    }

    // Obtener todas las reglas
    @GetMapping
    public ResponseEntity<List<Regla>> obtenerTodas() {
        return ResponseEntity.ok(reglaService.obtenerTodas());
    }

    // Obtener una regla por ID
    @GetMapping("/{id}")
    public ResponseEntity<Regla> obtenerPorId(@PathVariable Integer id) {
        return reglaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Registrar una regla
    @PostMapping
    public ResponseEntity<Regla> guardar(@RequestBody Regla regla) {
        Regla nuevaRegla = reglaService.guardar(regla);
        return ResponseEntity.ok(nuevaRegla);
    }

    // Actualizar una regla
    @PutMapping("/{id}")
    public ResponseEntity<Regla> actualizar(
            @PathVariable Integer id,
            @RequestBody Regla regla) {

        return reglaService.obtenerPorId(id)
                .map(reglaExistente -> {
                    regla.setIdRegla(id);
                    return ResponseEntity.ok(reglaService.guardar(regla));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar una regla
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

        if (reglaService.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        reglaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
