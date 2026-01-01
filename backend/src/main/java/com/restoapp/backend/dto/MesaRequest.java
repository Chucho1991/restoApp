package com.restoapp.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MesaRequest {
    @NotBlank
    private String nombre;

    private boolean disponible = true;

    @Min(1)
    private int ocupantesPosibles;

    @Min(0)
    private int ocupantesActuales;
}
