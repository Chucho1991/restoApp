package com.restoapp.backend.controller;

import com.restoapp.backend.domain.Orden;
import com.restoapp.backend.domain.enums.OrderStatus;
import com.restoapp.backend.dto.CreateOrderRequest;
import com.restoapp.backend.service.OrdenService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ordenes")
@RequiredArgsConstructor
public class OrdenController {
    private final OrdenService ordenService;

    @GetMapping
    public List<Orden> list(@RequestParam(required = false) OrderStatus estado) {
        return ordenService.list(estado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orden> find(@PathVariable String id) {
        return ordenService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Orden> create(@Valid @RequestBody CreateOrderRequest request) {
        return ResponseEntity.ok(ordenService.create(request));
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Orden> updateEstado(@PathVariable String id, @RequestParam OrderStatus estado) {
        return ordenService.updateStatus(id, estado)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
