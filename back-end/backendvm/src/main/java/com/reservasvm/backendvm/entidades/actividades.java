package com.reservasvm.backendvm.entidades;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity 
@Getter 
@Setter 
@NoArgsConstructor 
@Table (name = "actividades")
public class actividades {

    public enum EstadoActividad {
    PENDIENTE, EN_CURSO, TERMINADA, CANCELADA
    }

    public enum TipoActividad{
        MEDIDAS,TRABAJO
    }

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_actividades;

    @Enumerated (EnumType.STRING)
    @Column (nullable = false)
    private TipoActividad tipo;

    @Enumerated(EnumType.STRING)
    @Column (nullable = false)
    private EstadoActividad estado;

    @Column (nullable = true, length = 500)
    private String notas;

    @ManyToOne (optional = false)
    @JoinColumn (name = "id_tecnicos")
    private tecnicos tecnico;

    @ManyToOne (optional = false)
    @JoinColumn (name="id_clientes")
    private clientes cliente;

    @OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference 
    private List<dia> dias= new ArrayList<>();


}
