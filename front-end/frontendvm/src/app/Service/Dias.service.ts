import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Dias } from '../Model/Dias.model';

Injectable({
  providedIn: 'root',
});

export class DiasService {
  private apiurl = 'http://localhost:8080/api/dia';
  constructor(private http: HttpClient) {}

  lista(): Observable<Dias[]> {
    return this.http.get<Dias[]>(this.apiurl);
  }

  guardar(Dias: Dias): Observable<Dias> {
    return this.http.post<Dias>(this.apiurl, Dias);
  }
}
