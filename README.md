# Todo App

A fullstack Todo application built with **Java, Spring Boot, JPA, H2 Database, HTML, CSS and JavaScript**.

The project was developed step by step to learn and demonstrate REST API development, database integration, CRUD operations, service-layer architecture, DTOs, testing and frontend integration.

## Features

* Create new Todos
* View all Todos
* Update Todos
* Mark Todos as completed
* Undo completed Todos
* Delete Todos
* REST API
* H2 database
* DTO-based API communication
* Service Layer architecture
* HTML/CSS/JavaScript frontend
* Frontend communication using the JavaScript Fetch API
* Error handling for missing Todos
* HTTP status code handling

## Technologies

### Backend

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* H2 Database
* Maven
* REST API

### Frontend

* HTML5
* CSS3
* JavaScript
* Fetch API

### Testing

* IntelliJ IDEA HTTP Client
* REST API testing
* CRUD testing
* Error handling testing

## Architecture

The backend follows a layered structure:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

DTOs are used to separate API data from the database entity.

## REST API

| Method | Endpoint      | Description       |
| ------ | ------------- | ----------------- |
| GET    | `/todos`      | Get all Todos     |
| POST   | `/todos`      | Create a new Todo |
| PUT    | `/todos/{id}` | Update a Todo     |
| DELETE | `/todos/{id}` | Delete a Todo     |

## Example Request

### Create a Todo

```http
POST /todos
Content-Type: application/json
```

```json
{
    "title": "Learn Java",
    "completed": false
}
```

### Example Response

```json
{
    "id": 1,
    "title": "Learn Java",
    "completed": false
}
```

## Frontend

The frontend provides a simple user interface where users can:

* Add a Todo
* View Todos
* Complete a Todo
* Undo a completed Todo
* Delete a Todo

The frontend communicates directly with the Spring Boot REST API.

## Project Structure

```text
TodoApp
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.TodoApp
│   │   │       ├── controller
│   │   │       ├── service
│   │   │       ├── repository
│   │   │       ├── model
│   │   │       ├── dto
│   │   │       └── exception
│   │   │
│   │   └── resources
│   │       ├── static
│   │       │   ├── index.html
│   │       │   ├── script.js
│   │       │   └── style.css
│   │       └── application.properties
│   │
│   └── test
│
├── pom.xml
└── README.md
```

## How to Run

### 1. Clone the repository

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

### 2. Open the project

Open the project in IntelliJ IDEA.

### 3. Run the application

Run the Spring Boot application.

The application will start on:

```text
http://localhost:8080
```

### 4. Open the frontend

Open:

```text
http://localhost:8080
```

## Testing

The REST API has been tested using IntelliJ IDEA HTTP Client.

The following operations have been tested:

* POST – Create Todo
* GET – Retrieve Todos
* PUT – Update Todo
* DELETE – Delete Todo
* GET after DELETE
* PUT with a non-existing ID
* Invalid requests

The API correctly handles successful requests and errors such as **404 Not Found**.

## Development Progress

The project was developed incrementally, starting with a basic Spring Boot REST API and gradually adding:

1. Todo entity
2. Repository
3. CRUD operations
4. Error handling
5. Validation
6. HTTP status codes
7. API structure
8. Service Layer
9. DTO
10. REST API testing
11. Frontend
12. Todo UI

## Project Status

**Completed ✅**

The application currently provides a working fullstack Todo application with a Spring Boot REST API, H2 database and JavaScript frontend.

## Author

Java Fullstack Developer
