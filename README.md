# Proyecto de Gestión de Rutinas de Gimnasio

Este proyecto es una aplicación RESTful desarrollada en Java utilizando Spring Boot. Su objetivo es gestionar rutinas de gimnasio, registrando datos de socios, pesos y rutinas asignadas.

## Tecnologías Implementadas

- **Java**: Lenguaje de programación principal.
- **Spring Boot**: Framework para el desarrollo de aplicaciones RESTful.
- **Gradle**: Herramienta de construcción utilizada para la gestión de dependencias y configuración del proyecto.
- **Lombok**: Biblioteca para reducir el boilerplate en el código.

## Integrantes del Proyecto

| Nombre           | Email                   |
|------------------|-------------------------|
| Agustín Yáñez    | agyanez@uade.edu.ar     |
| Lucas Ballesta   | lballesta@uade.edu.ar   |

## Endpoints de la API

A continuación, se presenta la lista de endpoints de la API. Estos proporcionan acceso a las distintas funcionalidades de la aplicación.

### Socios

- **POST /api/socios**
  - **Descripción**: Crea un nuevo socio.
  - **Ejemplo de solicitud**:
    ```bash
    curl --location 'http://localhost:8080/api/gym/socio' \
    --header 'Content-Type: application/json' \
    --data-raw '{
      "pass": "123",
      "email": "agus@hotmail.com",
      "sexo": "MASCULINO",
      "peso": 71,
      "altura": 176.5,
      "nivelAerobico": 10,
      "nombre": "agus",
      "edad": 30
    }'
    ```

- **POST /api/socios/login**
  - **Descripción**: Inicia sesión de un socio.
  - **Ejemplo de solicitud**:
    ```bash
    curl --location 'http://localhost:8080/api/gym/socio/login' \
    --header 'Content-Type: application/json' \
    --data-raw '{
      "pass": "12",
      "email": "agus@hotmail.com"
    }'
    ```

### Pesos

- **POST /api/pesos**
  - **Descripción**: Registra el peso de un socio en una fecha específica.
  - **Ejemplo de solicitud**:
    ```bash
    curl --location 'http://localhost:8080/api/gym/socio/peso' \
    --header 'socio-id: 234sas-addas45-dsd' \
    --header 'Content-Type: application/json' \
    --data '{
      "masa_muscular": 12,
      "porcentaje_grasa_corporal": 10,
      "peso": 10
    }'
    ```

### Rutinas

- **GET /api/rutinas/{socioId}**
  - **Descripción**: Obtiene la rutina asignada a un socio específico.
  - **Ejemplo de solicitud**:
    ```bash
    curl -X GET http://localhost:8080/api/rutinas/1
    ```

> **Nota**: Asegúrate de que la aplicación esté ejecutándose en `localhost` en el puerto `8080` antes de realizar las solicitudes.

## Casos de Pruebas

A continuación, se muestran algunos ejemplos de pruebas que pueden realizarse para verificar el funcionamiento de los endpoints de la aplicación utilizando `curl`.

### 1. Creación de Socio

```bash
curl -X POST http://localhost:8080/api/socios -H "Content-Type: application/json" -d '{
  "nombre": "Juan Perez",
  "email": "juan@example.com",
  "password": "password123"
}'
