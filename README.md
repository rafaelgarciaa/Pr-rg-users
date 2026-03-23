# Users API - Clean Architecture & Spring Boot

Esta solucion es una API REST construida con **Spring Boot 3.4.2**, diseñada bajo el **Estilo de Arquitectura Hexagonal** (Ports and Adapters). El sistema permite la gestión de usuarios (CRUD) mediante persistencia en base de datos H2.

## 🚀 Tecnologías y Versiones
* **Java:** 21 (Amazon Corretto / Temurin)
* **Framework:** Spring Boot 3.4.2
* **Gestor de Dependencias:** Maven
* **Base de Datos:** H2 (In-Memory para DEV / File-Based para PROD)
* **Librerías Principales:**
    * Spring Data JPA (Persistencia)
    * Lombok (Productividad)
    * Jacoco (Reporte de cobertura de tests)
    * JUnit 5 (Testing con Junit)

---

## 🏛️ Arquitectura Hexagonal
El proyecto utiliza una arquitectura de capas para desacoplar la lógica de negocio de la infraestructura:
* **Domain:** Modelos de negocio y reglas principales.
* **Application:** Casos de uso y servicios que orquestan la lógica.
* **Infrastructure:** Adaptadores de entrada (REST Controllers) y salida (Repositories, H2, Docker).

---

## ⚙️ Configuración de Ambientes (Application Properties)

El proyecto utiliza perfiles de Spring para manejar múltiples entornos. Aquí los ejemplos clave:

| Propiedad | General (Default) | Dev (`application-dev`) | Prod (`application-prod`) |
| :--- | :--- | :--- | :--- |
| **Puerto** | `8080` | `10000` | `9090` |
| **Nombre App** | `users-api` | `customers-dev` | `customers-prod` |
| **Log Message** | `Starting...` | `Ejecutando en DEV` | `Ejecutando en PROD` |
| **DB (H2)** | `mem:testdb` | `mem:devdb` | `file:/data/proddb` |

---

## 🛣️ Endpoints Principales (REST API)

A continuación se detallan los ejemplos de uso de la API mediante comandos `curl`. El proyecto soporta el CRUD completo centrado en la entidad `customers`:
<img width="1299" height="517" alt="image" src="https://github.com/user-attachments/assets/8c8d6d1a-6da8-4da1-8efb-e8434879759d" />

### 1. Listar todos los clientes
Obtiene la lista completa de clientes registrados.
```bash
curl --location 'http://localhost:8080/api/customers'
