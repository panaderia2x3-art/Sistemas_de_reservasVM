package com.reservasvm.backendvm.entidades;
import java.time.LocalDate;
import java.time.LocalTime;
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
    private Long id;

    @Enumerated (EnumType.STRING)
    @Column (nullable = false)
    private TipoActividad tipo;

    @Enumerated(EnumType.STRING)
    @Column (nullable = false)
    private EstadoActividad estado;

    @Column (nullable = false)
    private LocalDate dia_inicio;

    @Column (nullable = false)
    private LocalDate dia_final;

    @Column (nullable = false)
    private LocalTime hora_inicio;

    @Column (nullable = false)
    private LocalTime hora_final;

    @Column (nullable = true, length = 500)
    private String notas;

    @ManyToOne (optional = false)
    @JoinColumn (name = "id_tecnicos")
    private tecnicos tecnico;

    @ManyToOne (optional = false)
    @JoinColumn (name="id_clientes")
    private clientes cliente;


}
