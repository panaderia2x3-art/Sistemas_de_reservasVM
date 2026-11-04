import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Clientes } from '../Model/Clientes.model';

@Injectable({
  providedIn: 'root',
})
export class ClienteService {
  private apiUrl = 'http://localhost:8080/api/clientes';

  constructor(private http: HttpClient) {}

  listar(): Observable<Clientes[]> {
    return this.http.get<Clientes[]>(this.apiUrl);
  }

  guardar(Clientes: Clientes): Observable<Clientes> {
    return this.http.post<Clientes>(this.apiUrl, Clientes);
  }
}
