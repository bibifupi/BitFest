import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-perfil',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './perfil.component.html',
  styleUrl: './perfil.component.css'
})
export class PerfilComponent implements OnInit {
  usuario$!: Observable<any>;

  constructor() {}

  ngOnInit() {
    // Aquí deberías obtener los datos del usuario desde tu servicio o API
    // Por ejemplo:
    // this.usuario$ = this.usuarioService.getUsuario();
  }

  modificarDatos() {
    // Aquí deberías manejar la lógica para modificar los datos del usuario
    // Por ejemplo, podrías redirigir al usuario a una página de edición de perfil
  }

  eliminarPerfil() {
    // Aquí deberías manejar la lógica para eliminar el perfil del usuario
  }
}