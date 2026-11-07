package com.reservasvm.backendvm.servicios;
import com.reservasvm.backendvm.entidades.usuarios;

import java.util.List;



import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.reservasvm.backendvm.DTO.Usuarios.dtoRegistroUsuario;
import com.reservasvm.backendvm.DTO.Usuarios.dtoRespuestaUsuario;
import com.reservasvm.backendvm.repositorio.repoUsuarios;


@Service 
public class serviceUsuario {
    private repoUsuarios repositorio;
    private PasswordEncoder encriptado;

    public serviceUsuario(repoUsuarios repositorio, PasswordEncoder encriptado){
        this.repositorio = repositorio;
        this.encriptado = encriptado;
    }

    public dtoRespuestaUsuario guardar(dtoRegistroUsuario dtoR){
        usuarios nuevoUsuario = new usuarios();
        nuevoUsuario.setNombre_user(dtoR.getNombre_user());
        
        String hashContraseña = encriptado.encode(dtoR.getPassword_hash());
        nuevoUsuario.setPassword_hash(hashContraseña);
        
        usuarios usuarioGuardado = repositorio.save(nuevoUsuario);
        return new dtoRespuestaUsuario(usuarioGuardado.getId(), usuarioGuardado.getNombre_user());
    }

    public dtoRespuestaUsuario actualizar(dtoRegistroUsuario dtoR, Long id){
        usuarios user = repositorio.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el usuario"));
        user.setNombre_user(dtoR.getNombre_user());
        if (dtoR.getPassword_hash() != null && !dtoR.getPassword_hash().isEmpty()) {
        String passwordCifrada = encriptado.encode(dtoR.getPassword_hash());
        user.setPassword_hash(passwordCifrada);
        }
        usuarios usuarioActualizado = repositorio.save(user);
        return new dtoRespuestaUsuario(usuarioActualizado.getId(), usuarioActualizado.getNombre_user());
    }

    public List<dtoRespuestaUsuario> listar(){
        List<usuarios> users = repositorio.findAll();
        return users.stream().map(u -> new dtoRespuestaUsuario(u.getId(),u.getNombre_user())).toList();
    }

    public dtoRespuestaUsuario buscarporID(Long id){
        usuarios user = new usuarios();
        user=repositorio.findById(id).orElseThrow(()->new RuntimeException("No se encontro el usuario"));
        dtoRespuestaUsuario dto = new dtoRespuestaUsuario();
        dto.setId(user.getId());
        dto.setNombreUsuario(user.getNombre_user());
        return dto;
    }

    public void eliminar(Long id){
        repositorio.deleteById(id);
    }
}
