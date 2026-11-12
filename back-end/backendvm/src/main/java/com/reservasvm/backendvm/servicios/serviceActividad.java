package com.reservasvm.backendvm.servicios;

import com.reservasvm.backendvm.repositorio.repoActividad;
import com.reservasvm.backendvm.repositorio.repofechanl;

import org.springframework.transaction.annotation.Transactional;

import com.reservasvm.backendvm.entidades.actividades;
import com.reservasvm.backendvm.entidades.dia;

import java.util.List;

import org.springframework.stereotype.Service;


@Service 
public class serviceActividad {
    
    private repoActividad repositorio;
    private repofechanl repofechanl;

    public serviceActividad(repoActividad repositorio, repofechanl repofechanl){
        this.repositorio= repositorio;
        this.repofechanl= repofechanl;
    }

    @Transactional (readOnly = true)
    public List<actividades> listar(){
        return repositorio.findAll();
    }

    @Transactional 
    public actividades guardar(actividades actividad){

        if(actividad.getTecnico() != null && actividad.getDias() != null){
            Long idTecnico = actividad.getTecnico().getId_tecnicos();

            

            if(repositorio.tecnicoActivo(idTecnico)){
                    for (dia d : actividad.getDias()) {
                        boolean tieneCruce = repositorio.existeCruceHorario
                            (idTecnico, 
                            d.getFecha(), 
                            d.getHora_inicio(), 
                            d.getHora_final()
                            );

                        boolean feriado = repofechanl.Verificarfechanolaborable(d.getFecha());

                        if(feriado){
                            throw new RuntimeException("El Dia que elijio es no laborable");
                        }

                        if(tieneCruce){
                        throw new RuntimeException("El tecnico ya tiene una actividad");
                        }   
                }

            }else{
                throw new RuntimeException("El tecnico esta inactivo");
            }

            
        }

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
