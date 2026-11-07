package com.reservasvm.backendvm.repositorio;
import com.reservasvm.backendvm.entidades.usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repoUsuarios extends JpaRepository<usuarios, Long> {

    
} 
