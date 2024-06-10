import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject, map } from 'rxjs';
import { Organizadores } from '../interfaces/Organizadores';
 
@Injectable({
  providedIn: 'root'
})
export class OrganizadoresService {
  private url = 'http://localhost:8080/api/v1/auth/organizadores';
 
  constructor(private http: HttpClient) { }
 
 
  listarOrganizadores7primeros(): Observable<Organizadores[]> {
    return this.http.get<Organizadores[]>(`${this.url}/7primerosOrganizador`);
  }
 
  listarOrganizadorPorId(id: number): Observable<Organizadores> {
    return this.http.get<Organizadores>(`${this.url}/${id}`);
  }
 
  findOrganizadoresByNombre(nombre: string): Observable<Organizadores[]> {
    return this.http.get<Organizadores[]>(`${this.url}/porOrganizadorLike?nombre=${nombre}`);
  }
 
  getOrganizadores(){
    console.log('getOrganizadores INICIO', this.url)
    return this.http.get<Organizadores[]>(this.url);
  }
 
 
}