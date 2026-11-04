import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ClienteService } from '../../Service/Clientes.service';
import { Service } from '@angular/core';
import { Clientes } from '../../Model/Clientes.model';

@Component({
  imports: [CommonModule, FormsModule],
  selector: 'app-comp-clientes',
  styleUrl: './comp-clientes.scss',
  templateUrl: './comp-clientes.html',
  standalone: true,
})
export class CompClientes implements OnInit {
  clientes: Clientes[] = [];

  nuevoCliente: Clientes = {
    nombre_cliente: '',
    telefono_cliente: '',
    direccion: '',
    enlace_mapa: '',
  };

  constructor(private ClienteService: ClienteService) {}

  ngOnInit(): void {
    this.cargarClientes();
  }

  cargarClientes() {
    this.ClienteService.listar().subscribe({
      next: (data) => {
        this.clientes = data;
      },
      error: (err) => {
        console.error('Error en la carga clientes: ', err);
      },
    });
  }

  registrar() {
    this.ClienteService.guardar(this.nuevoCliente).subscribe({
      next: () => {
        this.cargarClientes();
        this.nuevoCliente = {
          nombre_cliente: '',
          telefono_cliente: '',
          direccion: '',
          enlace_mapa: '',
        };
      },
      error: (err) => {
        console.error('Error al registrar cliente: ', err);
      },
    });
  }
}
