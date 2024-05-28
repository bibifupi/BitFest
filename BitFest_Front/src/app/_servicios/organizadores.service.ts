import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, map } from 'rxjs';
import { Organizadores } from '../interfaces/Organizadores';

@Injectable({
  providedIn: 'root'
})
export class OrganizadoresService {
  private url = 'http://localhost:8080/organizadores';
  private organizadores = new BehaviorSubject<any[]>([]);

  constructor(private http: HttpClient) { }


  listarOrganizadores(): Observable<Organizadores[]> {
    return this.http.get<Organizadores[]>(this.url).pipe(map(data => data.sort((a, b) => a.idOrganizador - b.idOrganizador)));

  }

  listarOrganizadorPorId(id: number): Observable<Organizadores> {
    return this.http.get<Organizadores>(`${this.url}/${id}`);
  }


  addOrganizador(organizador: Organizadores): Observable<Object> {
    return this.http.post(this.url, organizador);
  }

  editOrganizador(organizador: Organizadores): Observable<Object> {
    return this.http.put(this.url, organizador);
  }

  eliminarOrganizador(id: number): Observable<Object> {
    return this.http.delete(`${this.url}/${id}`);
  }



  getOrganizadores(): Observable<any[]> {
    return this.organizadores.asObservable();
  }

  setOrganizadores(organizadores: any[]) {
    this.organizadores.next(organizadores);
  }

  // Aquí puedes agregar más métodos para manejar los datos, como agregar o eliminar organizadores, etc.
}