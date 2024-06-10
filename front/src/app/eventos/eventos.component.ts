import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Eventos } from '../interfaces/Eventos';
import { EventosService } from '../_servicios/eventos.service';
import { Comentarios } from '../interfaces/Comentarios';
import { ComentariosService } from '../_servicios/comentarios.service';

@Component({
  selector: 'app-eventos',
  standalone: true,
  imports: [FormsModule, CommonModule,],
  templateUrl: './eventos.component.html',
  styleUrl: './eventos.component.css'
})
export class EventosComponent  {  
  evento: Eventos | undefined;
  comentarios: Comentarios[] = [];
  nuevoComentario: string = '';

  constructor(
    private eventosService: EventosService,
    private comentariosService: ComentariosService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.cargarEvento(params['id']);
      this.cargarComentarios(params['id']);
    });
  }

  cargarEvento(id: number) {
    this.eventosService.obtenerEventoPorId(id).subscribe(evento => {
      this.evento = evento;
    });
  }

  cargarComentarios(idEvento: number) {
    this.comentariosService.listarComentariosPorEvento(idEvento).subscribe(comentarios => {
      this.comentarios = comentarios;
    });
  }

  enviarComentario() {
    if (this.nuevoComentario.trim() && this.evento?.idEvento) {
        const comentario: Comentarios = {
            texto: this.nuevoComentario,
            fecha: new Date(),
            idEvento: { idEvento: this.evento.idEvento },
            idUsuario: { idUsuario: 1 } 
        };
        this.comentariosService.addComentario(comentario).subscribe({
            next: (response) => {
                this.comentarios.push(response as Comentarios);
                this.nuevoComentario = '';
                console.log('Comentario agregado con éxito', response);
            },
            error: (error) => {
                console.error('Error al enviar comentario:', error);
            }
        });
    }
}

}


  