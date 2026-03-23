# Users API - Clean Architecture & Spring Boot

Esta solucion es una API REST construida con **Spring Boot 3.4.2**, diseñada bajo **Arquitectura Hexagonal** (Ports and Adapters). El sistema permite la gestión de usuarios (CRUD).
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

Aunque el proyecto soporta el **CRUD completo** (Create, Read, Update, Delete), el enfoque de validación en Postman y despliegue se centra en create y getAll

<img width="1292" height="537" alt="image" src="https://github.com/user-attachments/assets/bdd0586c-5549-4755-98f3-1325bcd11533" />


---

## 🧪 Testing y Calidad de Código
* **Unit Tests:** Implementados con **JUnit 5**. Los tests están funcionales y pasan todas las verificaciones de integridad del código.
* **Sonar:** Se utilizó **Sonar** para la verificación y análisis estático de código, garantizando estándares de mantenibilidad.
  **Jacoco**: Se implementa con el fin de aumentar la cobertura del código

---

## 🐳 Docker y Despliegue en Render

El proyecto está dockerizado y se despliega en la nube utilizando **Render: https://dashboard.render.com**.

### Estrategia de Despliegue (Web Services)
Se han creado **dos Web Services independientes en Render** apuntando al mismo repositorio de GitHub. Esto permite ejecutar los ambientes de **DEV** y **PROD** simultáneamente en URLs y puertos aislados:

1.  **Web Service DEV:** Configurado con la variable de entorno `SPRING_PROFILES_ACTIVE=dev`.
2.  **Web Service PROD:** Configurado con la variable de entorno `SPRING_PROFILES_ACTIVE=prod`.

### Construcción y Ejecución Local:

**Build del Proyecto (Maven):**
Para compilar y ejecutar los tests (recomendado antes de cualquier push):
```bash
mvn clean install
