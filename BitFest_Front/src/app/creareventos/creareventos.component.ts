import { Component, OnInit } from '@angular/core';
import { EventosService } from '../_servicios/eventos.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-creareventos',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './creareventos.component.html',
  styleUrl: './creareventos.component.css'
})
export class CreareventosComponent implements OnInit {
  nuevoEvento = {nombre: '', descripcion: '', fecha: ''};

  constructor(private eventosService: EventosService) {}

  ngOnInit() {}

  
}
