        package com.reservasvm.backendvm.controlador;

        import java.util.List;

        import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.web.bind.annotation.DeleteMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

        import com.reservasvm.backendvm.DTO.Usuarios.dtoRegistroUsuario;
        import com.reservasvm.backendvm.DTO.Usuarios.dtoRespuestaUsuario;
        import com.reservasvm.backendvm.servicios.serviceUsuario;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.PutMapping;
    import org.springframework.web.bind.annotation.RequestBody;

        import jakarta.validation.Valid;;

        @RestController 
        @RequestMapping ("/api/usuarios")
        @CrossOrigin (origins = "http://localhost:4200")
        public class controlUsuario {
            private serviceUsuario servicio;

            public controlUsuario (serviceUsuario servicio){
                this.servicio = servicio;
            }

            @GetMapping()
            public List<dtoRespuestaUsuario> listar() {
                return servicio.listar();
            }

            @GetMapping("/{id}")
            public dtoRespuestaUsuario buscar(@PathVariable Long id) {
                return servicio.buscarporID(id);
            }

            @PostMapping()
            public dtoRespuestaUsuario guardar(@Valid @RequestBody dtoRegistroUsuario dto) {
                return servicio.guardar(dto);
            }

            @PutMapping("/{id}")
            public dtoRespuestaUsuario actualizar(@Valid @RequestBody dtoRegistroUsuario Rdto, @PathVariable Long id) {
                return servicio.actualizar(Rdto,id);
            }

            @DeleteMapping ("/{id}")
            public void  eliminar(@PathVariable Long id){
                servicio.eliminar(id);
            }
        
        
        
        
    }
