package com.reservasvm.backendvm.controlador;

import com.reservasvm.backendvm.entidades.clientes;
import com.reservasvm.backendvm.servicios.serviceCliente;
import java.util.List;

import org.springframework.web.bind.annotation.*;




@RestController 
@RequestMapping("/api/clientes") 
@CrossOrigin(origins = "http://localhost:4200")
public class controlCliente {
    private serviceCliente servicio;

    public controlCliente(serviceCliente servicio){
        this.servicio= servicio;
    }

    @GetMapping
    public List<clientes> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public clientes buscar(@PathVariable Long id) {
        return servicio.buscarPorID(id);
    }

    @PostMapping
    public clientes crear(@RequestBody clientes cliente) {        
        return servicio.guaradar(cliente);
    }

    @PostMapping("/{id}")
    public clientes actualizar(@RequestBody clientes cliente, @PathVariable Long id) {
        cliente.setId_clientes(id);
        return servicio.guaradar(cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        servicio.eliminar(id);
    }


    
    
    
    
}
