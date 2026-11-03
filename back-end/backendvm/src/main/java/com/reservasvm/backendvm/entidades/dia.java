package com.reservasvm.backendvm.entidades;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Getter 
@Setter 
@NoArgsConstructor 
@Table(name="dias")
public class dia {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_dias;

    @Column (nullable = false)
    private LocalDate fecha;

    @Column (nullable = false)
    private LocalTime hora_inicio;

    @Column (nullable = false)
    private LocalTime hora_final;

    @ManyToOne (optional = false)
    @JoinColumn (name = "id_actividades")
    @JsonBackReference 
    private actividades actividad;
}
