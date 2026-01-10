# Smart City Noise Monitoring System

Noise pollution monitoring system for smart cities, developed as an educational and practical project using Java, Spring Boot, and React.

## Context
The application simulates sound sensors distributed throughout the city, responsible for measuring environmental noise levels.
When the decibel level exceeds a defined threshold, the system automatically records a noise infraction.

The project is inspired by an academic case study on smart cities, involving:
- urban monitoring
- sensor management
- environmental infraction control

## Technologies
- Java 17+
- Spring Boot
- Maven
- REST API
- PostgreSQL
- (Coming soon) React


## Architecture
The system follows a layered architecture:

- **Controller** → handles HTTP requests
- **Service** → business logic (e.g., infraction generation)
- **Model** → domain entities (Sensor, Infraction)
- **Repository** → data persistence (under development)

## Current Features
- Spring Boot REST API
- Processing of sensor readings
- Automatic generation of noise infractions
- Endpoints for testing via browser

## Roadmap
- Data persistence
- React Frontend
- Reports and heatmaps
- Authentication and user management
