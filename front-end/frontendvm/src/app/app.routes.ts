import { Routes } from '@angular/router';
import { CompTecnicos } from './Components/comp-tecnicos/comp-tecnicos';
import { CompClientes } from './Components/comp-clientes/comp-clientes';
import { CompFechanl } from './Components/fechanl/fechanl';
import { CompUsuarios } from './Components/comp-usuarios/comp-usuarios';
import { CompActividad } from './Components/comp-actividad/comp-actividad';

export const routes: Routes = [
  { path: 'tecnicos', component: CompTecnicos },
  { path: 'clientes', component: CompClientes },
  { path: 'fecha_no_laborales', component: CompFechanl },
  { path: 'usuarios', component: CompUsuarios },
  { path: 'actividades', component: CompActividad },
];
