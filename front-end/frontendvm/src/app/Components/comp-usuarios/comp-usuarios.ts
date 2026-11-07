import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UsuarioService } from '../../Service/Usuarios.service';
import { RegistroUsuarios } from '../../Model/Usuarios/RegistroUsuarios.model';
import { RespuestaUsuarios } from '../../Model/Usuarios/RespuestaUsuarios.model';

@Component({
  imports: [CommonModule, FormsModule],
  selector: 'app-comp-usuarios',
  styleUrl: './comp-usuarios.scss',
  templateUrl: './comp-usuarios.html',
  standalone: true,
})
export class CompUsuarios implements OnInit {
  usuarios: RespuestaUsuarios[] = [];

  nuevoUsuario: RegistroUsuarios = {
    nombre_user: '',
    password_hash: '',
  };

  constructor(private Servicio: UsuarioService) {}

  ngOnInit(): void {
    this.cargarUsuarios();
  }

  cargarUsuarios() {
    this.Servicio.listar().subscribe({
      next: (data) => {
        this.usuarios = data;
      },
      error: (err) => {
        console.error('No se encontro a los Usuarios ', err);
      },
    });
  }

  RegistrarUsuarios() {
    this.Servicio.guardar(this.nuevoUsuario).subscribe({
      next: () => {
        this.cargarUsuarios();
        this.nuevoUsuario = {
          nombre_user: '',
          password_hash: '',
        };
      },
      error: (err) => {
        console.error('No se pudo registrar el Usuario ', err);
      },
    });
  }
}
