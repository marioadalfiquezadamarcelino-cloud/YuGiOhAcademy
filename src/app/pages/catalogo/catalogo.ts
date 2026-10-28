
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
        "Cuando se activa una carta o efecto que incluya alguno de los siguientes efectos (Efecto Rápido): puedes descartar esta carta; niega ese efecto."+
    "● Añadir una carta del Deck a la mano."+
    "● Invocar de forma especial desde el Deck."+
    "● Enviar una carta del Deck al Cementerio."+
    "Solo puedes usar este efecto de Ash Blossom & Joyous Spring una vez por turno.",
      imagen: '/images/ash-Bloosom.webp'
    },
    {
      id: 4,
      nombre: 'Raigeki',
      tipo: 'Mágica',
      descripcion:
        "Destruye todos los monstruos que controla tu oponente.",
      imagen: '/images/raigenki.webp'
    },
    {
      id: 5,
      nombre: 'Mirror Force',
      tipo: 'Trampa',
      descripcion:
        "Cuando un monstruo del oponente declara un ataque: Destruye todos los monstruos de tu oponente en Posición de Ataque.",
      imagen: '/images/mirror-force.webp'
    },
      {
      id: 6,
      nombre: 'Angel Del Caos',
      tipo: 'Monstruo',
      descripcion:"1 monstruo Cantante + 1 o más monstruos no Cantantes de atributo LUZ u OSCURIDAD Para la Invocación por Sincronía de esta carta,"+
      "puedes tratar a 1 monstruo de LUZ u OSCURIDAD que controles como un Cantante.Si esta carta es Invocada de Modo Especial: puedes seleccionar 1 carta en el campo;"+
      "destiérrala.Esta carta obtiene estos efectos en función de los Atributos originales de los materiales utilizados para su Invocación por Sincronía."+
      "● LUZ: Los monstruos Sincro que controlas no se ven afectados por los efectos de monstruos activados por tu oponente."+
      "● OSCURIDAD: Los monstruos que controlas no pueden ser destruidos en batalla",
      imagen: '/images/angel_caos.webp'
    },
      {
      id: 7,
      nombre:'Varudras, el portador definitivo del fin de los tiempos',
      tipo: 'Monstruo',
      descripcion:"2 o más monstruos de Nivel 10"+
"Cuando tu adversario activa una carta o un efecto (Efecto Rápido): puedes desacoplar 1 material de esta carta; niega la activación, después puedes desacoplar 1 material de esta carta y"+
", a continuación, destruir 1 carta en el campo.Al comienzo del Paso de Daño, si esta carta ataca mientras tiene material: puedes destruir 1 carta en el campo."+
"Si esta carta, que fue Invocada por Xyz, es destruida: puedes destruir 1 carta en el campo."+
"Solo puedes usar cada efecto de Varudras, el Portador Final del Fin de los Tiempos una vez por turno.",
      imagen: '/images/varudra.webp'
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
