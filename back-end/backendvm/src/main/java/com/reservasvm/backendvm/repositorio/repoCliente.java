package com.reservasvm.backendvm.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reservasvm.backendvm.entidades.clientes;

public interface repoCliente extends JpaRepository<clientes,Long> {
} 
