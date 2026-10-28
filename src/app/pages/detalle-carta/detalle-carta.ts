
import { Component } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';

interface Carta {
  id: number;
  nombre: string;
  tipo: string;
  atributo: string;
  nivel: number;
  ataque: number;
  defensa: number;
  descripcion: string;
  imagen: string;
}

@Component({
  selector: 'app-detalle-carta',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './detalle-carta.html',
  styleUrl: './detalle-carta.css'
})
export class DetalleCarta {
  carta: Carta | undefined;

  private cartas: Carta[] = [
    {
      id: 1,
      nombre: 'Mago Oscuro',
      tipo: 'Monstruo / Lanzador de Conjuros',
      atributo: 'OSCURIDAD',
      nivel: 7,
      ataque: 2500,
      defensa: 2100,
      descripcion:
        'El mago más grande en términos de ataque y defensa.',
      imagen: '/images/dark-magin.png'
    },
    {
      id: 2,
      nombre: 'Dragón Blanco de Ojos Azules',
      tipo: 'Monstruo / Dragón',
      atributo: 'LUZ',
      nivel: 8,
      ataque: 3000,
      defensa: 2500,
      descripcion:
        'Un poderoso dragón conocido por su enorme fuerza.',
      imagen: '/images/Blue-eyes.webp'
    },
    {
      id: 3,
      nombre: 'Ash Blossom & Joyous Spring',
      tipo: 'Monstruo / Zombi / Cantante / Efecto',
      atributo: 'FUEGO',
      nivel: 3,
      ataque: 0,
      defensa: 1800,
      descripcion:
        'Puede descartar esta carta para responder a determinados efectos del adversario.',
      imagen: '/images/ash-Bloosom.webp'
    },
    {
      id: 6,
      nombre: 'Angel Del Caos',
      tipo: 'Monstruo / Demonio / Efecto',
      atributo: 'Oscuro',
      nivel: 10,
      ataque: 3500,
      defensa: 2800,
      descripcion: "1 monstruo Cantante + 1 o más monstruos no Cantantes de atributo LUZ u OSCURIDAD Para la Invocación por Sincronía de esta carta," +
        "Cuando se activa una carta o efecto que incluya alguno de los siguientes efectos (Efecto Rápido): puedes descartar esta carta; niega ese efecto." +
        "● Añadir una carta del Deck a la mano." +
        "● Invocar de forma especial desde el Deck." +
        "● Enviar una carta del Deck al Cementerio." +
        "Solo puedes usar este efecto de Ash Blossom & Joyous Spring una vez por turno.",
      imagen: '/images/angel_caos.webp'
    },

    {
      id: 7,
      nombre: 'Varudras, el portador definitivo del fin de los tiempos',
      tipo: 'Monstruo / Demonio / Efecto',
      atributo: 'Oscuro',
      nivel: 10,
      ataque: 3000,
      defensa: 3000,
      descripcion: "2 o más monstruos de Nivel 10" +
        "Cuando tu adversario activa una carta o un efecto (Efecto Rápido): puedes desacoplar 1 material de esta carta; niega la activación, después puedes desacoplar 1 material de esta carta y" +
        ", a continuación, destruir 1 carta en el campo.Al comienzo del Paso de Daño, si esta carta ataca mientras tiene material: puedes destruir 1 carta en el campo." +
        "Si esta carta, que fue Invocada por Xyz, es destruida: puedes destruir 1 carta en el campo." +
        "Solo puedes usar cada efecto de Varudras, el Portador Final del Fin de los Tiempos una vez por turno.",
      imagen: '/images/varudra.webp'
    }


  ];

  constructor(private route: ActivatedRoute) {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.carta = this.cartas.find((carta) => carta.id === id);
  }
}
