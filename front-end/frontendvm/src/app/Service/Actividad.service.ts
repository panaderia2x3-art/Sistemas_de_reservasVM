import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Actividad } from '../Model/Actividades.model';

@Injectable({
  providedIn: 'root',
})
export class ActividadesServicio {
  private apiurl = 'http://localhost:8080/api/actividades';

  constructor(private http: HttpClient) {}

  listar(): Observable<Actividad[]> {
    return this.http.get<Actividad[]>(this.apiurl);
  }

  guardar(Actividades: Actividad): Observable<Actividad> {
    return this.http.post<Actividad>(this.apiurl, Actividades);
  }

  actualizar(Actividad: Actividad, id:number): Observable<Actividad>{
    return this.http.put<Actividad>(`${this.apiurl}/${id}`,Actividad);
  }

  eliminar(id:number): Observable<void>{
    return this.http.delete<void>(`${this.apiurl}/${id}`);
  }
}
