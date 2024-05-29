import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component'; // Import your Login component
import { RegisterFormComponent } from './registro/registro.component'; // Import your Register component
import { InicioComponent } from './inicio/inicio.component';
import { EventosComponent } from './eventos/eventos.component';
import { OrganizadoresComponent } from './organizadores/organizadores.component';
import { PerfilComponent } from './perfil/perfil.component';
import { CreareventosComponent } from './creareventos/creareventos.component';
import { OrganizadoresinformacionComponent } from './organizadoresinformacion/organizadoresinformacion.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'registro', component: RegisterFormComponent },
  { path: 'inicio', component: InicioComponent },
  { path: '', component: InicioComponent },
  { path: 'eventos', component: EventosComponent },
  { path: 'organizadores', component: OrganizadoresComponent },
  { path: 'perfil', component: PerfilComponent },
  { path: 'organizadoresinformacion', component: OrganizadoresinformacionComponent },
  { path: 'creareventos', component: CreareventosComponent }
];
