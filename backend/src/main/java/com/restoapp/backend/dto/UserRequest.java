package com.restoapp.backend.dto;

import com.restoapp.backend.domain.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequest {
    @NotBlank
    private String nombre;

    @Email
    @NotBlank
    private String email;

    @NotNull
    private Role rol;
}
