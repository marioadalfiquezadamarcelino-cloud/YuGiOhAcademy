import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-registro',
  standalone: true,
  imports: [FormsModule, RouterLink],
  templateUrl: './registro.html',
  styleUrl: './registro.css'
})
export class Registro {
  nombre = '';
  correo = '';
  contrasena = '';
  repetirContrasena = '';

  mostrarContrasena = false;
  aceptarCondiciones = false;

  mensajeError = '';
  mensajeExito = '';
  cargando = false;

  constructor(private authService: AuthService) {}

  registrarUsuario(): void {
    this.mensajeError = '';
    this.mensajeExito = '';

    if (
      !this.nombre.trim() ||
      !this.correo.trim() ||
      !this.contrasena ||
      !this.repetirContrasena
    ) {
      this.mensajeError = 'Todos los campos son obligatorios.';
      return;
    }

    const formatoCorreo = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!formatoCorreo.test(this.correo)) {
      this.mensajeError = 'Introduce un correo electrónico válido.';
      return;
    }

    if (this.contrasena.length < 8) {
      this.mensajeError =
        'La contraseña debe tener al menos 8 caracteres.';
      return;
    }

    if (!/[A-Z]/.test(this.contrasena)) {
      this.mensajeError =
        'La contraseña debe contener al menos una mayúscula.';
      return;
    }

    if (!/[a-z]/.test(this.contrasena)) {
      this.mensajeError =
        'La contraseña debe contener al menos una minúscula.';
      return;
    }

    if (!/[0-9]/.test(this.contrasena)) {
      this.mensajeError =
        'La contraseña debe contener al menos un número.';
      return;
    }

    if (this.contrasena !== this.repetirContrasena) {
      this.mensajeError = 'Las contraseñas no coinciden.';
      return;
    }

    if (!this.aceptarCondiciones) {
      this.mensajeError =
        'Debes aceptar las condiciones para continuar.';
      return;
    }

    this.cargando = true;

    this.authService.registrar({
      nombre: this.nombre.trim(),
      correo: this.correo.trim(),
      contrasena: this.contrasena
    }).subscribe({

      next: (respuesta) => {
        this.mensajeExito = respuesta.mensaje;
        this.mensajeError = '';

        this.nombre = '';
        this.correo = '';
        this.contrasena = '';
        this.repetirContrasena = '';
        this.aceptarCondiciones = false;

        this.cargando = false;
      },

      error: (error) => {
        this.mensajeError =
          error.error?.mensaje ||
          'No se pudo completar el registro. Inténtalo de nuevo.';

        this.cargando = false;
      }

    });
  }

  alternarContrasena(): void {
    this.mostrarContrasena = !this.mostrarContrasena;
  }
}
