import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuarios } from '../interfaces/Usuarios';
import { AuthService } from '../_servicios/auth-service.service';
import { Router } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-perfil',
  standalone: true,
  imports: [CommonModule,FormsModule,ReactiveFormsModule],
  templateUrl: './perfil.component.html',
  styleUrl: './perfil.component.css'
})
export class PerfilComponent implements OnInit {
  usuario:Usuarios | null = null;

  constructor(private authservice:AuthService , private router:Router) {}

  ngOnInit():void {
   this.loadUsuario();
  }

  loadUsuario():void{
      this.authservice.getUsuarioAutenticado().subscribe(
       (data:Usuarios) => {
          this.usuario = data;
        },
        error => {
          console.error('Error al cargar el usuario', error);
        }
      );
    }
  

  modificarDatos() {
    if(this.usuario){
      this.authservice.actualizarUsuario(this.usuario.idUsuario, this.usuario).subscribe(
        () => {
          alert('Datos actualizados correctamente');
        },
        error => {
          console.log('Error al actualizar los datos', error);
        }
      );
    }
  }

  eliminarPerfil(): void {
    if(this.usuario){
      const confirmacion=confirm('¿Estás seguro de que deseas eliminar tu perfil?');
      if(confirmacion){
        this.authservice.eliminarUsuario().subscribe(
          () => {
            localStorage.removeItem('authToken');
            this.router.navigate(['/login']);
          },
          error => {
            console.error('Error al eliminar el perfil', error);
          }
        );
      }
    }
  }

  cerrarSesion(): void {
    this.authservice.logout();
    this.router.navigate(['/login']);
  }

}
