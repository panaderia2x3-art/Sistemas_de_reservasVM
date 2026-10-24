package com.reservasvm.backendvm.servicios;

import com.reservasvm.backendvm.entidades.clientes;
import com.reservasvm.backendvm.repositorio.repoCliente;
import java.util.List;

import org.springframework.stereotype.Service;


@Service 
public class serviceCliente {

    private final repoCliente repositorio;

    public serviceCliente (repoCliente repositorio){
        this.repositorio= repositorio;
    }

    public List<clientes> listar(){
        return repositorio.findAll();
    }

    public clientes buscarPorID(Long id){
        return repositorio.
        findById(id).orElseThrow(()-> new RuntimeException("Cliente no encontrado"));
    }

    public clientes guaradar(clientes cliente){
        return repositorio.save(cliente);
    }

    public void eliminar(Long id){
        repositorio.deleteById(id);
    }
    
}
