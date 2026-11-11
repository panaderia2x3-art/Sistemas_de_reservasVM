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
}
