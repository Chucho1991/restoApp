package com.restoapp.backend.service;

import com.restoapp.backend.domain.OrderItem;
import com.restoapp.backend.domain.Orden;
import com.restoapp.backend.domain.enums.OrderStatus;
import com.restoapp.backend.dto.CreateOrderItemRequest;
import com.restoapp.backend.dto.CreateOrderRequest;
import com.restoapp.backend.repository.OrdenRepository;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrdenService {
    private final OrdenRepository ordenRepository;

    public List<Orden> list(OrderStatus estado) {
        if (estado != null) {
            return ordenRepository.findByEstadoOrderByCreadaEnAsc(estado);
        }
        return ordenRepository.findAll();
    }

    public Optional<Orden> findById(String id) {
        return ordenRepository.findById(id);
    }

    public Orden create(CreateOrderRequest request) {
        List<OrderItem> items = request.getItems().stream()
                .map(this::mapItem)
                .toList();
        Orden orden = Orden.builder()
                .mesaId(request.getMesaId())
                .meseroId(request.getMeseroId())
                .items(items)
                .total(request.getTotal())
                .estado(request.getEstado())
                .creadaEn(Instant.now())
                .actualizadaEn(Instant.now())
                .build();
        return ordenRepository.save(orden);
    }

    public Optional<Orden> updateStatus(String id, OrderStatus nuevoEstado) {
        return ordenRepository.findById(id).map(existing -> {
            existing.setEstado(nuevoEstado);
            existing.setActualizadaEn(Instant.now());
            return ordenRepository.save(existing);
        });
    }

    private OrderItem mapItem(CreateOrderItemRequest request) {
        return OrderItem.builder()
                .menuItemId(request.getMenuItemId())
                .nombre(request.getNombre())
                .cantidad(request.getCantidad())
                .precio(request.getPrecio())
                .build();
    }
}
