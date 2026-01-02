package com.restoapp.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateOrderItemRequest {
    @NotBlank
    private String menuItemId;
    @NotBlank
    private String nombre;
    @Min(1)
    private int cantidad;
    @Min(0)
    private double precio;
}
