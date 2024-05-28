import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-eventos',
  standalone: true,
  imports: [FormsModule, CommonModule,],
  templateUrl: './eventos.component.html',
  styleUrl: './eventos.component.css'
})
export class EventosComponent  {
  evento$!: Observable<any>;
  comentarios$!: Observable<any[]>;
  nuevoComentario = '';

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    //const id = +this.route.snapshot.paramMap.get('id');
    // Aquí deberías obtener los datos del evento y los comentarios desde tu servicio o API
    // Por ejemplo:
    // this.evento$ = this.eventosService.getEvento(id);
    // this.comentarios$ = this.comentariosService.getComentarios(id);
  }

  agregarComentario() {
    // Aquí deberías agregar el comentario a través de tu servicio o API
    // Por ejemplo:
    // this.comentariosService.agregarComentario(this.evento.id, this.nuevoComentario);
    this.nuevoComentario = '';
  }
}