# 🎮 API de Skins para Hackathon 🎮

¡Bienvenido a la API de Skins para la Hackathon! Esta API te permite consultar, adquirir, modificar y eliminar skins para tus juegos favoritos. 🚀

## Descripción del Proyecto

Este proyecto tiene como objetivo crear una API que gestiona las skins. Los usuarios pueden consultar las skins disponibles, adquirirlas, modificar su color y eliminarlas de su colección. La información de las skins se almacena en una base de datos.

### Cómo Utilizar la API

Para interactuar con la API, puedes seguir estos pasos:

1. **Consulta las Skins Disponibles**:
   - Utiliza la ruta `GET /skins/available` para obtener una lista de todas las skins disponibles para comprar.

2. **Adquiere una Skin**:
   - Utiliza la ruta `POST /skins/buy` para adquirir una skin y almacenarla en tu colección personal.
   
3. **Consultar tus Skins**:
   - Utiliza la ruta `GET /myskins` para obtener una lista de todas las skins que has adquirido.

4. **Modifica el Color de una Skin**:
   - Si deseas cambiar el color de una skin que has adquirido, utiliza la ruta `PUT /skins/color/{id}`.

5. **Elimina una Skin**:
   - Si ya no quieres una skin en tu colección, puedes eliminarla utilizando la ruta `DELETE /skins/delete/{id}`.

6. **Consulta Detalles de una Skin**:
   - Si deseas obtener información detallada sobre una skin específica, utiliza la ruta `GET /skin/getskin/{id}`.

## Requisitos

Antes de comenzar, asegúrate de tener lo siguiente:

1. **Estructura de Datos de Skin**: Define la estructura de datos que representará las skins, incluyendo campos como id, nombre, tipo, precio, color, etc.

2. **Lectura de Skins desde un Archivo**: Implementa una función para leer las skins disponibles desde un archivo, como JSON.

3. **Base de Datos**: Configura una conexión a una base de datos (MySQL) para almacenar las skins adquiridas por los usuarios.

4. **Tecnologías Requeridas**: Asegúrate de tener MySQL instalados en tu entorno de desarrollo.

## Requisitos Técnicos y Evaluación

Nuestro proyecto cumple con los siguientes requisitos técnicos y criterios de evaluación:

- **Cumplimiento de Requisitos Funcionales:** La aplicación cumple con los requisitos funcionales especificados, brindando a los usuarios la funcionalidad completa para gestionar sus skins de videojuegos.

- **Buena Prácticas de Programación:** El código sigue buenas prácticas de programación, incluyendo la organización de código, nomenclatura clara y comentarios informativos.

- **Patrón Estructural:** El proyecto sigue un patrón estructural sólido que facilita la comprensión y el mantenimiento del código.

- **Funciones Responsables:** Las funciones en el proyecto tienen una única responsabilidad, lo que mejora la legibilidad y el mantenimiento del código.

- **Escalabilidad y Reutilización:** El código está diseñado para ser escalable y reutilizable, permitiendo futuras expansiones y actualizaciones.

- **Optimización y Eficiencia:** El código está optimizado para un rendimiento eficiente, minimizando la carga y la latencia en las operaciones de la API.

## Cómo Usar la API en Local

Para utilizar la API en tu entorno de desarrollo local, sigue estos pasos:

1. **Clona el repositorio desde GitHub**:
   - Abre tu terminal y ejecuta el siguiente comando para clonar el repositorio de GitHub a tu máquina:`git clone https://github.com/miguelASL/HACKATHON.git`

2. **Accede al directorio del proyecto**:
- Navega al directorio del proyecto clonado:
`  cd HACKATHON`

3. **Instala las dependencias del proyecto**:
- Ejecuta el siguiente comando para instalar todas las dependencias necesarias:`npm install`

4. **Configura la base de datos**:
- Asegúrate de que tienes una base de datos MySQL configurada y en ejecución en tu máquina local. Debes modificar el archivo de configuración del proyecto para que coincida con la configuración de tu base de datos local.

- Busca un archivo de configuración que podría contener información sobre la base de datos, como credenciales de acceso y el nombre de la base de datos. Este archivo podría llamarse `config.js` o similar.

- Actualiza la información de configuración de la base de datos en el archivo.

5. **Inicia la aplicación**:
- Una vez que la base de datos esté configurada, puedes iniciar la aplicación con el siguiente comando:
`  npm start`

6. **Prueba la API localmente**:
- La API debería estar en funcionamiento en tu máquina local en la dirección `http://localhost:puerto`, donde "puerto" es el número de puerto configurado en la aplicación.

- Puedes utilizar herramientas como [Postman](https://www.postman.com/) o [curl](https://curl.se/) para realizar solicitudes a tu API y probar su funcionalidad.

## Contacto

- Autor: Miguel Ángel Sarmiento Levy
- Proyecto: [https://github.com/miguelASL/HACKATHON](https://github.com/miguelASL/HACKATHON)