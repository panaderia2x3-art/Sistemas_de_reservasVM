package com.reservasvm.backendvm.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reservasvm.backendvm.entidades.fecha_no_laborales;

public interface repofechanl extends JpaRepository<fecha_no_laborales,Long>{

    
} 