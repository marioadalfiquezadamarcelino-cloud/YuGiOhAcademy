
package com.yugiohacademy.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yugiohacademy.api.entity.CartaInvocacion;
import com.yugiohacademy.api.entity.CartaInvocacionId;
import com.yugiohacademy.api.service.CartaInvocacionService;

@RestController
@RequestMapping("/api/cartas-invocaciones")
public class CartaInvocacionController {

    private final CartaInvocacionService cartaInvocacionService;

    public CartaInvocacionController(
            CartaInvocacionService cartaInvocacionService) {
        this.cartaInvocacionService = cartaInvocacionService;
    }

    // Obtener todas las relaciones entre cartas e invocaciones
    @GetMapping
    public ResponseEntity<List<CartaInvocacion>> obtenerTodas() {
        return ResponseEntity.ok(cartaInvocacionService.obtenerTodas());
    }

    // Obtener una relación mediante sus dos identificadores
    @GetMapping("/{idCarta}/{idInvocacion}")
    public ResponseEntity<CartaInvocacion> obtenerPorId(
            @PathVariable Integer idCarta,
            @PathVariable Integer idInvocacion) {

        CartaInvocacionId id = new CartaInvocacionId(idCarta, idInvocacion);

        return cartaInvocacionService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Registrar una relación
    @PostMapping
    public ResponseEntity<CartaInvocacion> guardar(
            @RequestBody CartaInvocacion cartaInvocacion) {

        CartaInvocacion nuevaRelacion = cartaInvocacionService.guardar(cartaInvocacion);

        return ResponseEntity.ok(nuevaRelacion);
    }

    // Eliminar una relación
    @DeleteMapping("/{idCarta}/{idInvocacion}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Integer idCarta,
            @PathVariable Integer idInvocacion) {

        CartaInvocacionId id = new CartaInvocacionId(idCarta, idInvocacion);

        if (cartaInvocacionService.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        cartaInvocacionService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}
