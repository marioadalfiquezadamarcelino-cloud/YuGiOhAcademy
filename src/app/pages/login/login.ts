import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink, Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

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
  cargando = false;

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  iniciarSesion(): void {
    this.mensajeError = '';
    this.mensajeExito = '';

    if (!this.correo.trim() || !this.contrasena) {
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

    this.cargando = true;

    this.authService.iniciarSesion({
      correo: this.correo.trim(),
      contrasena: this.contrasena
    }).subscribe({

      next: (respuesta) => {
        console.log('Respuesta completa:', respuesta);
        console.log('Token recibido:', respuesta.token);
        console.log('Nombre recibido:', respuesta.nombre);
       
        // Guardar el token de autenticación
        localStorage.setItem('token', respuesta.token);

        // Guardar los datos básicos del usuario
        localStorage.setItem('usuario', JSON.stringify({
          idUsuario: respuesta.idUsuario,
          nombre: respuesta.nombre,
          correo: respuesta.correo
        }));

        this.mensajeExito = respuesta.mensaje;
        this.mensajeError = '';
        this.cargando = false;

        // Ir a la página de inicio
        this.router.navigate(['/inicio']);
      },

      error: (error) => {
        this.mensajeError =
          error.error?.mensaje ||
          'Correo electrónico o contraseña incorrectos.';

        this.cargando = false;
      }

    });
  }

  alternarContrasena(): void {
    this.mostrarContrasena = !this.mostrarContrasena;
  }
}
