package com.reservasvm.backendvm.servicios;

import java.util.List;
import com.reservasvm.backendvm.repositorio.repoTecnico;
import com.reservasvm.backendvm.entidades.tecnicos;
import org.springframework.stereotype.Service;

@Service
public class serviceTecnico {
    private final repoTecnico repository;
    
    public serviceTecnico(repoTecnico repository){
        this.repository = repository;
    }

    public List<tecnicos> listar(){
        return repository.findAll();
    }

    public tecnicos buscarPorId(Long id){
        return repository.findById(id)
            .orElseThrow(()-> new RuntimeException("Tecnico no encontrado"));
    }

    public tecnicos guardar(tecnicos tecnico){
        return repository.save(tecnico);
    }

    public void eliminar(Long id){
        repository.deleteById(id);
    }

    
}
