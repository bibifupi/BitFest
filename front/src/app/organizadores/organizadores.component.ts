import { Component, OnInit } from '@angular/core';
import { OrganizadoresService } from '../_servicios/organizadores.service';
import { CommonModule } from '@angular/common';
import { FormControl, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Organizadores } from '../interfaces/Organizadores';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';
 
@Component({
  selector: 'app-organizadores',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './organizadores.component.html',
  styleUrl: './organizadores.component.css'
})
export class OrganizadoresComponent implements OnInit {
  organizadoresTop7: Organizadores[] = [];
  organizadoresBusqueda: Organizadores[] = [];
  nombreBusqueda: string = '';
  todosOrganizadores: Organizadores[] = [];
  flag: boolean = true;
  searchControl = new FormControl();
 
  constructor(private servicio: OrganizadoresService) { }
 
  ngOnInit(): void {
    this.cargarOrganizadoresTop7();

    this.searchControl.valueChanges.pipe(
      debounceTime(250),
      distinctUntilChanged()
    ).subscribe((query: string) => {
      if (query) {
        this.buscarOrganizadoresPorNombre(query);
      } else {
        this.cargarOrganizadoresTop7();
      }
    });
  }
 
  cargarOrganizadoresTop7() {
    this.servicio.listarOrganizadores7primeros()
      .subscribe(organizadores => {
        this.organizadoresTop7 = organizadores;
      });
  }
 
  buscarOrganizadoresPorNombre(query: string) {
    const nombreBusquedaMinusculas = query.toLowerCase();
 
      this.servicio.findOrganizadoresByNombre(nombreBusquedaMinusculas)
        .subscribe(organizadores => {
          this.organizadoresTop7 = organizadores.filter(organizador => {
            return organizador.nombre.toLowerCase().includes(nombreBusquedaMinusculas);
          });
        });
        this.flag = false;
    }

  listartodos() {
    console.log('INICIO');
 
    this.servicio.getOrganizadores()
      .subscribe(organizadores => {
        console.log('old organizadoresTop7', this.organizadoresTop7);
        this.organizadoresTop7 = organizadores.sort((a, b) => a.nombre.localeCompare(b.nombre));
        console.log('new organizadoresTop7', this.organizadoresTop7);
      });
    this.flag = false;
    console.log('FINAL');
 
  }

}
 
 