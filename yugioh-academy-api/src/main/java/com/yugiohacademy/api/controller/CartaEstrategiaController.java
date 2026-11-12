
package com.yugiohacademy.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yugiohacademy.api.entity.CartaEstrategia;
import com.yugiohacademy.api.entity.CartaEstrategiaId;
import com.yugiohacademy.api.service.CartaEstrategiaService;

@RestController
@RequestMapping("/api/cartas-estrategias")
public class CartaEstrategiaController {

    private final CartaEstrategiaService cartaEstrategiaService;

    public CartaEstrategiaController(
            CartaEstrategiaService cartaEstrategiaService) {
        this.cartaEstrategiaService = cartaEstrategiaService;
    }

    // Obtener todas las relaciones entre cartas y estrategias
    @GetMapping
    public ResponseEntity<List<CartaEstrategia>> obtenerTodas() {
        return ResponseEntity.ok(cartaEstrategiaService.obtenerTodas());
    }

    // Obtener una relación mediante sus dos identificadores
    @GetMapping("/{idCarta}/{idEstrategia}")
    public ResponseEntity<CartaEstrategia> obtenerPorId(
            @PathVariable Integer idCarta,
            @PathVariable Integer idEstrategia) {

        CartaEstrategiaId id = new CartaEstrategiaId(idCarta, idEstrategia);

        return cartaEstrategiaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Registrar una relación
    @PostMapping
    public ResponseEntity<CartaEstrategia> guardar(
            @RequestBody CartaEstrategia cartaEstrategia) {

        CartaEstrategia nuevaRelacion = cartaEstrategiaService.guardar(cartaEstrategia);

        return ResponseEntity.ok(nuevaRelacion);
    }

    // Eliminar una relación
    @DeleteMapping("/{idCarta}/{idEstrategia}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Integer idCarta,
            @PathVariable Integer idEstrategia) {

        CartaEstrategiaId id = new CartaEstrategiaId(idCarta, idEstrategia);

        if (cartaEstrategiaService.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        cartaEstrategiaService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}
