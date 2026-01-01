package com.restoapp.backend.controller;

import com.restoapp.backend.domain.Mesa;
import com.restoapp.backend.dto.MesaRequest;
import com.restoapp.backend.service.MesaService;
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
@RequestMapping("/api/mesas")
@RequiredArgsConstructor
public class MesaController {
    private final MesaService mesaService;

    @GetMapping
    public List<Mesa> list(@RequestParam(required = false) Boolean disponible) {
        return mesaService.list(disponible);
    }

    @PostMapping
    public ResponseEntity<Mesa> create(@Valid @RequestBody MesaRequest request) {
        return ResponseEntity.ok(mesaService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mesa> update(@PathVariable String id, @Valid @RequestBody MesaRequest request) {
        return mesaService.update(id, request)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
