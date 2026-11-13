import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';

interface Usuario {
  idUsuario: number;
  nombre: string;
  correo: string;
}

@Component({
  selector: 'app-perfil',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './perfil.html',
  styleUrl: './perfil.css'
})
export class Perfil implements OnInit {

  usuario: Usuario | null = null;

  ngOnInit(): void {

    const datosGuardados = localStorage.getItem('usuario');

    if (datosGuardados) {
      this.usuario = JSON.parse(datosGuardados) as Usuario;
    }

  }
}
