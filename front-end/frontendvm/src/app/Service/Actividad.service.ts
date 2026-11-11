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
}
