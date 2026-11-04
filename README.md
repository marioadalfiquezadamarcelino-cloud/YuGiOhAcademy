# Yu-Gi-Oh! Academy

## 1. Descripción del proyecto

Yu-Gi-Oh! Academy es una aplicación web y móvil dedicada al universo del juego de cartas Yu-Gi-Oh!.

El proyecto tiene como objetivo ofrecer una plataforma donde los usuarios puedan consultar información sobre cartas, tipos de cartas, invocaciones, reglas y estrategias del juego.

El desarrollo está dividido en tres partes principales:

- **Frontend web:** desarrollado con Angular.
- **Backend:** desarrollado con Java y Spring Boot.
- **Aplicación móvil:** proyecto Android desarrollado con Kotlin.

La información se almacena en una base de datos MariaDB y se comunica mediante una API REST.

## 2. Tecnologías utilizadas

| Tecnología | Utilización |
|---|---|
| Angular | Desarrollo del frontend web. |
| TypeScript | Programación del frontend. |
| HTML y CSS | Estructura y diseño de las interfaces. |
| Java | Desarrollo del backend. |
| Spring Boot | Creación de la API REST. |
| Spring Data JPA | Acceso a la base de datos. |
| Spring Security | Seguridad y autenticación. |
| JWT | Gestión de tokens de autenticación. |
| MariaDB | Sistema gestor de bases de datos. |
| Maven | Gestión de dependencias y compilación. |
| Android Studio | Desarrollo de la aplicación móvil. |
| Kotlin | Lenguaje de programación para Android. |
| XML Views | Diseño de interfaces Android. |
| Jetpack Compose | Desarrollo de una de las interfaces Android. |

## 3. Frontend web: Angular

Se ha desarrollado la estructura inicial de la aplicación web utilizando Angular.

El proyecto cuenta con el nombre Yu-Gi-Oh! Academy y una navegación organizada mediante rutas.

### Secciones principales

- **Inicio:** página principal de la aplicación.
- **Catálogo:** sección dedicada a las cartas.
- **Guías:** información y contenido de aprendizaje.
- **Estrategias:** información sobre estrategias del juego.
- **Ayuda:** apartado de ayuda.
- **Login:** acceso de los usuarios.

También se ha trabajado en el diseño visual de la aplicación y en la navegación entre sus diferentes secciones.

## 4. Diseño de la aplicación

Se ha realizado un prototipo de la aplicación utilizando Figma.

Se han trabajado diferentes pantallas y propuestas de diseño:

- Página de inicio.
- Catálogo de cartas.
- Estrategias.
- Guías.
- Ayuda y perfil.
- Inicio de sesión.

También se han planteado elementos de diseño como el modo oscuro, botones, formularios, mensajes de error y confirmaciones.

## 5. Base de datos: MariaDB

Se ha creado la base de datos `yugioh_academy` en MariaDB.

### Tablas principales

| Tabla | Descripción |
|---|---|
| carta | Almacena información de las cartas. |
| tipo_carta | Contiene los tipos de cartas. |
| estrategia | Almacena las estrategias del juego. |
| carta_estrategia | Relaciona cartas y estrategias. |
| tipo_invocacion | Contiene los tipos de invocación. |
| carta_invocacion | Relaciona cartas y tipos de invocación. |
| regla | Almacena las reglas del juego. |
| usuario | Almacena los usuarios registrados. |

### Tabla usuario

Se ha incorporado una tabla para gestionar las cuentas de usuario con los siguientes campos:

- `id_usuario`: identificador del usuario.
- `nombre`: nombre del usuario.
- `correo`: correo electrónico único.
- `contrasena`: contraseña almacenada mediante cifrado hash desde el backend.
- `fecha_registro`: fecha de registro.
- `activo`: estado de la cuenta.

### Relaciones entre tablas

El modelo de datos incluye relaciones entre cartas, tipos de cartas, invocaciones y estrategias.

Destaca la relación muchos a muchos (N:M) entre `carta` y `estrategia`, que utiliza la tabla intermedia `carta_estrategia`.

Esta tabla contiene los campos:

- `id_carta`.
- `id_estrategia`.
- `utilidad`.
- `contexto`.

## 6. Backend: Spring Boot

Se ha creado el proyecto backend con el nombre:

`yugioh-academy-api`

Se utiliza Java con Spring Boot para desarrollar los servicios que permiten conectar el frontend con MariaDB.

### Configuración realizada

- Configuración del proyecto Maven.
- Conexión con MariaDB.
- Configuración de Spring Data JPA.
- Configuración de Spring Security.
- Configuración de autenticación mediante JWT.
- Configuración del servidor en el puerto 8080.

### Estructura del backend

```text
com.yugiohacademy.api/
├── config/
│   └── SecurityConfig.java
├── controller/
│   ├── AuthController.java
│   └── UsuarioController.java
├── dto/
│   ├── AuthResponse.java
│   ├── LoginRequest.java
│   └── RegistroRequest.java
├── entity/
│   └── Usuario.java
├── repository/
│   └── UsuarioRepository.java
├── security/
│   ├── JwtService.java
│   └── JwtAuthenticationFilter.java
└── service/
    └── UsuarioService.java
```

### Autenticación y registro

Se han preparado dos endpoints para gestionar las cuentas de usuario:

| Método | Endpoint | Función |
|---|---|---|
| POST | `/api/auth/registro` | Registrar un usuario. |
| POST | `/api/auth/login` | Iniciar sesión. |
| GET | `/api/usuarios/perfil` | Consultar el perfil autenticado. |

Las contraseñas se procesan utilizando BCrypt y la autenticación utiliza tokens JWT.

## 7. Pruebas del backend

Se ha comprobado el funcionamiento del servidor Spring Boot.

El servidor se inicia correctamente en:

```text
http://localhost:8080
```

También se ha creado un archivo `pruebas-api.http` para realizar peticiones HTTP desde el entorno de desarrollo.

### Prueba de registro

Se ha realizado una petición POST al siguiente endpoint:

```http
POST http://localhost:8080/api/auth/registro
Content-Type: application/json
```

Datos enviados:

```json
{
  "nombre": "Usuario Prueba",
  "correo": "prueba@yugiohacademy.com",
  "contrasena": "YuGiOh123"
}
```

**Resultado obtenido:**

`201 Created`

La respuesta confirma que el servidor ha procesado correctamente el registro del usuario y ha generado el token JWT.

## 8. Aplicación Android: Kotlin

Se ha creado un proyecto nuevo en Android Studio con el nombre:

`YuGiOhAcademyTestAPI`

El objetivo es desarrollar una aplicación móvil nativa que se conecte al backend Spring Boot y permita realizar operaciones CRUD.

### Requisitos de desarrollo

- Lenguaje Kotlin.
- Mínimo tres actividades.
- Dos actividades con interfaces XML Views.
- Una actividad con Jetpack Compose.
- Uso del patrón arquitectónico MVVM.
- Conexión con la API REST.
- Validación de los datos.

### Actividades previstas

**Actividad 1. Catálogo de cartas**

- Consultar cartas.
- Buscar cartas.
- Crear cartas.
- Modificar cartas.
- Eliminar cartas.

**Actividad 2. Gestión de estrategias**

- Consultar estrategias.
- Crear estrategias.
- Modificar estrategias.
- Eliminar estrategias.

**Actividad 3. Gestión de cartas y estrategias**

- Consultar asociaciones.
- Asociar cartas con estrategias.
- Modificar la utilidad y el contexto.
- Eliminar asociaciones.

## 9. API REST para el CRUD

Se plantea desarrollar los siguientes endpoints para gestionar la relación muchos a muchos entre cartas y estrategias:

| Método | Endpoint | Operación |
|---|---|---|
| GET | `/api/cartas-estrategias` | Consultar asociaciones. |
| POST | `/api/cartas-estrategias` | Crear asociaciones. |
| PUT | `/api/cartas-estrategias/{idCarta}/{idEstrategia}` | Modificar asociaciones. |
| DELETE | `/api/cartas-estrategias/{idCarta}/{idEstrategia}` | Eliminar asociaciones. |

Estos endpoints están previstos para su implementación en el backend.

## 10. Estado actual del proyecto

### Trabajo realizado

- [x] Creación de la estructura inicial del frontend Angular.
- [x] Configuración de las rutas principales de Angular.
- [x] Diseño inicial de las secciones de la aplicación.
- [x] Elaboración del prototipo en Figma.
- [x] Creación de la base de datos `yugioh_academy`.
- [x] Creación de las tablas principales de MariaDB.
- [x] Incorporación de la tabla `usuario`.
- [x] Creación del proyecto backend Spring Boot.
- [x] Configuración de la conexión con MariaDB.
- [x] Preparación de las entidades, repositorios y servicios de usuario.
- [x] Configuración de Spring Security y JWT.
- [x] Implementación de los endpoints de registro e inicio de sesión.
- [x] Inicio correcto del servidor Spring Boot.
- [x] Creación del proyecto Android `YuGiOhAcademyTestAPI`.
- [x] Creación del archivo `pruebas-api.http`.
- [x] Prueba de registro mediante POST.
- [x] Comprobación de la respuesta HTTP `201 Created`.

### Trabajo pendiente

- [ ] Probar el inicio de sesión mediante POST.
- [ ] Implementar los endpoints CRUD de cartas y estrategias.
- [ ] Implementar los endpoints CRUD de la relación muchos a muchos.
- [ ] Configurar las dependencias Android.
- [ ] Preparar la arquitectura MVVM en Kotlin.
- [ ] Crear las tres actividades Android.
- [ ] Diseñar las interfaces XML Views.
- [ ] Desarrollar la actividad con Jetpack Compose.
- [ ] Conectar Android con Spring Boot.
- [ ] Probar GET, POST, PUT y DELETE desde Android.
- [ ] Realizar las validaciones de datos.
- [ ] Completar las pruebas de funcionamiento.

## 11. Ejecución del proyecto

### Backend

Desde la carpeta del proyecto Spring Boot:

```bash
./mvnw spring-boot:run
```

El servidor estará disponible en:

```text
http://localhost:8080
```

### Frontend Angular

Desde la carpeta del proyecto Angular:

```bash
npm install
ng serve
```

La dirección de desarrollo habitual es:

```text
http://localhost:4200
```

### Android

1. Abrir `YuGiOhAcademyTestAPI` desde Android Studio.
2. Configurar las dependencias.
3. Iniciar el backend Spring Boot.
4. Ejecutar la aplicación mediante un emulador o dispositivo Android.

**Nota:** Desde el emulador Android estándar, para acceder al servidor del ordenador se utilizará `http://10.0.2.2:8080` en lugar de `http://localhost:8080`.

## 12. Autoría

Proyecto académico desarrollado como parte del ciclo formativo de Desarrollo de Aplicaciones Multiplataforma (DAM).

**Nombre del proyecto:** Yu-Gi-Oh! Academy.