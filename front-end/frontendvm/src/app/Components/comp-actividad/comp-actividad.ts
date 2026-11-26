import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Actividad } from '../../Model/Actividades.model';
import { ActividadesServicio } from '../../Service/Actividad.service';

@Component({
  imports: [CommonModule, FormsModule],
  selector: 'app-comp-actividad',
  styleUrl: './comp-actividad.scss',
  templateUrl: './comp-actividad.html',
  standalone: true,
})
export class CompActividad implements OnInit {
  Actvidad: Actividad[] = [];

  nuevaActividad: Actividad = {
    tipo: 'TRABAJO',
    estado: 'PENDIENTE',
    notas: '',
    tecnico: {
      id_tecnicos: 0,
    },
    cliente: {
      id_clientes: 0,
    },
    dias: [
      {
        fecha: '',
        hora_inicio: '', // Coincidente con la interfaz
        hora_final: '', // Coincidente con la interfaz
      },
    ],
  };

  constructor(private actividadService: ActividadesServicio) {}

  ngOnInit(): void {
    this.cargarActividades();
  }

  cargarActividades() {
    this.actividadService.listar().subscribe({
      next: (data) => {
        this.Actvidad = data;
      },
      error: (err) => {
        console.error('Error al listar actividades', err);
      },
    });
  }

  registrarActividades() {
    this.actividadService.guardar(this.nuevaActividad).subscribe({
      next: (res) => {
        console.log('Actividad registrada con éxito:', res);
        this.cargarActividades();
      },
      error: (err) => {
        console.error('No se pudo registrar la actividad:', err);
      },
    });
  }

  actualizarActividad() {
    
    const idActividad = this.nuevaActividad.id_actividades; 

    if (idActividad) {
      this.actividadService.actualizar(this.nuevaActividad, idActividad).subscribe({
        next: (res) => {
          console.log('Actualizado con éxito:', res);
          this.cargarActividades(); // Recargas la lista
        },
        error: (err) => {
          console.error('Error al actualizar:', err);
        }
      });
    }
  }

  elimarActividades(){
    const IDeliminar = this.nuevaActividad.id_actividades;

    if(IDeliminar !== undefined && IDeliminar !== null){
      this.actividadService.eliminar(IDeliminar).subscribe({
        next:(dato) =>{
          console.log("Eliminado con exito ", dato);
          this.cargarActividades();
        },
        error:(err) =>{
          console.error("No se pudo elimnar la actividad");
        }
      })
    }else{
      console.error("datos indefinido");
    }

    
  }

  arreglodia() {
    this.nuevaActividad.dias.push({
      fecha: '',
      hora_inicio: '',
      hora_final: '',
    });
  }

  eliminarDia(index: number) {
    if (this.nuevaActividad.dias.length > 1) {
      this.nuevaActividad.dias.splice(index, 1);
    }
  }
}
