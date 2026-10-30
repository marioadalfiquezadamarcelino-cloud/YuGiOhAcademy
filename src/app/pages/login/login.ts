
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, RouterLink],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {
  correo = '';
  contrasena = '';

  mostrarContrasena = false;
  mensajeError = '';
  mensajeExito = '';

  iniciarSesion(): void {
    this.mensajeError = '';
    this.mensajeExito = '';

    if (!this.correo.trim() || !this.contrasena.trim()) {
      this.mensajeError = 'Todos los campos son obligatorios.';
      return;
    }

    const formatoCorreo = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!formatoCorreo.test(this.correo)) {
      this.mensajeError = 'Introduce un correo electrónico válido.';
      return;
    }

    if (this.contrasena.length < 8) {
      this.mensajeError = 'La contraseña debe tener al menos 8 caracteres.';
      return;
    }

    this.mensajeExito = 'Formulario validado correctamente.';
  }

  alternarContrasena(): void {
    this.mostrarContrasena = !this.mostrarContrasena;
  }
}
