import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, debounceTime, distinctUntilChanged } from 'rxjs';
import { Eventos } from '../interfaces/Eventos';
import { EventosService } from '../_servicios/eventos.service';
import { FormControl, FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-inicio',
  standalone: true,
  imports: [FormsModule,CommonModule,ReactiveFormsModule],
  templateUrl: './inicio.component.html',
  styleUrl: './inicio.component.css'
})
export class InicioComponent implements OnInit {
  eventos: Eventos[] = [];
  searchControl = new FormControl();  

  constructor(private eventosService: EventosService, private router: Router) {}

  ngOnInit() {
    this.eventosService.listarPrimeros7Eventos().subscribe((data: Eventos[]) => {
      this.eventos = data;
    });

    this.searchControl.valueChanges.pipe(
      debounceTime(250),
      distinctUntilChanged()
    ).subscribe((query: string) => {
      if (query) {
        this.buscarEventos(query);
      } else {
        this.eventosService.listarPrimeros7Eventos().subscribe((data: Eventos[]) => {
          this.eventos = data;
        });
      }
    });
  }

  verEvento(id: number) {
    this.router.navigate(['/eventos', id]);
  }

  mostrarTodosEventos() {
    this.eventosService.listarEventosPorFechaRealizacion().subscribe((data: Eventos[]) => {
      this.eventos = data;
    });
  }

  buscarEventos(query: string) {
    this.eventosService.buscarEventos(query).subscribe((data: Eventos[]) => {
      this.eventos = data;
    });
  }
}