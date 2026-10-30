import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';


interface Pregunta{
  pregunta: string;
  respuesta: string;
}

@Component({
  imports: [RouterLink],
  standalone:true,
  selector: 'app-ayuda',
  styleUrl: './ayuda.css',
  templateUrl: './ayuda.html',
})
export class Ayuda {
  preguntas:Pregunta[] = [
    {
      pregunta: '¿Qué puedo encontrar en Yu-Gi-Oh! Academy?',
      respuesta:'Puedes consultar, aprender reglas, descubrir tipos de invocación y estudiar'+
      'estrategias para mejorar tus duelos.'
    },
    {
      pregunta:'¿cómo puedo buscar una carta?',
      respuesta:'Entra en el catálogo y utiliza el buscador o el filtro por tipo de carta para' +
      'localizar la información disponible.'
    },
    {
      pregunta:'¿Qué significan OTK y FTK?',
      respuesta:'OTK es una victoria en un turno. FTK es una victoria conseguida durante el primer'+
      'turno, antes de que el adversario juegue.'
    },
    {
      pregunta:'¿Qué es una Handtrp?',
      respuesta:'Es una carta que puede utilizarse desde la mano para responder a determinadas'+
      'acciones del adversario, si se cumplen sus condiciones.'
    },
    {
      pregunta:'¿Las guías sustituyen las reglas oficioles?',
      respuesta:'¿No, Son materia educativo. Consulta las reglas oficiales y el texto de cada carta para confimar sus condiciones y excepciones?.'
    },
    {
      pregunta:'¿Necesito una cuenta para consultar el contenido?',
      respuesta:'Puedes consultar las secciones públicas de la aplicación. Las funciones que'+
      'requieran una cuenta dependerán de cómo se implemente el sistema de usuarios.'
    }
  ];

  preguntaAbierta: number | null = 0;

  alternarPregunta(indice: number): void{
    this.preguntaAbierta = 
    this.preguntaAbierta === indice ? null : indice;
  }
}
