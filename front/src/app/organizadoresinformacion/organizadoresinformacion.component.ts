import { Component, OnInit, Optional } from '@angular/core';
import { OrganizadoresService } from '../_servicios/organizadores.service';
import { CommonModule } from '@angular/common';
import { Organizadores } from '../interfaces/Organizadores';
import { ActivatedRoute } from '@angular/router';
 
@Component({
  selector: 'app-organizadoresinformacion',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './organizadoresinformacion.component.html',
  styleUrl: './organizadoresinformacion.component.css'
})
export class OrganizadoresinformacionComponent implements OnInit {
  organizador?: Organizadores;
  errorMessage?: string;
 
  constructor(private activatedRoute: ActivatedRoute, private organizadoresService: OrganizadoresService) { }
 
  ngOnInit(): void {
    this.cargarOrganizador();
  }
 
  cargarOrganizador(){
    const id = this.activatedRoute.snapshot.params['id'];
    this.organizadoresService.listarOrganizadorPorId(id)
    .subscribe( {
      next:(organizador)=>this.organizador = organizador
 
    });
  }
}
 