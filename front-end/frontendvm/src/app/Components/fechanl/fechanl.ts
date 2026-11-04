import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { FechanlService } from '../../Service/Fechanl.model';
import { Fechanl } from '../../Model/fechanl.model';


@Component({
  imports: [CommonModule, FormsModule],
  selector: 'app-fechanl',
  styleUrl: './fechanl.scss',
  templateUrl: './fechanl.html',
})

export class CompFechanl implements OnInit{
  fechanl:Fechanl[]=[];

  nuevofechanl:Fechanl={
    fecha_nl:'',
    motivo:''
  };
  
  constructor(private Servicio:FechanlService){}

  ngOnInit(): void {
    this.cargarFechanl();
  }


  cargarFechanl(){
    this.Servicio.listar().subscribe({
      next:(data)=>{
        this.fechanl=data;
      },
      error:(err)=>{
        console.error("ERROR en guardar sus datos: ", err)
      }
    })
  }

  RegistrarFechanl(){
    this.Servicio.guardar(this.nuevofechanl).subscribe({
      next:()=>{
        this.cargarFechanl();
        this.nuevofechanl={
          fecha_nl:'',
          motivo:''
        };
      },
      error:(err)=>{
        console.error("ERROR en registrar datos uwu: ",err);
      }
    })
  }
}
