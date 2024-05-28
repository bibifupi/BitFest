import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-inicio',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './inicio.component.html',
  styleUrl: './inicio.component.css'
})
export class InicioComponent implements OnInit {
  eventos$!: Observable<any[]>;

  constructor(private router: Router) {}

  ngOnInit() {
    // Aquí deberías obtener los datos de los eventos desde tu servicio o API
    // Por ejemplo:
    // this.eventos$ = this.eventosService.getEventos();
  }

  verEvento(id: number) {
    this.router.navigate(['/eventos', id]);
  }
}