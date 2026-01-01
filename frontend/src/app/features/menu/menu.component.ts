import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../core/services/api.service';
import { MenuItem, MenuCategoria } from '../../shared/models';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html'
})
export class MenuComponent implements OnInit {
  menu: MenuItem[] = [];
  nuevo: MenuItem = {
    nombre: '',
    descripcion: '',
    precio: 0,
    categoria: 'ENTRADA',
    disponible: true
  };

  constructor(private api: ApiService) {}

  ngOnInit(): void {
    this.load();
  }

  load(): void {
    this.api.getMenu().subscribe(data => this.menu = data);
  }

  crear(): void {
    this.api.createMenuItem(this.nuevo).subscribe(item => {
      this.menu.push(item);
      this.nuevo = { nombre: '', descripcion: '', precio: 0, categoria: 'ENTRADA', disponible: true };
    });
  }

  categorias(): MenuCategoria[] {
    return ['ENTRADA', 'FUERTE', 'POSTRE', 'BEBIDA'];
  }
}
