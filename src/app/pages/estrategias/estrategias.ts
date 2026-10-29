
import { Component } from '@angular/core';

type CategoriaEstrategia = 'OTK' | 'FTK' | 'Handtrap' | 'Control';

interface Estrategia {
  id: number;
  nombre: string;
  categoria: CategoriaEstrategia;
  dificultad: string;
  resumen: string;
  cuandoUsarla: string;
  ventajas: string[];
  precauciones: string;
}

@Component({
  selector: 'app-estrategias',
  standalone: true,
  imports: [],
  templateUrl: './estrategias.html',
  styleUrl: './estrategias.css'
})
export class Estrategias {
  categoriaSeleccionada = 'Todas';

  categorias = ['Todas', 'OTK', 'FTK', 'Handtrap', 'Control'];

  estrategias: Estrategia[] = [
    {
      id: 1,
      nombre: 'OTK: victoria en un turno',
      categoria: 'OTK',
      dificultad: 'Intermedia',
      resumen:
        'Prepara una combinación de cartas capaz de infligir todo el daño necesario en un turno.',
      cuandoUsarla:
        'Cuando el adversario tiene pocos recursos defensivos y puedes desarrollar una jugada ofensiva segura.',
      ventajas: [
        'Permite cerrar el duelo rápidamente.',
        'Aprovecha combinaciones de cartas y efectos.',
        'Puede castigar una defensa insuficiente.'
      ],
      precauciones:
        'Comprueba los puntos de vida, los monstruos defensivos y las posibles interrupciones del adversario.'
    },
    {
      id: 2,
      nombre: 'FTK: ganar antes de que juegue',
      categoria: 'FTK',
      dificultad: 'Alta',
      resumen:
        'Busca completar una condición de victoria durante el primer turno, antes de que el adversario tenga su turno.',
      cuandoUsarla:
        'En una estrategia construida específicamente para alcanzar una condición de victoria inmediata.',
      ventajas: [
        'Intenta terminar el duelo desde el comienzo.',
        'Depende de una combinación concreta de cartas.',
        'Permite estudiar la consistencia de un combo.'
      ],
      precauciones:
        'Estas estrategias pueden ser muy vulnerables a las interrupciones y algunas combinaciones pueden estar limitadas o prohibidas.'
    },
    {
      id: 3,
      nombre: 'Ash Blossom & Joyous Spring',
      categoria: 'Handtrap',
      dificultad: 'Básica',
      resumen:
        'Una Handtrap que puede responder a ciertos efectos que añaden cartas del Deck, Invocan desde el Deck o mandan cartas del Deck al Cementerio.',
      cuandoUsarla:
        'Cuando identificas un efecto relevante del adversario que cumple las condiciones de activación de esta carta.',
      ventajas: [
        'Puede interrumpir búsquedas importantes.',
        'Puede frenar determinadas jugadas de combo.',
        'Se puede activar desde la mano si se cumplen sus condiciones.'
      ],
      precauciones:
        'No niega cualquier efecto. Lee el texto de la carta del adversario y las condiciones exactas de Ash Blossom.'
    },
    {
      id: 4,
      nombre: 'Effect Veiler',
      categoria: 'Handtrap',
      dificultad: 'Básica',
      resumen:
        'Puede seleccionar un monstruo de efecto boca arriba del adversario y negar sus efectos durante la fase correspondiente.',
      cuandoUsarla:
        'Cuando un monstruo del adversario es una pieza importante de su combo y puedes activar el efecto de esta carta legalmente.',
      ventajas: [
        'Permite responder desde la mano.',
        'Puede detener efectos de monstruos clave.',
        'Ayuda a interrumpir el desarrollo del adversario.'
      ],
      precauciones:
        'Su activación tiene condiciones específicas, incluida la fase principal del adversario.'
    },
    {
      id: 5,
      nombre: 'Nibiru, the Primal Being',
      categoria: 'Handtrap',
      dificultad: 'Intermedia',
      resumen:
        'Puede castigar a los adversarios que realizan muchas Invocaciones de Monstruos en un mismo turno.',
      cuandoUsarla:
        'Cuando el adversario ha realizado suficientes Invocaciones y no dispone de una respuesta que impida resolver su efecto.',
      ventajas: [
        'Puede cambiar por completo el estado del Campo.',
        'Presiona a los Decks que desarrollan combos largos.',
        'Obliga al adversario a considerar posibles interrupciones.'
      ],
      precauciones:
        'Requiere cumplir sus condiciones de activación. Algunos Decks pueden jugar alrededor de ella.'
    },
    {
      id: 6,
      nombre: 'Estrategia de control',
      categoria: 'Control',
      dificultad: 'Intermedia',
      resumen:
        'Busca limitar las opciones del adversario mediante interrupciones, gestión de recursos y respuestas bien calculadas.',
      cuandoUsarla:
        'Cuando tu Deck puede responder a las jugadas del adversario y mantener recursos para turnos posteriores.',
      ventajas: [
        'No depende exclusivamente de ganar en un solo turno.',
        'Permite aprovechar los recursos con planificación.',
        'Puede adaptarse a diferentes situaciones del duelo.'
      ],
      precauciones:
        'Necesitas gestionar bien tus recursos y reconocer qué jugadas del adversario son realmente peligrosas.'
    }
  ];

  get estrategiasFiltradas(): Estrategia[] {
    if (this.categoriaSeleccionada === 'Todas') {
      return this.estrategias;
    }

    return this.estrategias.filter(
      estrategia => estrategia.categoria === this.categoriaSeleccionada
    );
  }

  cambiarCategoria(evento: Event): void {
    const select = evento.target as HTMLSelectElement;
    this.categoriaSeleccionada = select.value;
  }
}
