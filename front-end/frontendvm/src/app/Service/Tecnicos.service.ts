import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tecnicos } from '../Model/Tecnicos.model';

@Injectable({
  providedIn: 'root',
})
export class TecnicoService {
  private apiUrl = 'http://localhost:8080/api/tecnicos';

  constructor(private http: HttpClient) {}

  listar(): Observable<Tecnicos[]> {
    return this.http.get<Tecnicos[]>(this.apiUrl);
  }

  guardar(tecnicos: Tecnicos): Observable<Tecnicos> {
    return this.http.post<Tecnicos>(this.apiUrl, tecnicos);
  }
}
