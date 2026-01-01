package com.restoapp.backend.service;

import com.restoapp.backend.domain.MenuItem;
import com.restoapp.backend.domain.enums.MenuCategory;
import com.restoapp.backend.dto.MenuItemRequest;
import com.restoapp.backend.repository.MenuRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public List<MenuItem> list(MenuCategory categoria) {
        if (categoria != null) {
            return menuRepository.findByCategoria(categoria);
        }
        return menuRepository.findAll();
    }

    public MenuItem create(MenuItemRequest request) {
        MenuItem item = MenuItem.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .precio(request.getPrecio())
                .categoria(request.getCategoria())
                .disponible(request.isDisponible())
                .build();
        return menuRepository.save(item);
    }

    public Optional<MenuItem> update(String id, MenuItemRequest request) {
        return menuRepository.findById(id).map(existing -> {
            existing.setNombre(request.getNombre());
            existing.setDescripcion(request.getDescripcion());
            existing.setPrecio(request.getPrecio());
            existing.setCategoria(request.getCategoria());
            existing.setDisponible(request.isDisponible());
            return menuRepository.save(existing);
        });
    }
}
