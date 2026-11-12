
package com.yugiohacademy.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yugiohacademy.api.entity.Carta;
import com.yugiohacademy.api.service.CartaService;

@RestController
@RequestMapping("/api/cartas")
public class CartaController {

    private final CartaService cartaService;

    public CartaController(CartaService cartaService) {
        this.cartaService = cartaService;
    }

    // Obtener todas las cartas
    @GetMapping
    public ResponseEntity<List<Carta>> obtenerTodas() {
        return ResponseEntity.ok(cartaService.obtenerTodas());
    }

    // Obtener una carta por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Carta> obtenerPorId(@PathVariable Integer id) {
        return cartaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Registrar una carta
    @PostMapping
    public ResponseEntity<Carta> guardar(@RequestBody Carta carta) {
        Carta nuevaCarta = cartaService.guardar(carta);
        return ResponseEntity.ok(nuevaCarta);
    }

    // Actualizar una carta
    @PutMapping("/{id}")
    public ResponseEntity<Carta> actualizar(
            @PathVariable Integer id,
            @RequestBody Carta carta) {

        return cartaService.obtenerPorId(id)
                .map(cartaExistente -> {
                    carta.setIdCarta(id);
                    return ResponseEntity.ok(cartaService.guardar(carta));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar una carta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

        if (cartaService.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        cartaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
