import { Dias } from './Dias.model';

export interface Actividad {
  id_actividades?: number;
  tipo: 'MEDIDAS' | 'TRABAJO';
  estado: 'PENDIENTE' | 'EN_CURSO' | 'TERMINADA' | 'CANCELADA';
  notas: string;
  tecnico: {
    id_tecnicos: number;
  };
  cliente: {
    id_clientes: number;
  };
  dias: Dias[];
}
