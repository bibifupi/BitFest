import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../_servicios/auth-service.service';
 
@Component({
  selector: 'app-registro',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './registro.component.html',
  styleUrl: './registro.component.css'
})
export class RegisterFormComponent implements OnInit {
    registerForm!: FormGroup;
    errorMessage!: string;
 
    constructor(
      private fb: FormBuilder,
      private authService: AuthService,
      private router: Router
    ) { }
 
    ngOnInit(): void {
      this.registerForm = this.fb.group({
        nombre: ['', Validators.required],
        apellidos: ['', Validators.required],
        nombreUsuario: ['', Validators.required],
        email: ['', [Validators.required, Validators.email]],
        contraseña: ['', [Validators.required, Validators.minLength(6)]],
        confirmarContraseña: ['', Validators.required],
        imagen: ['']
      });
    }
 
    onSubmit(): void {
      if (this.registerForm.invalid) {
        return;
      }
 
      this.authService.registro(this.registerForm.value).subscribe(
        () => {
          this.router.navigate(['/login']);
 
            alert('Usuario agregado, por favor inicie sesión');
        },
        (error) => {
          if (error.status === 409) {
            this.errorMessage = 'El correo electrónico ya está en uso';
          } else {
            this.errorMessage = 'Error de servidor. Por favor, inténtalo de nuevo más tarde.';
          }
        }
      );
    }
  }