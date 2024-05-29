import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { OrganizadoresService } from '../_servicios/organizadores.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-organizadoresinformacion',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './organizadoresinformacion.component.html',
  styleUrl: './organizadoresinformacion.component.css'
})
export class OrganizadoresinformacionComponent implements OnInit {
  organizador$!: Observable<any>;

  constructor(private organizadoresService: OrganizadoresService) {}

  ngOnInit() {
    this.organizador$ = this.organizadoresService.getOrganizadores();
  }

  visualizarEventos() {
    // Aquí puedes manejar la lógica para visualizar los eventos del organizador
  }
}