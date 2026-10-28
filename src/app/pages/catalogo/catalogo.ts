
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

interface Carta {
  id: number;
  nombre: string;
  tipo: 'Monstruo' | 'Mágica' | 'Trampa';
  descripcion: string;
  imagen: string;
}

@Component({
  selector: 'app-catalogo',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './catalogo.html',
  styleUrl: './catalogo.css'
})
export class Catalogo {

  busqueda = '';
  tipoSeleccionado = 'Todas';

  cartas: Carta[] = [
    {
      id: 1,
      nombre: 'Mago Oscuro',
      tipo: 'Monstruo',
      descripcion:
        'Un monstruo emblemático de tipo Lanzador de Conjuros.',
      imagen: '/images/dark-magin.png'
    },
    {
      id: 2,
      nombre: 'Dragón Blanco de Ojos Azules',
      tipo: 'Monstruo',
      descripcion:
        'Un poderoso monstruo de tipo Dragón conocido por su fuerza.',
      imagen: '/images/Blue-eyes.webp'
    },
    {
      id: 3,
      nombre: 'Ash Blossom & Joyous Spring',
      tipo: 'Monstruo',
      descripcion:
        'Una carta muy conocida por su capacidad para interrumpir determinados efectos.',
      imagen: '/images/ash-Bloosom.webp'
    },
    {
      id: 4,
      nombre: 'Raigeki',
      tipo: 'Mágica',
      descripcion:
        'Carta Mágica que destruye los monstruos del adversario en el Campo.',
      imagen: '/images/raigenki.webp'
    },
    {
      id: 5,
      nombre: 'Mirror Force',
      tipo: 'Trampa',
      descripcion:
        'Carta Trampa que puede responder a un ataque del adversario.',
      imagen: '/images/mirror-force.webp'
    }
  ];

  get cartasFiltradas(): Carta[] {
    const texto = this.busqueda.trim().toLocaleLowerCase();

    return this.cartas.filter((carta) => {
      const coincideNombre =
        carta.nombre.toLocaleLowerCase().includes(texto);

      const coincideTipo =
        this.tipoSeleccionado === 'Todas' ||
        carta.tipo === this.tipoSeleccionado;

      return coincideNombre && coincideTipo;
    });
  }

  cambiarBusqueda(evento: Event): void {
    const elemento = evento.target as HTMLInputElement;
    this.busqueda = elemento.value;
  }

  cambiarTipo(evento: Event): void {
    const elemento = evento.target as HTMLSelectElement;
    this.tipoSeleccionado = elemento.value;
  }

  imagenNoDisponible(evento: Event): void {
    const imagen = evento.target as HTMLImageElement;
    imagen.alt = 'Imagen de carta no disponible';
  }
}
