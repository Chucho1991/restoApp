import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './core/components/navbar/navbar.component';
import { DashboardComponent } from './features/dashboard/dashboard.component';
import { MenuComponent } from './features/menu/menu.component';
import { MesasComponent } from './features/mesas/mesas.component';
import { OrdenesComponent } from './features/ordenes/ordenes.component';
import { UsuariosComponent } from './features/usuarios/usuarios.component';
import { StatusBadgePipe } from './shared/status-badge.pipe';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    DashboardComponent,
    MenuComponent,
    MesasComponent,
    OrdenesComponent,
    UsuariosComponent,
    StatusBadgePipe
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
