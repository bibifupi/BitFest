import { Component, OnInit } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AuthService } from '../_servicios/auth-service.service';
 
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule,CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  errorMessage!: string;
 
  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) { }
 
  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      contraseña: ['', Validators.required]
    });
  }
 
  onSubmit(): void {
    if (this.loginForm.invalid) {
      return;
    }
 
    const { email, contraseña } = this.loginForm.value;
 
    this.authService.login(email, contraseña).subscribe(
      () => {
       
        this.router.navigate(['/inicio']);
      },
      (error) => {
        if (error.status === 401) {
          this.errorMessage = 'Correo electrónico o contraseña incorrectos';
        } else {
          this.errorMessage = 'Error de servidor. Por favor, inténtalo de nuevo más tarde.';
        }
      }
    );
  }
}