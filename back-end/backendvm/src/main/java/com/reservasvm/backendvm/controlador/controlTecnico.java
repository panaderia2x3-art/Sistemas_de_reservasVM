package com.reservasvm.backendvm.controlador;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.reservasvm.backendvm.entidades.tecnicos;
import com.reservasvm.backendvm.servicios.serviceTecnico;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController 
@RequestMapping("/api/tecnicos")
public class controlTecnico {
    private final serviceTecnico service ;

    public controlTecnico(serviceTecnico service){
        this.service = service;
    }

    @GetMapping
    public List<tecnicos>listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public tecnicos buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping 
    public tecnicos crear(@RequestBody tecnicos tecnico) {
        return service.guardar(tecnico);
    }

    @PutMapping("/{id}")
    public tecnicos actualizar(@PathVariable Long id, @RequestBody tecnicos tecnico) {
        tecnico.setId_tecnicos(id);
        return service.guardar(tecnico);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        service.eliminar(id);
    }
    
    
    
}
