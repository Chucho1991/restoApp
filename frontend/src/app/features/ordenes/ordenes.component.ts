import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../core/services/api.service';
import { EstadoOrden, MenuItem, Orden, OrdenItem } from '../../shared/models';

@Component({
  selector: 'app-ordenes',
  templateUrl: './ordenes.component.html'
})
export class OrdenesComponent implements OnInit {
  ordenes: Orden[] = [];
  menu: MenuItem[] = [];
  nueva: Orden = {
    mesaId: '',
    meseroId: '',
    items: [],
    total: 0,
    estado: 'TOMADA'
  };

  constructor(private api: ApiService) {}

  ngOnInit(): void {
    this.load();
  }

  load(): void {
    this.api.getOrdenes().subscribe(data => this.ordenes = data);
    this.api.getMenu().subscribe(menu => this.menu = menu);
  }

  agregarItem(item: MenuItem): void {
    const nuevoItem: OrdenItem = {
      menuItemId: item.id || '',
      nombre: item.nombre,
      cantidad: 1,
      precio: item.precio
    };
    this.nueva.items.push(nuevoItem);
    this.calcularTotal();
  }

  calcularTotal(): void {
    this.nueva.total = this.nueva.items.reduce((acc, item) => acc + (item.precio * item.cantidad), 0);
  }

  crear(): void {
    this.api.createOrden(this.nueva).subscribe(orden => {
      this.ordenes.push(orden);
      this.nueva = { mesaId: '', meseroId: '', items: [], total: 0, estado: 'TOMADA' };
    });
  }

  cambiarEstado(orden: Orden, estado: EstadoOrden): void {
    if (!orden.id) return;
    this.api.actualizarEstadoOrden(orden.id, estado).subscribe(actualizada => {
      const idx = this.ordenes.findIndex(o => o.id === actualizada.id);
      if (idx >= 0) {
        this.ordenes[idx] = actualizada;
      }
    });
  }
}
