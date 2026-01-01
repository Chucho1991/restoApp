package com.restoapp.backend.dto;

import com.restoapp.backend.domain.enums.OrderStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Data;

@Data
public class CreateOrderRequest {
    @NotBlank
    private String mesaId;

    @NotBlank
    private String meseroId;

    @Valid
    @NotEmpty
    private List<CreateOrderItemRequest> items;

    @NotNull
    private OrderStatus estado;

    @Min(0)
    private double total;
}
