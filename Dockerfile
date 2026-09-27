FROM maven:3.9.9-eclipse-temurin-8 AS build
WORKDIR /app
# Dependencias primero para aprovechar cache
COPY pom.xml .
RUN mvn -DskipTests dependency:go-offline
# Código fuente
COPY src ./src
# Compilar
RUN mvn -DskipTests package

FROM eclipse-temurin:8-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]