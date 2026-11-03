package com.reservasvm.backendvm.servicios;

import org.springframework.stereotype.Service;
import java.util.List;

import com.reservasvm.backendvm.entidades.dia;
import com.reservasvm.backendvm.repositorio.repoDia;

@Service 
public class serviceDia {
    
    private repoDia repositorio;

    public  serviceDia(repoDia repositorio){
        this.repositorio = repositorio;
    }

    public List<dia> listar(){
        return repositorio.findAll();
    }

    public dia guardar(dia dias){
        return repositorio.save(dias);
    }

    public dia buscar(Long id){
        return repositorio.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el error"));
    }

    public void eliminar(Long id){
        repositorio.deleteById(id);
    }
}
