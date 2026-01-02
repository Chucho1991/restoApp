package com.restoapp.backend.dto;

import com.restoapp.backend.domain.enums.MenuCategory;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MenuItemRequest {
    @NotBlank
    private String nombre;

    private String descripcion;

    @Min(0)
    private double precio;

    @NotNull
    private MenuCategory categoria;

    private boolean disponible = true;
}
