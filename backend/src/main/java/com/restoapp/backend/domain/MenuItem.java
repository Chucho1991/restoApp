package com.restoapp.backend.domain;

import com.restoapp.backend.domain.enums.MenuCategory;
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
@Document(collection = "menu")
public class MenuItem {
    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private double precio;
    private MenuCategory categoria;
    private boolean disponible;
}
