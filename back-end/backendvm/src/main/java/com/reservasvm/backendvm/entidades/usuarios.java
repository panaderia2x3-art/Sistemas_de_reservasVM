package com.reservasvm.backendvm.entidades;
import jakarta.persistence.*;


@Entity 
@Table(name="usuarios")
public class usuarios {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, length = 100)
    private String nombre_user;

    @Column (nullable = false, length = 100)
    private String password_hash;

}
