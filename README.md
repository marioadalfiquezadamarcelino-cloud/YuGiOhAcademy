
# Yu-Gi-Oh! Academy

## 1. Descripción del proyecto

Yu-Gi-Oh! Academy es una aplicación web educativa dedicada al juego de cartas Yu-Gi-Oh!. Su objetivo es ofrecer a los usuarios un espacio donde puedan consultar información sobre las cartas, aprender las reglas del juego, conocer los diferentes tipos de invocaciones y descubrir estrategias para mejorar sus duelos.

La aplicación cuenta con una interfaz moderna, adaptable a diferentes dispositivos y con posibilidad de cambiar entre modo oscuro y modo claro.

## 2. Tecnologías utilizadas

- **Angular:** desarrollo del frontend.
- **TypeScript:** lógica de la aplicación.
- **HTML5:** estructura de las páginas.
- **CSS3:** diseño y estilos.
- **Git:** control de versiones.
- **GitHub:** alojamiento del repositorio.

## 3. Funcionalidades

Actualmente, el proyecto incluye las siguientes secciones:

- **Inicio:** página principal de la aplicación.
- **Catálogo:** consulta y búsqueda de cartas.
- **Guías:** información sobre las reglas y mecánicas del juego.
- **Estrategias:** ejemplos de estrategias OTK, FTK, Handtraps y Control.
- **Ayuda:** preguntas frecuentes e información del perfil.
- **Inicio de sesión:** formulario de acceso con validaciones.
- **Registro:** formulario de creación de usuario con validaciones.
- **Modo oscuro y modo claro:** permite cambiar la apariencia de la aplicación y guardar la preferencia.

## 4. Requisitos previos

Para ejecutar el proyecto se necesitan:

- Node.js.
- npm (incluido con Node.js).
- Angular CLI.
- Visual Studio Code (recomendado).

## 5. Instalación

Clonar el repositorio:

```bash
git clone URL_DEL_REPOSITORIO
```

Entrar en la carpeta del proyecto:

```bash
cd yugioh-academy
```

Instalar las dependencias:

```bash
npm install
```

## 6. Ejecución

Iniciar el servidor de desarrollo:

```bash
ng serve
```

Abrir el navegador en:

http://localhost:4200/

## 7. Estructura del proyecto

```text
src/
├── app/
│   ├── pages/
│   │   ├── inicio/
│   │   ├── catalogo/
│   │   ├── detalle-carta/
│   │   ├── guias/
│   │   ├── estrategias/
│   │   ├── ayuda/
│   │   ├── login/
│   │   └── registro/
│   ├── app.ts
│   ├── app.html
│   ├── app.css
│   └── app.routes.ts
├── assets/
├── styles.css
└── index.html
```

## 8. Control de versiones

El proyecto utiliza Git y GitHub para gestionar los cambios mediante ramas.

Las funcionalidades se desarrollan en ramas independientes siguiendo una estructura similar a:

- `develop`: rama de desarrollo.
- `feature/guias`: página de guías.
- `feature/estrategias`: página de estrategias.
- `feature/ayuda-perfil`: ayuda y perfil.
- `feature/login`: inicio de sesión.
- `feature/registro`: registro de usuarios.
- `feature/modo-oscuro`: cambio de tema.

## 9. Autor

Mario Quezada

Proyecto desarrollado como parte de las actividades formativas de Desarrollo de Aplicaciones Multiplataforma (DAM).
