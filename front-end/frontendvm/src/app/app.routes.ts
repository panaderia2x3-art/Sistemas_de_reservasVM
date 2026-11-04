import { Routes } from '@angular/router';
import { CompTecnicos } from './Components/comp-tecnicos/comp-tecnicos';
import { CompClientes } from './Components/comp-clientes/comp-clientes';

export const routes: Routes = [
  { path: 'tecnicos', component: CompTecnicos },
  { path: 'clientes', component: CompClientes },
];
