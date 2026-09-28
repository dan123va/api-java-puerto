# Liverpool API

API REST para administrar usuarios y pedidos, desarrollada con Java 8, Spring Boot 2.7 y MongoDB.

## Requisitos

Para la ejecución recomendada necesitas:

- Docker Desktop.
- Docker Compose.

Para ejecutar la API sin Docker también necesitas Java 8 y Maven.

## Levantar el backend con Docker

Desde esta carpeta ejecuta:

```powershell
docker compose up --build
```

Docker construye la API, inicia MongoDB y espera a que la base de datos esté disponible. La API queda publicada en:

```text
http://localhost:8080
```

En el primer arranque se insertan usuarios y pedidos de demostración si la base de datos está vacía.

## Variables de entorno

El contenedor configura automáticamente estas variables:

```properties
MONGODB_URI=mongodb://mongo:27017/liverpool_orders
APP_CORS_ALLOWED_ORIGINS=http://localhost:3000
```

Si ejecutas la API fuera de Docker, define `MONGODB_URI` con la dirección de tu instancia de MongoDB.

## Ejecutar sin Docker

Con MongoDB disponible y las variables de entorno configuradas:

```powershell
mvn spring-boot:run
```

## Endpoints y documentación

- Pedidos: http://localhost:8080/api/orders
- Usuarios: http://localhost:8080/api/user
- Swagger UI: http://localhost:8080/swagger-ui.html
- OpenAPI JSON: http://localhost:8080/v3/api-docs
- OpenAPI YAML: http://localhost:8080/v3/api-docs.yaml

Swagger permite consultar y probar los endpoints desde el navegador.

## Pruebas

```powershell
mvn test
```

## Detener el backend

```powershell
docker compose down
```

Los datos permanecen almacenados en el volumen de Docker. Para borrar la base de datos local y volver a cargar los datos iniciales:

```powershell
docker compose down -v
docker compose up --build
```

> `docker compose down -v` elimina permanentemente los datos almacenados en el volumen local de MongoDB.

## Solución de problemas

- Si la API no inicia, revisa los logs con `docker compose logs -f`.
- Si MongoDB no responde, comprueba que el puerto `27017` esté disponible.
- Si la API no responde, comprueba que el puerto `8080` esté disponible.
- Si el frontend es bloqueado por CORS, revisa `APP_CORS_ALLOWED_ORIGINS`.

La configuración y los pasos del cliente web están en `../liverpool-frontend/README.md`.
