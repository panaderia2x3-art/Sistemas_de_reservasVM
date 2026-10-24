package com.reservasvm.backendvm.servicios;

import com.reservasvm.backendvm.entidades.fecha_no_laborales;
import com.reservasvm.backendvm.repositorio.repofechanl;
import org.springframework.stereotype.Service;
import java.util.List;

@Service 
public class serviceFechanl {
    private repofechanl repositorio;

    public  serviceFechanl(repofechanl repositorio){
        this.repositorio= repositorio;
    }

    public List<fecha_no_laborales> listar(){
        return repositorio.findAll();
    }

    public fecha_no_laborales buscar(Long id){
        return repositorio.findById(id).orElseThrow(()->new RuntimeException("no se encontro la fecha"));
    }

    public fecha_no_laborales guardar(fecha_no_laborales fechanl){
        return repositorio.save(fechanl);   
    }

    public void eliminar(Long id){
        repositorio.deleteById(id);
    }
}
