package com.reservasvm.backendvm.repositorio;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reservasvm.backendvm.entidades.fecha_no_laborales;

public interface repofechanl extends JpaRepository<fecha_no_laborales,Long>{

    @Query("SELECT count(f) > 0 FROM fecha_no_laborales f WHERE f.fecha_nl = :fechaIndicado")
    boolean Verificarfechanolaborable(
        @Param("fechaIndicado") LocalDate fecha
    );
    
} 