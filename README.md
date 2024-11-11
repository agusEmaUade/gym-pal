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
  - **Descripción**: Registra el peso de un socio.
  - **Ejemplo de solicitud**:
    ```bash
    curl --location 'http://localhost:8080/api/gym/socio/peso' \
    --header 'socio-id: 13f9ec89-fc86-4edf-8bda-1d3d62418dff' \
    --header 'Content-Type: application/json' \
    --data '{
        "masa_muscular": 12,
        "porcentaje_grasa_corporal": 10,
        "peso": 10
    }'
    ```

### Objetivo

- **POST /api/objetivo/{objetivo}**
  - **Descripción**: Registra el objetivo de un socio.
  - **Ejemplo de solicitud**:
    ```bash
    curl --location --request POST 'http://localhost:8080/api/gym/socio/objetivo/bajarDePeso' \
    --header 'socio-id: 13f9ec89-fc86-4edf-8bda-1d3d62418dff'
    ```


> **Nota**: Asegúrate de que la aplicación esté ejecutándose en `localhost` en el puerto `8080` antes de realizar las solicitudes.

## Casos de Pruebas

A continuación, se muestran algunos ejemplos de pruebas que pueden realizarse para verificar el funcionamiento de los endpoints de la aplicación utilizando `curl`.

### 1. Creación de Socio

```bash
curl --location 'http://localhost:8080/api/gym/socio' \
--header 'Content-Type: application/json' \
--data-raw '{
    "pass":"123",
    "email":"agus@hotmail.com",
    "sexo": "MASCULINO",
    "peso": 71,
    "altura":176.5,
    "nivelAerobico": 10,
    "nombre": "agus",
    "edad": 30
}'
```

### 2. login de Socio

```bash
curl --location 'http://localhost:8080/api/gym/socio/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "pass":"123",
    "email":"agus@hotmail.com"
}'
```

### 3. login de Socio pass incorrecta

```bash
curl --location 'http://localhost:8080/api/gym/socio/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "pass":"3",
    "email":"agus@hotmail.com"
}'
```

### 4. Objetivo de socio

```bash
curl --location 'http://localhost:8080/api/gym/socio/peso' \
--header 'socio-id: 13f9ec89-fc86-4edf-8bda-1d3d62418dff' \
--header 'Content-Type: application/json' \
--data '{
    "masa_muscular":12,
    "porcentaje_grasa_corporal": 10,
    "peso": 10
}'
```
### 5. Registrar peso socio.

```bash
curl -X POST http://localhost:8080/api/socios -H "Content-Type: application/json" -d '{
  "nombre": "Juan Perez",
  "email": "juan@example.com",
  "password": "password123"
}'
```

## Justificacion de patrones

![image](https://github.com/user-attachments/assets/4d679cec-b4df-486b-8ae5-bb7f9680931b)

En este caso utilizamos un Adapter ya que la autentificacion especifica en el enunciado que es externo a la plataforma.

-----------------------------------------------------------------------------------------

![image](https://github.com/user-attachments/assets/0cd5bf5f-2861-4bfc-99cd-17752f11417f)

En este caso, utilizamos herencia en caso de que haya una actualizacion en el sistema y se quiera agregar un nuevo objetivo puede agregarse de manera sencilla sin tener que modificar codigo existente, solo agregar.

-----------------------------------------------------------------------------------------

![image](https://github.com/user-attachments/assets/2f1da863-e699-41a4-a25b-a3398fa94715)

En ese caso tambien se utilizo herencia por el mismo caso, si se quiere hacer una actualizacion el dia de mañana se pueden agregar torfeos. La diferencia en este caso es que esta asociado a notificador que luego envia una notificacion.

-----------------------------------------------------------------------------------------

![image](https://github.com/user-attachments/assets/02c3f77a-7935-40fa-bd2d-4c9aad9652ec)

Medicion posee un controller para setear los datos y el metodo de reforzar. 

-----------------------------------------------------------------------------------------

![image](https://github.com/user-attachments/assets/4af936a7-8dc3-4e10-a0a2-ff78077aa78b)

La clase socio posee un controller para crear usuario, autentificar y setear objetivo.

-----------------------------------------------------------------------------------------

![image](https://github.com/user-attachments/assets/a4c324d6-08d8-4499-bbdf-d9fe6f289f69)

Rutina, Entrenamiento y registro poseen un controller en conjunto para llevar a cabo sus metodos.  La clase rutina posee una lista de entrenamientos, que a su vez posee una lisa con los registros y ejercicios a llevar a cabo.





