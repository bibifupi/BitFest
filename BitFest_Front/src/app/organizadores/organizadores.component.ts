import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { OrganizadoresService } from '../_servicios/organizadores.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-organizadores',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './organizadores.component.html',
  styleUrl: './organizadores.component.css'
})
export class OrganizadoresComponent implements OnInit {
  organizadores$!: Observable<any[]>;
  filtro = '';

  constructor(private organizadoresService: OrganizadoresService) {}

  ngOnInit() {
    this.organizadores$ = this.organizadoresService.getOrganizadores();
  }

  filtrarOrganizadores() {
    // Aquí puedes manejar la lógica para filtrar los organizadores
    // Por ejemplo, podrías filtrar los organizadores en el servicio y luego actualizar el Observable
  }
}
