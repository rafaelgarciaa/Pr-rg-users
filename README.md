# Users API - Clean Architecture & Spring Boot

Esta solucion es una API REST construida con **Spring Boot 3.4.2**, diseñada bajo el **Estilo de Arquitectura Hexagonal** (Ports and Adapters). El sistema permite la gestión de usuarios (CRUD) mediante persistencia en base de datos H2.

---

## 🏛️ Arquitectura Hexagonal
El proyecto utiliza una arquitectura de capas para desacoplar la lógica de negocio de la infraestructura:
* **Domain:** Modelos de negocio y reglas principales.
* **Application:** Casos de uso y servicios que orquestan la lógica.
* **Infrastructure:** Adaptadores de entrada (REST Controllers) y salida (Repositories, H2, Docker).

---

## 🚀 Tecnologias y Versiones
* **Java:** 21 (Amazon Corretto / Temurin)
* **Framework:** Spring Boot 3.4.2
* **Gestor de Dependencias:** Maven
* **Base de Datos:** H2 (In-Memory para DEV / File-Based para PROD)
* **Librerias Principales:**
    * Spring Data JPA (Persistencia)
    * Lombok (Productividad)
    * Jacoco (Reporte de cobertura de tests)
    * JUnit 5 (Testing con Junit)
    * Springdoc-openapi (Swagger UI)

---

## ⚙️ Configuracion de Ambientes (Application Properties)

El proyecto utiliza perfiles de Spring para manejar múltiples entornos. Aquí los ejemplos clave:

| Propiedad | General (Default) | Dev (`application-dev`) | Prod (`application-prod`) |
| :--- | :--- | :--- | :--- |
| **Puerto** | `8080` | `10000` | `9090` |
| **Nombre App** | `users-api` | `customers-dev` | `customers-prod` |
| **Log Message** | `Starting...` | `Ejecutando en DEV` | `Ejecutando en PROD` |
| **DB (H2)** | `mem:testdb` | `mem:devdb` | `file:/data/proddb` |

---

## 🛣️ Endpoints Principales (REST API)

El proyecto cuenta con documentacion interactiva a traves de **Swagger UI**. Una vez iniciada la aplicacion localmente, puede accederse en:
> **URL:** `http://localhost:8080/swagger-ui.html`

### Ejemplos de uso mediante comandos cURL:

#### 1. Listar todos los clientes
Obtiene la lista completa de clientes registrados.
```bash
curl --location 'http://localhost:8080/api/customers'
2. Crear un nuevo usuario
Registra un cliente enviando el cuerpo en formato JSON.

Bash
curl --location 'http://localhost:8080/api/customers' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Rafael",
    "email": "rafa@example.com"
}'
3. Obtener por ID
Recupera los detalles de un cliente específico pasando su ID en la URL.

Bash
curl --location 'http://localhost:8080/api/customers/1'
4. Eliminar un usuario
Borra un registro existente mediante su ID.

Bash
curl --location --request DELETE 'http://localhost:8080/api/customers/1'
🧪 Testing y Calidad de Codigo
Unit Tests: Implementados con JUnit 5. Los tests son funcionales y aseguran la integridad del codigo.

Sonar & Jacoco: Se utiliza Sonar para el analisis estatico y Jacoco para los reportes de cobertura de pruebas.

🐳 Docker y Despliegue en Render
El proyecto esta dockerizado y se despliega automaticamente en la nube utilizando Render.

🔗 Link de Despliegue: https://tu-app-en-render.onrender.com

Estrategia de Despliegue (Web Services)
Se han configurado dos Web Services independientes en Render apuntando al mismo repositorio de GitHub, permitiendo entornos aislados:

Entorno DEV: Configurado con la variable de entorno SPRING_PROFILES_ACTIVE=dev.

Entorno PROD: Configurado con la variable de entorno SPRING_PROFILES_ACTIVE=prod.

Instrucciones de Ejecucion Local
1. Construccion del Proyecto (Maven):
Para compilar y ejecutar los tests (recomendado antes de cualquier push):

Bash
mvn clean install
2. Ejecucion con Docker Compose:
Si deseas levantar la infraestructura completa localmente incluyendo la base de datos:

Bash
docker-compose up --build
3. Ejecucion Directa (Spring Boot):

Bash
mvn spring-boot:run
