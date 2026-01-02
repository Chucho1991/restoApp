import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../core/services/api.service';
import { MenuItem, Mesa, Orden, Usuario } from '../../shared/models';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html'
})
export class DashboardComponent implements OnInit {
  usuarios: Usuario[] = [];
  menu: MenuItem[] = [];
  mesas: Mesa[] = [];
  ordenes: Orden[] = [];

  constructor(private api: ApiService) {}

  ngOnInit(): void {
    this.loadData();
  }

  private loadData(): void {
    this.api.getUsuarios().subscribe(data => this.usuarios = data);
    this.api.getMenu().subscribe(data => this.menu = data);
    this.api.getMesas().subscribe(data => this.mesas = data);
    this.api.getOrdenes().subscribe(data => this.ordenes = data);
  }

  ordenesPorEstado(estado: string): Orden[] {
    return this.ordenes.filter(o => o.estado === estado);
  }
}
