import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './features/dashboard/dashboard.component';
import { MenuComponent } from './features/menu/menu.component';
import { MesasComponent } from './features/mesas/mesas.component';
import { OrdenesComponent } from './features/ordenes/ordenes.component';
import { UsuariosComponent } from './features/usuarios/usuarios.component';

const routes: Routes = [
  { path: '', component: DashboardComponent },
  { path: 'menu', component: MenuComponent },
  { path: 'mesas', component: MesasComponent },
  { path: 'ordenes', component: OrdenesComponent },
  { path: 'usuarios', component: UsuariosComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
