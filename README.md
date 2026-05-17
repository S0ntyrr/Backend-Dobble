# Backend-Dobble — Backend con Node.js y Spring Boot + PostgreSQL (Docker)

Este repositorio agrupa dos implementaciones de backend (una en **Node.js/Express** y otra en **Spring Boot**) y un entorno de ejecución con **Docker Compose**, apuntando a una base de datos **PostgreSQL**.

## Estructura
- `docker-compose.yml`: orquesta contenedores (BD + servicios).
- `node-app/`: backend Node.js (Express + Sequelize + PostgreSQL).
  - `package.json`: scripts `start` y `dev` (nodemon).
  - `src/index.js`: punto de entrada.
- `springboot-app/`: backend Java (Spring Boot 3.x + JPA).
  - `pom.xml`: Java 17, dependencias web + data-jpa + PostgreSQL.
  - `src/`: código fuente.
- `postman_collection.json`: colección para probar endpoints.
- `.env`: variables de entorno (recomendado no versionar).

## Tecnologías
### Node
- Express
- Sequelize
- pg (PostgreSQL)
- dotenv
- nodemon (dev)

### Spring Boot
- Spring Boot 3.1.x
- Spring Web
- Spring Data JPA
- PostgreSQL Driver
- Java 17

## Uso con Docker (recomendado)
En la raíz del repo:

```bash
docker compose up --build
```

## Uso local (alternativo)
### Node
```bash
cd node-app
npm install
npm run dev
```

### Spring Boot
```bash
cd springboot-app
mvn spring-boot:run
```

## Notas
- Revisa/ajusta variables de entorno (conexión a BD, puertos, etc.).
- Si vas a compartir el repo, usa `.env.example` en lugar de `.env`.
