export type Rol = 'ADMINISTRADOR' | 'MESERO' | 'DESPACHADOR';
export type MenuCategoria = 'ENTRADA' | 'FUERTE' | 'POSTRE' | 'BEBIDA';
export type EstadoOrden = 'TOMADA' | 'RECIBIDA_DESPACHADOR' | 'DESPACHADA';

export interface Usuario {
  id?: string;
  nombre: string;
  email: string;
  rol: Rol;
}

export interface MenuItem {
  id?: string;
  nombre: string;
  descripcion?: string;
  precio: number;
  categoria: MenuCategoria;
  disponible: boolean;
}

export interface Mesa {
  id?: string;
  nombre: string;
  disponible: boolean;
  ocupantesPosibles: number;
  ocupantesActuales: number;
}

export interface OrdenItem {
  menuItemId: string;
  nombre: string;
  cantidad: number;
  precio: number;
}

export interface Orden {
  id?: string;
  mesaId: string;
  meseroId: string;
  items: OrdenItem[];
  total: number;
  estado: EstadoOrden;
  creadaEn?: string;
  actualizadaEn?: string;
}
