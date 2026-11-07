package com.reservasvm.backendvm.DTO.Usuarios;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class dtoRespuestaUsuario {
    private long id;
    private String nombreUsuario;
}
