package com.reservasvm.backendvm.entidades;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Setter 
@Getter 
@Table (name = "fecha_no_laborales")
public class fecha_no_laborales {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_fechanl;

    @Column (nullable = false, unique = true)
    private LocalDate fecha_nl;

    @Column (nullable = true, length = 500)
    private String motivo;

}
