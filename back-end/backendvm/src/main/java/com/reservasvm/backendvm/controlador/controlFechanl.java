package com.reservasvm.backendvm.controlador;



import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.reservasvm.backendvm.servicios.serviceFechanl;
import com.reservasvm.backendvm.entidades.fecha_no_laborales;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping("/api/fecha_no_laborales") 
public class controlFechanl {

    private serviceFechanl servicios;

    public controlFechanl(serviceFechanl servicios){
        this.servicios = servicios;
    }


    @GetMapping
    public List<fecha_no_laborales> listar() {
        return servicios.listar();
    }

    @GetMapping("/{id}")
    public fecha_no_laborales buscar(@PathVariable  Long id) {
        return servicios.buscar(id);
    }

    @PostMapping
    public fecha_no_laborales crear(@RequestBody fecha_no_laborales fechanl) {
        return servicios.guardar(fechanl);
    }

    @PostMapping("/{id}")
    public fecha_no_laborales actualizar(@RequestBody fecha_no_laborales fechanl, @PathVariable Long id ) {
        fechanl.setId_fechanl(id);
        return servicios.guardar(fechanl);
    }

    @DeleteMapping("/{id}")
    public  void eliminar(@PathVariable Long id){
        servicios.eliminar(id);
    }


    
    
    
    
}
