# Todo App
This Todo application provides users with the ability to manage their tasks efficiently. Users can create, read, update, and delete tasks through a set of RESTful endpoints. The application ensures data security by authenticating users and restricting access to their own tasks only.

## Features
- Create, read, update, and delete tasks
- Mark tasks as completed or incomplete
- Retrieve all tasks or specific task details
- Simple and intuitive RESTful API

## Endpoints

- `GET /todo`: Retrieve all tasks for the authenticated user.
- `GET /todo/{id}`: Retrieve details of a specific task.
- `POST /todo`: Create a new task.
- `PUT /todo/{id}`: Update details of an existing task.
- `DELETE /todo/{id}`: Delete a task.
- `PUT /todo/{id}/complete`: Mark a task as completed.
- `PUT /todo/{id}/incomplete`: Mark a task as incomplete.

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- Apache Maven
- MySQL
- Git
