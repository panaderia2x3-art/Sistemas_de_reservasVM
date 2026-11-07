package com.reservasvm.backendvm.DTO.Usuarios;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data 
public class dtoRegistroUsuario {
    
    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Size(min = 3, max = 35, message = "No supere el limite de 3 a 35 caracteres")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+$", message = "El nombre solo debe tener caracteres")
    private String nombre_user;

    @NotBlank(message = "La contraseña debe ser obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String password_hash;
}