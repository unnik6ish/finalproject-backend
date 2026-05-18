# Loan Application Backend

A RESTful API for a banking loan application portal, built with Spring Boot and secured with JWT authentication. Developed as a full-stack capstone project during the StackRoute Full Stack Developer training programme.

## Features

- User registration and login with JWT-based authentication
- Role-based access — customer and admin flows
- Loan application submission and management
- Spring Security configuration with custom JWT filter
- Global exception handling with meaningful error responses
- Dockerised for container-based deployment
- Unit tests at controller, service, and repository layers (TestNG)

## Tech stack

| Layer | Technology |
|---|---|
| Language | Java |
| Framework | Spring Boot |
| Security | Spring Security + JWT |
| Database | MySQL |
| Build tool | Maven |
| Testing | TestNG |
| Deployment | Docker |

## Project structure

```
src/main/java/com/example/demo/
├── controller/         # REST endpoints (Users, LoanDetails)
├── service/            # Business logic (interface + implementation)
├── repository/         # Spring Data JPA repositories
├── model/              # Entity classes (Users, LoanDetails, JWT models)
├── filter/             # JWT request filter
├── SecurityConfig/     # Spring Security configuration
├── util/               # JWT utility (token generation & validation)
└── exception/          # Global exception handler + custom exceptions
```

## API endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/register` | Register a new user |
| POST | `/authenticate` | Login and receive JWT token |
| GET | `/users` | Get all users (admin) |
| POST | `/loan` | Submit a loan application |
| GET | `/loan` | Get all loan applications (admin) |

## Getting started

### Prerequisites
- Java 11+
- Maven 3.6+
- MySQL 8+

### Run locally

```bash
# Clone the repo
git clone https://github.com/unnik6ish/finalproject-backend.git
cd finalproject-backend/finalproject-backend-master

# Configure your database in
# src/main/resources/application.properties

# Build and run
./mvnw spring-boot:run
```

The API will start on `http://localhost:8080`

### Run with Docker

```bash
docker build -t loan-app-backend .
docker run -p 8080:8080 loan-app-backend
```

### Run tests

```bash
./mvnw test
```

## Frontend

The React frontend for this project is available at:
[github.com/unnik6ish/finalproject-frontend](https://github.com/unnik6ish/finalproject-frontend)

## Author

Unnikrishnan 
[github.com/unnik6ish](https://github.com/unnik6ish)
