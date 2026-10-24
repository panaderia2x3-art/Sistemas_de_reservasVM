package com.reservasvm.backendvm.entidades;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Setter 
@Getter 
@NoArgsConstructor 
@Table (name = "tecnicos")
public class tecnicos {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tecnicos;
    
    @Column (nullable = false, length = 100)
    private String nombre_tecnico;

    @Column (nullable = false, length = 100)
    private String apellido_tecnico;

    @Column (nullable = false, length = 15)
    private String telefono_tecnico;

    @Column (nullable = false)
    private boolean activo=true;
}
