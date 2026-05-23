![Titulo](Assets/TituloEmpresa.png)
# HomeroDoh API

API REST desarrollada con Spring Boot y MySQL para la gestión y comercialización de cervezas y marcas.

El proyecto implementa arquitectura por capas, persistencia con JPA/Hibernate, validaciones, manejo global de excepciones, logs estructurados y consumo de APIs externas mediante WebClient.

---

# Integrantes

- Johaquin Fernandez
- Joaquin Cardenas
- Danilo Navarro

---

# Descripción del Proyecto

HomeroDoh API es una aplicación backend desarrollada utilizando:

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- WebClient

El sistema permite administrar:

- Cervezas
- Marcas

Además, incluye integración con una API externa para obtener frases aleatorias usando WebClient.

---

# Arquitectura del Proyecto

El proyecto utiliza arquitectura por capas (CSR):

```txt
src/main/java/com/example/homerodoh
│
├── controller
├── service
├── repository
├── model
├── dto
├── exception
└── config
```

## Responsabilidades por capa

| Capa | Responsabilidad |
|---|---|
| Controller | Manejo de solicitudes HTTP REST |
| Service | Lógica de negocio |
| Repository | Acceso y persistencia de datos |
| Model | Entidades JPA |
| DTO | Transferencia segura de datos |
| Exception | Manejo global de errores |
| Config | Configuraciones generales |

---

# Tecnologías Utilizadas

| Tecnología | Descripción |
|---|---|
| Java 17 | Lenguaje principal |
| Spring Boot | Framework backend |
| Spring Data JPA | Persistencia de datos |
| Hibernate | ORM para entidades JPA |
| MySQL | Base de datos relacional |
| Maven | Gestión de dependencias |
| Lombok | Reducción de código repetitivo |
| WebClient | Consumo de APIs externas |
| Postman | Pruebas de endpoints REST |

---

# Base de Datos

## Base de datos utilizada

```txt
homerodoh
```

## Tablas principales

- cerveza
- marca

## Relaciones implementadas

- ManyToOne
- OneToMany

Ejemplo:

- Muchas cervezas pertenecen a una marca.

---

# Endpoints Disponibles

## API Externa Quotes

| Método | Endpoint | Descripción |
|---|---|---|
| GET | /api/v1/quotes/random | Obtener frase aleatoria desde API externa |

---

## Cervezas

| Método | Endpoint | Descripción |
|---|---|---|
| GET | /api/v1/cervezas | Listar cervezas |
| GET | /api/v1/cervezas/{id} | Buscar cerveza por ID |
| POST | /api/v1/cervezas | Crear cerveza |
| PUT | /api/v1/cervezas/{id} | Actualizar cerveza |
| DELETE | /api/v1/cervezas/{id} | Eliminar cerveza |
| GET | /api/v1/cervezas/dto | Listar cervezas usando DTO |

---

## Marcas

| Método | Endpoint | Descripción |
|---|---|---|
| GET | /api/v1/marcas | Listar marcas |
| GET | /api/v1/marcas/{id} | Buscar marca por ID |
| POST | /api/v1/marcas | Crear marca |
| PUT | /api/v1/marcas/{id} | Actualizar marca |
| DELETE | /api/v1/marcas/{id} | Eliminar marca |

---

# Validaciones Implementadas

El proyecto implementa validaciones utilizando Bean Validation (JSR 380):

- `@Valid`
- `@NotBlank`
- `@NotNull`
- `@Positive`

Ejemplo:

```java
@NotBlank(message = "El nombre es obligatorio")
```

---

# Manejo Global de Excepciones

Se implementó manejo centralizado de errores mediante:

```txt
GlobalExceptionHandler
```

Incluye:

- HTTP 400 → Bad Request
- HTTP 404 → Not Found
- HTTP 500 → Internal Server Error

Las respuestas retornan JSON estructurados.

Ejemplo:

```json
{
  "status": 404,
  "error": "Not Found",
  "message": "Cerveza no encontrada",
  "timestamp": "2026-05-21T21:30:00"
}
```

---

# DTO Implementado

Se implementó:

```txt
CervezaDTO
```

para exponer información simplificada y segura:

```json
{
  "nombre": "Duff clásica",
  "precio": 1500,
  "nombreMarca": "Duff"
}
```

---

# 📡 Consumo de API Externa

El proyecto consume la API pública:

```txt
https://dummyjson.com/quotes/random
```

mediante:

```txt
WebClient
```

Características implementadas:

- Timeout
- Manejo de errores
- Logs estructurados
- Fallback response

---

# Ejemplos de Requests

## Crear Marca

```http
POST /api/v1/marcas
```

```json
{
  "nombre": "Duff",
  "pais": "USA"
}
```

---

## Crear Cerveza

```http
POST /api/v1/cervezas
```

```json
{
  "nombre": "Duff clásica",
  "precio": 1500,
  "tipo": "Lager",
  "marca": {
    "id": 1
  }
}
```

---

# Cómo Ejecutar el Proyecto

## 1. Clonar repositorio

```bash
git clone https://github.com/JojitaGamerHD/HomeroDoh
```

---

## 2. Abrir proyecto

Abrir el proyecto en:

- IntelliJ IDEA
o
- Visual Studio Code

---

## 3. Configurar MySQL

Crear base de datos (ya está creada asi que solo ejecutar laragon y luego HeidiSQL):

```sql
CREATE DATABASE homerodoh;
```

---

## 4. Configurar application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/homerodoh
spring.datasource.username=root
spring.datasource.password=
```

---

## 5. Ejecutar proyecto

Ejecutar:

```txt
HomerodohApplication.java
```

---

# Pruebas REST

Las pruebas fueron realizadas utilizando:

- Postman

Endpoints probados:

- GET
- POST
- PUT
- DELETE
- DTO
- Validaciones
- Manejo de errores
- API externa

---

# Características Implementadas

✅ CRUD completo

✅ Arquitectura CSR

✅ Spring Data JPA

✅ Hibernate

✅ Relaciones JPA

✅ DTO Pattern

✅ Validaciones JSR 380

✅ Manejo global de excepciones

✅ ResponseEntity

✅ Logs estructurados

✅ API REST

✅ MySQL

✅ Maven

✅ WebClient

✅ Consumo de API externa

✅ Timeout y fallback

---

# Conceptos Aplicados

- Spring Boot
- REST API
- JPA/Hibernate
- Arquitectura por capas
- DTO Pattern
- Bean Validation
- Global Exception Handler
- Logging con SLF4J
- WebClient
- Relaciones OneToMany y ManyToOne
- Persistencia relacional

---

# Evaluación 2

Proyecto desarrollado para la Evaluación 2 de Desarrollo Fullstack.
