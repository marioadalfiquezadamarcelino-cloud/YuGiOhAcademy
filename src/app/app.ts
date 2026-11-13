import { Component, OnInit } from '@angular/core';
import {
  RouterOutlet,
  RouterLink,
  RouterLinkActive,
  Router,
  NavigationEnd
} from '@angular/router';

@Component({
  imports: [RouterOutlet, RouterLinkActive, RouterLink],
  standalone: true,
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App implements OnInit {

  modoOscuro = true;

  usuario: {
    idUsuario: number;
    nombre: string;
    correo: string;
  } | null = null;

  constructor(private router: Router) {}

  ngOnInit(): void {
    const temaGuardado = localStorage.getItem('tema');

    if (temaGuardado === 'claro') {
      this.modoOscuro = false;
    }

    this.aplicarTema();

    this.cargarUsuario();

    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.cargarUsuario();
      }
    });
  }

  cargarUsuario(): void {
    const token = localStorage.getItem('token');
    const usuarioGuardado = localStorage.getItem('usuario');

    if (token && usuarioGuardado) {
      try {
        this.usuario = JSON.parse(usuarioGuardado);
      } catch {
        this.usuario = null;
      }
    } else {
      this.usuario = null;
    }
  }

  cambiarTema(): void {
    this.modoOscuro = !this.modoOscuro;

    localStorage.setItem(
      'tema',
      this.modoOscuro ? 'oscuro' : 'claro'
    );

    this.aplicarTema();
  }

  aplicarTema(): void {
    document.body.classList.toggle('modo-claro', !this.modoOscuro);
  }

  cerrarSesion(): void {
    localStorage.removeItem('token');
    localStorage.removeItem('usuario');

    this.usuario = null;

    this.router.navigate(['/inicio']);
  }
}
