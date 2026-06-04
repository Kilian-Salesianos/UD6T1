# UD6T1 - Gestión de Películas, Pedidos y Participantes

Repositorio didáctico para practicar creación de clases en Java, lectura de ficheros CSV, uso de colecciones y salida por consola. Incluye una clase ejecutable `App` que carga películas desde un CSV y muestra información mediante un menú interactivo.

## Objetivos de la actividad

- Diseñar clases sencillas (`Pelicula`, `Pedido`, `Participante`).
- Leer datos desde un fichero CSV (`src/peliculas.csv`).
- Manipular listas (añadir/recorrer) y mostrar resúmenes.
- Practicar entrada/salida de consola y control de flujo con un menú.

## Estructura del proyecto

- `src/` - Código fuente Java
  - `App.java` - Programa principal/ejecutable con `main`, menú y funciones para cargar y mostrar datos.
  - `net/salesianos/pelicula/Pelicula.java` - Clase `Pelicula` (atributos: `titulo`, `genero`, `duracionMinutos`).
  - `net/salesianos/pedido/Pedido.java` - Clase `Pedido` (atributos: `codigo`, `cliente`, `producto`, `paraLlevar`).
  - `net/salesianos/participante/Participante.java` - Clase `Participante` (atributos: `idJugador`, `nombre`, `categoria`).
- `src/peliculas.csv` - Fichero CSV con datos de ejemplo (cabecera: `titulo,genero,duracionMinutos`).
- `bin/` - Salida de compilación (`.class`) generada localmente.
- `.vscode/settings.json` - Configuración de proyecto Java para VS Code (opcional).

## Contenido y responsabilidad de cada archivo

- `src/App.java`:
  - Lee `src/peliculas.csv` (salta la cabecera) y carga `Pelicula` en una lista.
  - Genera listas de ejemplo de `Pedido` y `Participante`.
  - Presenta un menú con las siguientes opciones:
    1. Mostrar películas
    2. Mostrar resumen de películas (total, película más larga, número de ciencia ficción)
    3. Mostrar pedidos
    4. Mostrar participantes
    5. Salir

- `src/net/salesianos/pelicula/Pelicula.java`:
  - Clase simple con constructor, getters/setters y `toString()` para visualización en consola.

- `src/net/salesianos/pedido/Pedido.java`:
  - Clase con constructor y `toString()`; se puede ampliar con `equals`/`hashCode` si se requiere manejo en colecciones.

- `src/net/salesianos/participante/Participante.java`:
  - Clase con `equals` y `hashCode` ya implementados en el ejemplo.

## Formato del CSV

El fichero `src/peliculas.csv` debe tener una cabecera y filas con tres campos separados por comas:

```
titulo,genero,duracionMinutos
Interstellar,Ciencia ficción,169
Shrek,Animación,90
Gladiator,Acción,155
```
