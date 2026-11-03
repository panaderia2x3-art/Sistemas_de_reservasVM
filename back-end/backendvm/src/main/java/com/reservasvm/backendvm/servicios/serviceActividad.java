package com.reservasvm.backendvm.servicios;

import com.reservasvm.backendvm.repositorio.repoActividad;

import org.springframework.transaction.annotation.Transactional;

import com.reservasvm.backendvm.entidades.actividades;
import com.reservasvm.backendvm.entidades.dia;

import java.util.List;

import org.springframework.stereotype.Service;


@Service 
public class serviceActividad {
    
    private repoActividad repositorio;

    public serviceActividad(repoActividad repositorio){
        this.repositorio= repositorio;
    }

    @Transactional (readOnly = true)
    public List<actividades> listar(){
        return repositorio.findAll();
    }

    @Transactional 
    public actividades guardar(actividades actividad){

        if(actividad.getDias() !=null){
            for(dia d: actividad.getDias()){
                d.setActividad(actividad);
            }
        }

        return repositorio.save(actividad);
    }

    @Transactional (readOnly = true)
    public actividades buscar(Long id){
        return repositorio.findById(id).orElseThrow(()-> new RuntimeException("No se encontro la actividad"));
    }

    public void eliminar(Long id){
         repositorio.deleteById(id);
    }
}
