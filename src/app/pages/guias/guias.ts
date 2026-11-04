
import { Component } from '@angular/core';

interface Guia {
  id: number;
  titulo: string;
  categoria: string;
  resumen: string;
  contenido: string[];
}

@Component({
  selector: 'app-guias',
  standalone: true,
  imports: [],
  templateUrl: './guias.html',
  styleUrl: './guias.css'
})
export class Guias {
  categoriaSeleccionada = 'Todas';

  categorias = [
    'Todas',
    'Reglas básicas',
    'Fases del duelo',
    'Invocaciones',
    'Tipos de cartas'
  ];

  guias: Guia[] = [
    {
      id: 1,
      titulo: 'Objetivo del duelo',
      categoria: 'Reglas básicas',
      resumen: 'Aprende cómo se gana una partida de Yu-Gi-Oh!',
      contenido: [
        'Cada jugador comienza normalmente con 8000 puntos de vida en un duelo estándar.',
        'Puedes ganar reduciendo los puntos de vida del adversario a cero.',
        'También existen condiciones especiales de victoria y situaciones en las que un jugador pierde por no poder robar cuando debe hacerlo.'
      ]
    },
    {
      id: 2,
      titulo: 'Cómo se desarrolla un duelo',
      categoria: 'Fases del duelo',
      resumen: 'Conoce las fases que organizan los turnos.',
      contenido: [
        'Draw Phase: se roba una carta al comenzar el turno, salvo excepciones.',
        'Standby Phase: se resuelven los efectos que correspondan a esta fase.',
        'Main Phase 1: puedes realizar invocaciones y otras acciones permitidas.',
        'Battle Phase: puedes declarar ataques si las condiciones lo permiten.',
        'Main Phase 2: puedes realizar otras acciones principales después de la batalla.',
        'End Phase: se resuelven los efectos correspondientes al final del turno.'
      ]
    },
    {
      id: 3,
      titulo: 'Invocación por Fusión',
      categoria: 'Invocaciones',
      resumen: 'Aprende cómo se invocan monstruos de Fusión.',
      contenido: [
        'Los monstruos de Fusión suelen encontrarse en el Deck Extra.',
        'Normalmente se utilizan materiales indicados en su carta y un efecto que permita realizar la Invocación por Fusión.',
        'Los materiales y el procedimiento exacto dependen de la carta y del efecto utilizado.'
      ]
    },
    {
      id: 4,
      titulo: 'Invocación por Sincronía',
      categoria: 'Invocaciones',
      resumen: 'Descubre la función de los Cantantes y los niveles.',
      contenido: [
        'Normalmente necesitas un monstruo Cantante y uno o más monstruos que no sean Cantantes.',
        'La suma de sus Niveles debe coincidir con el Nivel del monstruo de Sincronía que quieres Invocar.',
        'Debes cumplir también los requisitos concretos que indique la carta.'
      ]
    },
    {
      id: 5,
      titulo: 'Invocación Xyz',
      categoria: 'Invocaciones',
      resumen: 'Comprende los Rangos y los materiales Xyz.',
      contenido: [
        'Los monstruos Xyz normalmente se encuentran en el Deck Extra.',
        'Por lo general, se colocan sobre monstruos que cumplen los requisitos de Nivel indicados en la carta.',
        'Los materiales Xyz pueden utilizarse para pagar costes o activar efectos.'
      ]
    },
    {
      id: 6,
      titulo: 'Monstruos, Mágicas y Trampas',
      categoria: 'Tipos de cartas',
      resumen: 'Distingue las principales familias de cartas.',
      contenido: [
        'Los monstruos pueden atacar, defender y utilizar efectos según sus características.',
        'Las cartas Mágicas producen efectos y se utilizan conforme a sus reglas.',
        'Las cartas Trampa suelen responder a determinadas acciones y normalmente necesitan prepararse en el Campo antes de activarse.'
      ]
    },
    {
      id: 7,
      titulo: 'Invocaciones de Péndulo y Enlace',
      categoria: 'Invocaciones',
      resumen: 'Conoce dos mecánicas importantes del juego moderno.',
      contenido: [
        'La Invocación por Péndulo permite Invocar varios monstruos simultáneamente si se cumplen las condiciones de las Escalas de Péndulo.',
        'Los monstruos de Enlace tienen un Valor de Enlace y requisitos de materiales específicos.',
        'Las zonas y reglas aplicables dependen de la mecánica y de las reglas oficiales vigentes.'
      ]
    }
  ];

  get guiasFiltradas(): Guia[] {
    if (this.categoriaSeleccionada === 'Todas') {
      return this.guias;
    }

    return this.guias.filter(
      (guia) => guia.categoria === this.categoriaSeleccionada
    );
  }

  cambiarCategoria(evento: Event): void {
    const select = evento.target as HTMLSelectElement;
    this.categoriaSeleccionada = select.value;
  }
}
