import { Routes } from '@angular/router';

import { Inicio } from './pages/inicio/inicio';
import { Catalogo } from './pages/catalogo/catalogo';
import { DetalleCarta } from './pages/detalle-carta/detalle-carta';
import { Login } from './pages/login/login';
import { Registro } from './pages/registro/registro';
import { Guias } from './pages/guias/guias';
import { Estrategias } from './pages/estrategias/estrategias';
import { Ayuda } from './pages/ayuda/ayuda';
import { authGuard } from './guards/auth.guard';

export const routes: Routes = [
  { path: '', redirectTo: 'inicio', pathMatch: 'full' },

  // Páginas públicas
  { path: 'inicio', component: Inicio },
  { path: 'catalogo', component: Catalogo },
  { path: 'carta/:id', component: DetalleCarta },
  { path: 'login', component: Login },
  { path: 'registro', component: Registro },
  { path: 'guias', component: Guias },
  { path: 'estrategias', component: Estrategias },
  { path: 'ayuda', component: Ayuda },

  // Página privada de ejemplo
  {
    path: 'perfil',
    canActivate: [authGuard],
    loadComponent: () =>
      import('./pages/perfil/perfil').then(m => m.Perfil)
  },

  { path: '**', redirectTo: 'inicio' }
];
