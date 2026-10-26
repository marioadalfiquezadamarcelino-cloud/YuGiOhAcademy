import { Routes } from '@angular/router';
import { Inicio } from './pages/inicio/inicio';
import { Catalogo } from './pages/catalogo/catalogo';
import { DetalleCarta } from './pages/detalle-carta/detalle-carta';
import { Estrategias } from './pages/estrategias/estrategias';
import { Login } from './pages/login/login';
import { Registro } from './pages/registro/registro';
import { Guias } from './pages/guias/guias';
import { Ayuda } from './pages/ayuda/ayuda';
export class App{

}

export const routes: Routes = [
{path: "", redirectTo: 'inicio', pathMatch: 'full'},
{path: 'inicio', component: Inicio},
{path: 'catalogo', component: Catalogo},
{path: 'detalle-carta', component: DetalleCarta},
{path: 'estrategia', component:Estrategias},
{path: 'login', component:Login},
{path: 'registro', component:Registro},
{path: 'guias', component:Guias},
{path: 'ayuda', component:Ayuda},
{path: "**", redirectTo: 'inicio' }
];
