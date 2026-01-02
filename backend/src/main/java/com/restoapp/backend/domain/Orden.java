package com.restoapp.backend.domain;

import com.restoapp.backend.domain.enums.OrderStatus;
import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ordenes")
public class Orden {
    @Id
    private String id;
    private String mesaId;
    private String meseroId;
    private List<OrderItem> items;
    private double total;
    private OrderStatus estado;
    private Instant creadaEn;
    private Instant actualizadaEn;
}
