package com.reservasvm.backendvm.entidades;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity 
@Setter 
@Getter 
@NoArgsConstructor 
@Table (name = "clientes")
public class clientes {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_clientes;

    @Column (nullable = false, length = 100)
    private String nombre_cliente;

    @Column (nullable = true, length = 100)
    private String telefono_cliente;

    @Column (nullable = false, length = 300)
    private String direccion;

    @Column(nullable = true, length= 500)
    private String enlace_mapa;

}
