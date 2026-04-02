# Smart City Noise Monitoring System

Noise pollution monitoring system for smart cities, developed as an educational and practical project using Java, Spring Boot, and React.

---

## Context
The application simulates sound sensors distributed throughout the city, responsible for measuring environmental noise levels.
When the decibel level exceeds a defined threshold, the system automatically records a noise infraction.

The project is inspired by an academic case study on smart cities, involving:
- urban monitoring
- sensor management
- environmental infraction control

---

## Technologies

### Backend
- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL

### Frontend
- React
- Vite
- Recharts

---

## Architecture
The system follows a layered architecture:

- **Controller** → handles HTTP requests
- **Service** → business logic 
- **Model** → domain entities (Sensor, Infraction)
- **Repository** → data persistence 
- **Database** → PostgreSQL for persistent storage 

- **Components** → Reusable UI elements
- **State Management** → Handles sensor selection and data updates  
- **API Integration** → Communicates with backend via REST endpoints  
- **Visualization Layer** → Displays data using charts (Recharts)  

---

## Current Features

### Backend 

- RESTful API with layered architecture (Controller → Service → Repository)
- Sensor management and noise reading processing
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

---

### Frontend 

- Interactive dashboard
- Sensor list with real-time status (Normal / High Noise)
- Dynamic noise chart (Recharts)
- Sensor selection with live chart updates
- Integration with backend REST API

---

## Roadmap
- Real-time updates (auto refresh / WebSockets)
- Sensor simulation
- UI/UX improvements
- Authentication and user roles
- Deployment (cloud + Docker)

---

## Running the Project

### Backend

```bash
cd backend
./mvnw spring-boot:run
```
### Frontend

```bash
cd frontend
npm install
npm run dev