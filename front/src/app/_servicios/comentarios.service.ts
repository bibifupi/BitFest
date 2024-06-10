import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, map } from 'rxjs';
import { Comentarios } from '../interfaces/Comentarios';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ComentariosService {
  private url = 'http://localhost:8080/api/v1/auth/comentarios';
  private comentarios = new BehaviorSubject<any[]>([]);

  constructor(private http: HttpClient) { }

  listarComentarios(): Observable<Comentarios[]> {
    return this.http.get<Comentarios[]>(this.url).pipe(map((data: any[]) => data.sort((a, b) => a.idComentario - b.idComentario)));

  }
  listarComentariosPorEvento(idEvento: number): Observable<Comentarios[]> {
    return this.http.get<Comentarios[]>(`${this.url}/evento/${idEvento}`);
  }

  listarComentarioPorId(id: number): Observable<Comentarios> {
    return this.http.get<Comentarios>(`${this.url}/${id}`);
  }
  

  eliminarComentario(id: number): Observable<Comentarios> {
    return this.http.delete<Comentarios>(`${this.url}/${id}`);
  }


  addComentario(comentario: Comentarios): Observable<Comentarios> {
      return this.http.post<Comentarios>(this.url, comentario);
  }

  editEvento(comentarios: Comentarios): Observable<Object> {
    return this.http.put(this.url, comentarios);

  }
}