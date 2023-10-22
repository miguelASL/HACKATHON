# 🎮 API de Skins para Videojuegos 🎮

¡Bienvenido a la API de Skins para videojuegos! Esta API te permite consultar, adquirir, modificar y eliminar skins para tus juegos favoritos. 🚀

## Descripción del Proyecto

Este proyecto tiene como objetivo crear una API que gestiona las skins de videojuegos. Los usuarios pueden consultar las skins disponibles, adquirirlas, modificar su color y eliminarlas de su colección. La información de las skins se almacena en una base de datos.

## Requisitos

Antes de comenzar, asegúrate de tener lo siguiente:

1. Estructura de Datos de Skin: Define la estructura de datos que representará las skins, incluyendo campos como id, nombre, tipo, precio, color, etc.
2. Lectura de Skins desde un Archivo: Implementa una función para leer las skins disponibles desde un archivo, como JSON.
3. Base de Datos: Configura una conexión a una base de datos (MySQL) para almacenar las skins adquiridas por los usuarios.
4. Rutas de la API:

    - GET /skins/available: Devuelve una lista de todas las skins disponibles para comprar.
    - POST /skins/buy: Permite a los usuarios adquirir una skin y la guarda en la base de datos.
    - GET /skins/myskins: Devuelve una lista de las skins compradas por el usuario.
    - PUT /skins/color/{id}: Permite a los usuarios cambiar el color de una skin comprada.
    - DELETE /skins/delete/{id}: Permite a los usuarios eliminar una skin comprada.
    - GET /skin/getskin/{id}: Devuelve una skin específica por su ID.

## Requisitos Técnicos y Evaluación

Nuestro proyecto cumple con los siguientes requisitos técnicos y criterios de evaluación:

- **Cumplimiento de Requisitos Funcionales:** La aplicación cumple con los requisitos funcionales especificados, brindando a los usuarios la funcionalidad completa para gestionar sus skins de videojuegos.

- **Buena Prácticas de Programación:** El código sigue buenas prácticas de programación, incluyendo la organización de código, nomenclatura clara y comentarios informativos.

- **Patrón Estructural:** El proyecto sigue un patrón estructural sólido que facilita la comprensión y el mantenimiento del código.

- **Funciones Responsables:** Las funciones en el proyecto tienen una única responsabilidad, lo que mejora la legibilidad y el mantenimiento del código.

- **Escalabilidad y Reutilización:** El código está diseñado para ser escalable y reutilizable, permitiendo futuras expansiones y actualizaciones.

- **Optimización y Eficiencia:** El código está optimizado para un rendimiento eficiente, minimizando la carga y la latencia en las operaciones de la API.

## Cómo Descargar el Proyecto

Si deseas descargar este proyecto para explorarlo o contribuir, sigue estos pasos:

1. Abre el repositorio en GitHub: (https://github.com/miguelASL/HACKATHON)

2. En la esquina superior derecha, verás un botón verde que dice "Code". Haz clic en ese botón.

3. Selecciona una de las opciones para descargar el proyecto:
    - **Descargar ZIP:** Si prefieres descargar un archivo ZIP del proyecto, selecciona esta opción y descomprímelo en tu máquina.
    - **Clonar el Repositorio:** Si tienes Git instalado, puedes copiar la URL del repositorio y ejecutar el siguiente comando en tu terminal:
      ```
      git clone https://github.com/miguelASL/HACKATHON.git
      ```

4. ¡Listo! Ahora tienes el proyecto en tu máquina y puedes empezar a explorarlo.

## Contacto

- Autor: MIguel Ángel Sarmiento Levy
- Email: capitanmigue@hotmail.com
- Proyecto: https://github.com/miguelASL/HACKATHON-.git
