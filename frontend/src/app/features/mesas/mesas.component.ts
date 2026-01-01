import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../core/services/api.service';
import { Mesa } from '../../shared/models';

@Component({
  selector: 'app-mesas',
  templateUrl: './mesas.component.html'
})
export class MesasComponent implements OnInit {
  mesas: Mesa[] = [];
  nueva: Mesa = {
    nombre: '',
    disponible: true,
    ocupantesPosibles: 2,
    ocupantesActuales: 0
  };

  constructor(private api: ApiService) {}

  ngOnInit(): void {
    this.load();
  }

  load(): void {
    this.api.getMesas().subscribe(data => this.mesas = data);
  }

  crear(): void {
    this.api.createMesa(this.nueva).subscribe(mesa => {
      this.mesas.push(mesa);
      this.nueva = { nombre: '', disponible: true, ocupantesPosibles: 2, ocupantesActuales: 0 };
    });
  }
}
