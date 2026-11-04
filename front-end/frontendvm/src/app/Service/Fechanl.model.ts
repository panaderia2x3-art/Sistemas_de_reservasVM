import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Fechanl } from "../Model/fechanl.model";

@Injectable({
    providedIn: 'root'
})

export class FechanlService{
    private apiURL='http://localhost:8080/api/fecha_no_laborales';

    constructor (private http: HttpClient){}

    listar():Observable<Fechanl[]>{
        return this.http.get<Fechanl[]>(this.apiURL);
    }

    guardar(Fechanls: Fechanl):Observable<Fechanl>{
        return this.http.post<Fechanl>(this.apiURL, Fechanls);
    }
}