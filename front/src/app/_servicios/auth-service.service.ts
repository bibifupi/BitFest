import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, tap, throwError } from 'rxjs';
import { Usuarios } from '../interfaces/Usuarios';
 
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private loginUrl = 'http://localhost:8080/api/v1/auth/login'; // URL de tu API
  private registerUrl = 'http://localhost:8080/api/v1/auth/registro'; // URL de tu API
  private deleteUrl = 'http://localhost:8080/api/v1/auth/usuarios/eliminar';
  private profileUrl =  'http://localhost:8080/api/v1/auth/usuarios';
 
  constructor(private http: HttpClient) { }
 
  login(email: string, contraseña: string): Observable<any> {
    return this.http.post<any>(this.loginUrl, { email, contraseña }).pipe(
      tap(response => {
        if (response && response.token) {
          localStorage.setItem('authToken', response.token);
        }
      })
    );
  }
 
  registro(usuario: any): Observable<any> {
    return this.http.post<any>(this.registerUrl, usuario).pipe(
      catchError(error => {
        if (error.status === 409) {
          return throwError('El correo electrónico ya está en uso');
        } else {
          return throwError('Error de servidor. Por favor, inténtalo de nuevo más tarde.');
        }
      })
    );
 
  }

  eliminarUsuario(): Observable<void> {
    const token=localStorage.getItem('authToken');
    const headers= new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.delete<void>(`${this.deleteUrl}`, { headers });
  }
// En el AuthService
getUsuarioAutenticado(): Observable<Usuarios> {
  const token = localStorage.getItem('authToken');
  console.log('Token:', token);
  const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
  console.log('URL:', `${this.profileUrl}/perfil`);
  return this.http.get<Usuarios>(`${this.profileUrl}/perfil`, { headers });
}


  actualizarUsuario(idUsuario:number, usuario:Usuarios): Observable<void> {
    const token = localStorage.getItem('authToken');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.put<void>(`${this.profileUrl}/${idUsuario}`, usuario, { headers });
  }



 
  logout(): void {
    localStorage.removeItem('authToken');
  }
 
  isLoggedIn(): boolean {
    return !!localStorage.getItem('authToken');
  }
}