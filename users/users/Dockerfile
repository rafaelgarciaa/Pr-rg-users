# --- Etapa 1: Compilación ---
# Usamos una imagen de Maven oficial que ya tiene Java 21
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app

# 1. Copiamos el archivo de configuración de dependencias
COPY pom.xml .

# 2. Descargamos las dependencias (esto acelera futuros despliegues)
RUN mvn dependency:go-offline

# 3. Copiamos el código fuente y compilamos
# Usamos 'mvn' directamente en lugar de './mvnw'
COPY src ./src
RUN mvn clean package -DskipTests

# --- Etapa 2: Ejecución ---
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copiamos el JAR generado desde la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto estándar
EXPOSE 8080

# Comando para arrancar. IMPORTANTE: Usamos la variable $PORT de Render
ENTRYPOINT ["java", "-Dserver.port=${PORT:8080}", "-jar", "app.jar"]