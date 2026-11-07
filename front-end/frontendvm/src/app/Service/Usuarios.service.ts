import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RegistroUsuarios } from '../Model/Usuarios/RegistroUsuarios.model';
import { RespuestaUsuarios } from '../Model/Usuarios/RespuestaUsuarios.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {
  private URL = 'http://localhost:8080/api/usuarios';

  constructor(private http: HttpClient) {}
  listar(): Observable<RespuestaUsuarios[]> {
    return this.http.get<RespuestaUsuarios[]>(this.URL);
  }

  guardar(usuarios: RegistroUsuarios): Observable<RespuestaUsuarios> {
    return this.http.post<RegistroUsuarios>(this.URL, usuarios);
  }
}
