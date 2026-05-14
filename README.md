![Titulo](Assets/TituloEmpresa.png)
# Evaluación 2

Proyecto desarrollado con Spring Boot y MySQL para la gestión de cervezas y marcas mediante una API REST.

El proyecto incluye integración con una API externa utilizando WebClient de Spring Boot para consumir frases aleatorias desde un servicio REST público.
---

# Integrantes

* Johaquin Fernandez
* Joaquin Cardenas
* Danilo Navarro

---

# Descripción del Proyecto

HomeroDoh API es una aplicación backend desarrollada con:

* Java 17
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* Lombok

El sistema permite administrar:

* Cervezas
* Marcas

Incluye operaciones CRUD completas, validaciones, manejo global de excepciones y uso de DTOs.

---

# Arquitectura del Proyecto

El proyecto está organizado utilizando arquitectura por capas:

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

---

# Tecnologías Utilizadas

| Tecnología      | Descripción                    |
| --------------- | ------------------------------ |
| Java 17         | Lenguaje principal             |
| Spring Boot     | Framework backend              |
| Spring Data JPA | Persistencia de datos          |
| MySQL           | Base de datos relacional       |
| Maven           | Gestión de dependencias        |
| Lombok          | Reducción de código repetitivo |
| Postman         | Pruebas de endpoints           |

---

# Base de Datos

Base de datos utilizada:

```txt
homerodoh
```

Tablas principales:

* cervezas
* marcas

---

# Endpoints Disponibles

## API Externa Quotes

| Método | Endpoint                   | Descripción                                      |

| ------ | -------------------------- | ------------------------------------------------ |

| GET    | /api/v1/quotes/random      | Obtener frase aleatoria desde API externa        |

## Cervezas

| Método | Endpoint              | Descripción                |
| ------ | --------------------- | -------------------------- |
| GET    | /api/v1/cervezas      | Listar cervezas            |
| GET    | /api/v1/cervezas/{id} | Buscar cerveza por ID      |
| POST   | /api/v1/cervezas      | Crear cerveza              |
| PUT    | /api/v1/cervezas/{id} | Actualizar cerveza         |
| DELETE | /api/v1/cervezas/{id} | Eliminar cerveza           |
| GET    | /api/v1/cervezas/dto  | Listar cervezas usando DTO |

---

## Marcas

| Método | Endpoint            | Descripción         |
| ------ | ------------------- | ------------------- |
| GET    | /api/v1/marcas      | Listar marcas       |
| GET    | /api/v1/marcas/{id} | Buscar marca por ID |
| POST   | /api/v1/marcas      | Crear marca         |
| PUT    | /api/v1/marcas/{id} | Actualizar marca    |
| DELETE | /api/v1/marcas/{id} | Eliminar marca      |

---

# Validaciones Implementadas

El proyecto incluye validaciones utilizando:

* `@Valid`
* `@NotBlank`
* `@NotNull`
* `@Positive`

Además, se implementó un manejo global de excepciones mediante:

```txt
GlobalExceptionHandler
```

---

# DTO Implementado

Se implementó el DTO:

```txt
CervezaDTO
```

para mostrar información simplificada de las cervezas:

```json
{
  "nombre": "Duff clásica",
  "precio": 1500,
  "nombreMarca": "Duff"
}
```

---

# Ejemplo de Request

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

## 1. Clonar repositorio en Visual Studio Code

```bash
git clone https://github.com/JojitaGamerHD/HomeroDoh
```

---

## 2. Correr MySQL en Laragon (o XAMPP)

Abrir HeidiSQL y conectarse a la base de datos:

---

## 3. Ejecutar proyecto

En homerodoh, buscar HomerodohApplication.java y run java.

---

# Pruebas en Postman

El proyecto incluye colección Postman para probar:

* GET
* POST
* PUT
* DELETE
* DTO
* Validaciones

---

# Características Implementadas

✅ CRUD completo

✅ Arquitectura por capas

✅ Relaciones JPA

✅ DTO

✅ Validaciones

✅ Manejo global de errores

✅ API REST

✅ MySQL

✅ Maven

---

# Conceptos Aplicados

* Spring Boot
* REST API
* JPA/Hibernate
* Relaciones OneToMany y ManyToOne
* DTO Pattern
* Validaciones
* Manejo de excepciones
* Arquitectura MVC

---

# Evaluación 2

Proyecto desarrollado para Evaluación 2 de Desarrollo Fullstack.
