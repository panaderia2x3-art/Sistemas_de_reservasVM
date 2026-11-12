package com.reservasvm.backendvm.repositorio;

import com.reservasvm.backendvm.entidades.actividades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.time.LocalTime;

public interface repoActividad extends JpaRepository<actividades, Long> {

    @Query("SELECT COUNT(d) > 0 FROM actividades a JOIN a.dias d WHERE a.tecnico.id_tecnicos = :idTecnico AND d.fecha = :fecha AND (:horaInicio < d.horaFinal AND :horaFin > d.horaInicio)")
    boolean existeCruceHorario(
        @Param("idTecnico") Long idTecnico,
        @Param("fecha") LocalDate fecha,
        @Param("horaInicio") LocalTime horaInicio,
        @Param("horaFin") LocalTime horaFin
    );
}