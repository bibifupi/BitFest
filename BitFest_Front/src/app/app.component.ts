import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterFormComponent } from './registro/registro.component';
import { InicioComponent } from './inicio/inicio.component';
import { EventosComponent } from './eventos/eventos.component';
import { PerfilComponent } from './perfil/perfil.component';
import { OrganizadoresComponent } from './organizadores/organizadores.component';
import { OrganizadoresinformacionComponent } from './organizadoresinformacion/organizadoresinformacion.component';
import { CreareventosComponent } from './creareventos/creareventos.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, LoginComponent, RegisterFormComponent,InicioComponent, EventosComponent, PerfilComponent, OrganizadoresComponent, OrganizadoresinformacionComponent, CreareventosComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'BitFest_Front';
}
