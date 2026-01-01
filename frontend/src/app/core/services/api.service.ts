import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { MenuItem, Mesa, Orden, Usuario, EstadoOrden, MenuCategoria } from '../../shared/models';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class ApiService {
  private readonly baseUrl = environment.apiUrl;

  constructor(private http: HttpClient) {}

  // Usuarios
  getUsuarios(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(`${this.baseUrl}/usuarios`);
  }

  createUsuario(usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(`${this.baseUrl}/usuarios`, usuario);
  }

  // Menú
  getMenu(categoria?: MenuCategoria): Observable<MenuItem[]> {
    const params = categoria ? { categoria } : {};
    return this.http.get<MenuItem[]>(`${this.baseUrl}/menu`, { params });
  }

  createMenuItem(item: MenuItem): Observable<MenuItem> {
    return this.http.post<MenuItem>(`${this.baseUrl}/menu`, item);
  }

  // Mesas
  getMesas(disponible?: boolean): Observable<Mesa[]> {
    const params = disponible !== undefined ? { disponible } : {};
    return this.http.get<Mesa[]>(`${this.baseUrl}/mesas`, { params });
  }

  createMesa(mesa: Mesa): Observable<Mesa> {
    return this.http.post<Mesa>(`${this.baseUrl}/mesas`, mesa);
  }

  // Órdenes
  getOrdenes(estado?: EstadoOrden): Observable<Orden[]> {
    const params = estado ? { estado } : {};
    return this.http.get<Orden[]>(`${this.baseUrl}/ordenes`, { params });
  }

  createOrden(orden: Orden): Observable<Orden> {
    return this.http.post<Orden>(`${this.baseUrl}/ordenes`, orden);
  }

  actualizarEstadoOrden(id: string, estado: EstadoOrden): Observable<Orden> {
    return this.http.put<Orden>(`${this.baseUrl}/ordenes/${id}/estado`, null, { params: { estado } });
  }
}
