import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, map } from 'rxjs';
import { Eventos } from '../interfaces/Eventos';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EventosService {
  private url = 'http://localhost:8080/eventos';
  private eventos = new BehaviorSubject<any[]>([]);

  constructor(private http: HttpClient) { }

  listarEventos(): Observable<Eventos[]> {
    return this.http.get<Eventos[]>(this.url).pipe(map(data => data.sort((a, b) => a.idEvento - b.idEvento)));

  }

  listarEventoPorId(id: number): Observable<Eventos> {
    return this.http.get<Eventos>(`${this.url}/${id}`);
  }


  //listarEventoPorOrganizador():Observable<Eventos>{

  // }

  eliminarEvento(id: number): Observable<Eventos> {
    return this.http.delete<Eventos>(`${this.url}/${id}`);
  }


  addEvento(evento: Eventos): Observable<Object> {
    return this.http.post(this.url, evento);
  }

  editEvento(evento: Eventos): Observable<Object> {
    return this.http.put(this.url, evento);
  }

}