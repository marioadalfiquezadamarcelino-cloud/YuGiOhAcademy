
import { Component, OnInit } from '@angular/core';
import { RouterOutlet, RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  imports: [RouterOutlet, RouterLinkActive, RouterLink],
  standalone: true,
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App implements OnInit {

  modoOscuro = true;

  ngOnInit(): void {
    const temaGuardado = localStorage.getItem('tema');

    if (temaGuardado === 'claro') {
      this.modoOscuro = false;
    }

    this.aplicarTema();
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
}
