import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../core/services/api.service';
import { Rol, Usuario } from '../../shared/models';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html'
})
export class UsuariosComponent implements OnInit {
  usuarios: Usuario[] = [];
  nuevo: Usuario = { nombre: '', email: '', rol: 'MESERO' };

  constructor(private api: ApiService) {}

  ngOnInit(): void {
    this.load();
  }

  load(): void {
    this.api.getUsuarios().subscribe(data => this.usuarios = data);
  }

  crear(): void {
    this.api.createUsuario(this.nuevo).subscribe(usuario => {
      this.usuarios.push(usuario);
      this.nuevo = { nombre: '', email: '', rol: 'MESERO' };
    });
  }

  roles(): Rol[] {
    return ['ADMINISTRADOR', 'MESERO', 'DESPACHADOR'];
  }
}
