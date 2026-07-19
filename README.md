# Smart City Noise Monitoring System

Noise pollution monitoring system for smart cities, developed as an educational and practical project using Java, Spring Boot, and React.

---

## Dashboard Preview

![Dashboard Preview](./assets/dashboard-preview.png)

---

## Project Overview
The application simulates sound sensors distributed throughout the city, responsible for measuring environmental noise levels.
When the decibel level exceeds a defined threshold, the system automatically records a noise infraction.

The project is inspired by an academic case study on smart cities, involving:
- urban monitoring
- sensor management
- environmental infraction control

---

## Technologies

### Backend
- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Swagger / OpenAPI
- Docker

### Frontend
- React
- Vite
- Recharts
- JavaScript

### Cloud & Deployment

- Render (Backend + PostgreSQL)
- Vercel (Frontend)
- Docker

---

## Architecture

The backend follows a layered architecture with clear separation of concerns:

- **Controller** → exposes REST endpoints and delegates to services
- **Service** → handles business logic, including noise reading processing and infraction detection
- **Repository** → data access layer using Spring Data JPA
- **Model** → JPA entities mapped to PostgreSQL tables
- **DTO** → dedicated response objects to decouple API contracts from internal models

A scheduled service (`SensorSimulationService`) runs every 10 seconds to simulate noise readings across all active sensors. When a reading exceeds the defined threshold (70 dB), an infraction is automatically recorded.

The frontend is organized into:

- **Components** → reusable UI elements (sensor list, chart, stat cards)
- **Custom Hooks** → polling logic and sensor data fetching
- **Visualization** → real-time noise chart built with Recharts

---

## Current Features

### Backend 

- RESTful API with layered architecture (Controller → Service → Repository)
- Automatic sensor simulation
- Noise reading processing
- Automatic noise infraction detection
- Historical tracking of sensor readings
- Aggregated statistics:
  - Total infractions
  - Average noise level
  - Maximum noise level
- Data persistence using PostgreSQL and JPA/Hibernate
- Global exception handling
- Logging with SLF4J
- API documentation with Swagger
- Dockerized deployment
- Cloud deployment with Render

---

### Frontend 

- Interactive dashboard
- Sensor list with real-time status (Normal / High Noise)
- Dynamic noise chart (Recharts)
- Sensor selection with live chart updates
- Integration with backend REST API
- Cloud deployment with Vercel

---

## API Endpoints

### Sensors

```http
GET /sensors
```

Returns all sensors and current noise levels.

```http
GET /sensors/{id}/history
```

Returns historical readings for a sensor.

---

### Infractions

```http
GET /infractions/stats
```

Returns aggregated statistics:

- total infractions
- average noise
- maximum noise

---

## Deployment

The project was successfully deployed to the cloud to validate the complete deployment workflow.

| Service | Platform |
|---|---|
| Frontend | Vercel |
| Backend | Render |
| Database | PostgreSQL (Render) |

> **Note:** The original deployment used free-tier services. The PostgreSQL database instance has since expired, so the live application is no longer available. The project can still be run locally by following the instructions below.

---

## Running the Project Locally

### Prerequisites
- Java 21
- Node.js
- PostgreSQL running locally

Create the database:
```sql
CREATE DATABASE smartcity;
```

Then, create the file:
`backend/smartcitynoisemonitoring/src/main/resources/application-dev.yml`

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/smartcity
    username: postgres
    password: YOUR_PASSWORD
```

### Backend

```bash
cd backend/smartcitynoisemonitoring
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```
### Frontend

```bash
cd frontend
npm install
npm run dev
```
