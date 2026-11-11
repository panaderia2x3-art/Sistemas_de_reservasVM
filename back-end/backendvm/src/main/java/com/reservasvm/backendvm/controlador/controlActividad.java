package com.reservasvm.backendvm.controlador;

import com.reservasvm.backendvm.servicios.serviceActividad;

import com.reservasvm.backendvm.entidades.actividades;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController 
@RequestMapping("/api/actividades")
@CrossOrigin(origins = "http://localhost:4200")
public class controlActividad {
    
    private serviceActividad servicio;

    public controlActividad(serviceActividad servicio){
        this.servicio = servicio;
    }

    @GetMapping
    public List<actividades> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public actividades buscar(@PathVariable Long id) {
        return servicio.buscar(id);
    }

    @PostMapping
    public actividades guardar(@RequestBody actividades actividad) {
        return servicio.guardar(actividad);
    }

    @PostMapping("/{id}")
    public actividades actualizar(@RequestBody actividades actividad, @PathVariable Long id) {
        actividad.setId_actividades(id);
        return servicio.guardar(actividad);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        servicio.eliminar(id);
    }

    
    
    
    
}
