# 🗂️ TaskFlow - Full-Stack Task Management System

TaskFlow is a **full-stack Task Management System** built with a **Spring Boot** backend and a **React + TypeScript** frontend. It helps you organize your work efficiently with a modern, dark-mode interface.

You can create task lists, manage tasks, set priorities, track progress, and mark tasks as completed — all in one clean and structured application.

-----

## 🚀 Features

### 🔹 Backend Features (Spring Boot)

* Create, update, delete, and view task lists.
* Automatically calculates task list progress based on completed tasks.
* Add, update, and delete tasks within a specific list.
* Set task status (`OPEN`, `CLOSED`) and priority levels (`LOW`, `MEDIUM`, `HIGH`).
* Built using **Spring Boot 3** with **JPA/Hibernate** for database interaction.
* Clean **Service–Repository–Controller** architecture.
* **DTO–Entity mapping** using Mapper classes.

### 🔹 Frontend Features (React)

* **Modern Dark-Mode UI:** A professional, responsive, and interactive dark theme.
* **Full-Stack CRUD:** All operations for both Task Lists and Tasks are implemented.
* **Interactive Modals:** All forms (Create, Update) and confirmations (Delete) use stylish, modern popups.
* **Dynamic Progress Bars:** Real-time progress updates on the homepage.
* **Inline Validation:** User-friendly form validation without disruptive alerts.
* **Component-Based:** Built with reusable, styled components (Buttons, Modals, Forms) using **Tailwind CSS**.

-----

## 🧩 Tech Stack

### Backend

| Layer             | Technology      |
|-------------------|-----------------|
| Backend Framework | Spring Boot     |
| Language          | Java 17+        |
| Database          | MySQL           |
| ORM               | Spring Data JPA |
| Build Tool        | Maven           |

### Frontend

| Layer      | Technology                |
|------------|---------------------------|
| Framework  | React (Vite + TypeScript) |
| Styling    | Tailwind CSS              |
| API Client | Axios                     |
| Routing    | React Router DOM          |
| Build Tool | npm / Vite                |

-----

## 🏗️ Project Structure

This project consists of two separate applications: the backend API and the frontend client.

### Backend (TaskFlow)

```
TaskFlow/
┣ src/
┃ ┣ main/java/com/taskflow/
┃ ┃ ┣ controller/      → REST Controllers
┃ ┃ ┣ dto/             → Data Transfer Objects
┃ ┃ ┣ entity/          → JPA Entities
┃ ┃ ┣ mapper/          → Entity-DTO Mappers
┃ ┃ ┣ repository/      → JPA Repositories
┃ ┃ ┗ service/impl/    → Business Logic Layer
┃ ┗ resources/
┃   ┣ application.properties → Configuration
┣ pom.xml
┗ README.md
```

### Frontend (taskflow-frontend)

```
taskflow-frontend/
┣ src/
┃ ┣ api/             → Axios API client setup
┃ ┣ components/      → Reusable React components (Modal, Button, Forms...)
┃ ┣ pages/           → Main page components (HomePage, TaskListDetailsPage)
┃ ┣ services/        → API service functions (taskService, taskListService)
┃ ┣ types/           → TypeScript type definitions
┃ ┣ App.tsx          → Main app router
┃ ┣ main.tsx         → React entry point
┃ ┗ index.css        → Tailwind CSS global styles
┣ tailwind.config.js → Tailwind configuration
┗ vite.config.ts     → Vite configuration (with proxy)
```

-----

## ⚙️ How to Set Up and Run This Project

You must run **both** the backend and frontend applications simultaneously.

### 🧾 Prerequisites

* Java 17+
* Maven 3.8+
* Node.js (v18 or higher recommended)
* A MySQL database server

-----

### 1\. Backend Setup (Spring Boot)

1.  **Clone the backend repository** (or navigate to its folder):
    ```bash
    git clone https://github.com/anis-mansuri-07/TaskFlow.git
    cd TaskFlow
    ```
2.  **Configure Database:**
    * Open `src/main/resources/application.properties`.
    * Update `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` to match your local MySQL setup.
    * Ensure you have a database created (e.g., `CREATE DATABASE taskflow_db;`).
3.  **Build the project:**
    ```bash
    mvn clean install
    ```
4.  **Run the backend:**
    ```bash
    mvn spring-boot:run
    ```

✅ The backend API is now running on **http://localhost:8080**.

-----

### 2\. Frontend Setup (React + Vite)
* [Click Here For Front - End](https://github.com/anis-mansuri-07/TaskFlow-FrontEnd)
-----

## 🔧 Backend API Endpoints

### 📋 Task List APIs

| Method   | Endpoint               | Description               |
|----------|------------------------|---------------------------|
| `GET`    | `/api/task-lists`      | Get all task lists        |
| `GET`    | `/api/task-lists/{id}` | Get task list by ID       |
| `POST`   | `/api/task-lists`      | Create new task list      |
| `PUT`    | `/api/task-lists/{id}` | Update existing task list |
| `DELETE` | `/api/task-lists/{id}` | Delete task list          |

### 🧠 Task APIs

| Method   | Endpoint                              | Description                |
|----------|---------------------------------------|----------------------------|
| `GET`    | `/api/task-lists/{id}/tasks`          | Get all tasks for a list   |
| `GET`    | `/api/task-lists/{id}/tasks/{taskId}` | Get specific task          |
| `POST`   | `/api/task-lists/{id}/tasks`          | Create new task under list |
| `PUT`    | `/api/task-lists/{id}/tasks/{taskId}` | Update task                |
| `DELETE` | `/api/task-lists/{id}/tasks/{taskId}` | Delete task                |

-----

## 🧪 Example JSON (for Postman Testing)

### Create Task List

```json
{
  "title": "Project Setup",
  "description": "Initial setup for the new project"
}
```

### Create Task

```json
{
  "title": "Configure Spring Boot",
  "description": "Setup dependencies and configurations",
  "priority": "HIGH",
  "status": "OPEN"
}
```

-----

## 🧱 Future Enhancements

* Add user authentication (JWT)
* Add sorting and filtering for tasks
* Implement drag-and-drop for task reordering
* Add user profiles and avatars

-----

## 🧑‍💻 Author

**Mahammedanis Mansuri**

* 🎓 MCA Student | 💻 Java & Spring Developer
* 📧 [[anishmansuri269@gmail.com](mailto:anishmansuri269@gmail.com)]
* 💻 [GitHub Profile](https://github.com/anis-mansuri-07)
* 🔗 [Connect with me on LinkedIn](https://www.linkedin.com/in/anis-mansuri-57b97a25a)