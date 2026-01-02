package com.restoapp.backend.controller;

import com.restoapp.backend.domain.MenuItem;
import com.restoapp.backend.domain.enums.MenuCategory;
import com.restoapp.backend.dto.MenuItemRequest;
import com.restoapp.backend.service.MenuService;
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
@RequestMapping("/api/menu")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping
    public List<MenuItem> list(@RequestParam(required = false) MenuCategory categoria) {
        return menuService.list(categoria);
    }

    @PostMapping
    public ResponseEntity<MenuItem> create(@Valid @RequestBody MenuItemRequest request) {
        return ResponseEntity.ok(menuService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuItem> update(@PathVariable String id, @Valid @RequestBody MenuItemRequest request) {
        return menuService.update(id, request)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
