package com.reservasvm.backendvm.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reservasvm.backendvm.entidades.tecnicos;



public interface repoTecnico extends JpaRepository<tecnicos,Long> {
    
}
