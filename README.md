# API REST - Teclados

Proyecto final de Ingeniería de Software: API REST básica con Docker.

## Estructura del proyecto

El proyecto consta de dos elementos principales:

- Carpeta `tecladosapi`

- Archivo `docker-compose.yml`

En la carpeta `tecladosapi` se encuentra el código fuente de la API REST, que incluye:
- Entidades
- Repositorios
- Controladores
- Excepciones
- Servicios

El archivo `docker-compose.yml` permite levantar el proyecto mediante Docker.

### Cómo levantar el proyecto en docker

- clone el repositorio:

	`git clone https://github.com/jesus24e/teclados-api.git proyectoapiteclados`

- genere el distribuible ( .jar ) desde la carpeta del proyecto

	- `cd proyectoapiteclados\tecladosapi`

	- `mvn clean package`

- levante los contenedores en docker

	`docker compose up`

- acceda al api rest

	`http://localhost:8081/api/v1/teclados/`

### pruebas de funcionalidad del api-rest con postman:

- `GET http://localhost:8081/api/v1/teclados/` – Obtener todos los teclados

- `GET http://localhost:8081/api/v1/teclados/1` – Obtener teclado por ID

- `POST http://localhost:8081/api/v1/teclados/` – Crear nuevo teclado

- `PUT http://localhost:8081/api/v1/teclados/1` – editar teclado

- `PATCH http://localhost:8081/api/v1/teclados/1` – Actualización parcial

- `DELETE http://localhost:8081/api/v1/teclados/1` – Eliminar teclado
