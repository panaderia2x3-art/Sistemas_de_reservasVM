import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { TecnicoService } from '../../Service/Tecnicos.service';
import { Tecnicos } from '../../Model/Tecnicos.model';

@Component({
  imports: [CommonModule, FormsModule],
  standalone: true,
  selector: 'app-comp-tecnicos',
  styleUrl: './comp-tecnicos.scss',
  templateUrl: './comp-tecnicos.html',
})
export class CompTecnicos implements OnInit {
  tecnicos: Tecnicos[] = [];

  nuevoTecnico: Tecnicos = {
    nombre_tecnico: '',
    apellido_tecnico: '',
    telefono_tecnico: '',
    activo: true,
  };

  constructor(private TecnicosService: TecnicoService) {}
  ngOnInit(): void {
    this.cargarTecnicos();
  }

  cargarTecnicos() {
    this.TecnicosService.listar().subscribe({
      next: (data) => {
        this.tecnicos = data;
      },
      error: (err) => {
        console.error('Error en la carga tecnicos: ', err);
      },
    });
  }

  registrar() {
    this.TecnicosService.guardar(this.nuevoTecnico).subscribe({
      next: () => {
        this.cargarTecnicos();
        this.nuevoTecnico = {
          nombre_tecnico: '',
          apellido_tecnico: '',
          telefono_tecnico: '',
          activo: true,
        };
      },
      error: (err) => {
        console.error('Error en guardar tecnicos: ', err);
      },
    });
  }
}
