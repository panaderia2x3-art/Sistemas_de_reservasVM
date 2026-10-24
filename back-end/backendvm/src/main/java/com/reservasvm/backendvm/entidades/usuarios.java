package com.reservasvm.backendvm.entidades;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity 
@Setter 
@Getter 
@NoArgsConstructor 
@Table(name="usuarios")
public class usuarios {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, length = 100, unique = true)
    private String nombre_user;

    @Column (nullable = false, length = 100)
    private String password_hash;
}
