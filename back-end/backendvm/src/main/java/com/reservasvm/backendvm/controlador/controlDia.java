package com.reservasvm.backendvm.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.reservasvm.backendvm.servicios.serviceDia;
import com.reservasvm.backendvm.entidades.dia;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
@RequestMapping ("/api/dia")
@CrossOrigin(origins = "http://localhost:4200")
public class controlDia {
    private serviceDia servicio;

    public controlDia (serviceDia servicio){
        this.servicio= servicio;
    }

    @GetMapping()
    public List<dia> Listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public dia busqueda(@PathVariable Long id) {
        return servicio.buscar(id);
    }

    @PostMapping()
    public dia crear(@RequestBody dia dias) {
        return servicio.guardar(dias);
    }
    
    @PostMapping("/{id}")
    public dia actualizar(@RequestBody dia dias, @PathVariable Long id ) {
        dias.setId_dias(id);
        return servicio.guardar(dias);
    }

    @DeleteMapping("/id")
    public void eliminar(@PathVariable Long id){
        servicio.eliminar(id);
    }
    
    
    
}
