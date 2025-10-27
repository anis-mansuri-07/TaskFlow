
# 🗂️ TaskFlow - Task Management System

TaskFlow is a **Spring Boot–based Task Management System** that helps you organize your work efficiently.  
You can create task lists, manage tasks, set priorities, track progress, and mark tasks as completed — all in one clean and structured API system.  

---

## 🚀 Features

### 🔹 Task List Management
- Create, update, delete, and view task lists
- Each task list shows progress (based on completed tasks)
- Validation for empty or duplicate task lists

### 🔹 Task Management
- Add tasks to a specific task list
- Update or delete tasks easily
- Set task status (`OPEN`, `CLOSED`)
- Define priority levels (`LOW`, `MEDIUM`, `HIGH`)
- Automatically track completion percentage for each task list

### 🔹 Backend Features
- Built using **Spring Boot 3**
- **JPA/Hibernate** for database interaction
- **DTO–Entity mapping** using Mapper classes
- Clean **Service–Repository–Controller** architecture
- Ready for integration with a **React frontend**

---

## 🧩 Tech Stack

| Layer | Technology |
|-------|-------------|
| Backend Framework | Spring Boot |
| Language | Java 17+ |
| Database | MySQL |
| ORM | Spring Data JPA |
| Build Tool | Maven |
| Frontend (optional) | React.js (for TaskFlow Frontend) |

---

## 🏗️ Project Structure

```

TaskFlow/
┣ src/
┃ ┣ main/
┃ ┃ ┣ java/com/taskflow/
┃ ┃ ┃ ┣ controller/      → REST Controllers
┃ ┃ ┃ ┣ dto/             → Data Transfer Objects
┃ ┃ ┃ ┣ entity/          → JPA Entities
┃ ┃ ┃ ┣ mapper/          → Entity-DTO Mappers
┃ ┃ ┃ ┣ repository/      → JPA Repositories
┃ ┃ ┃ ┗ service/impl/    → Business Logic Layer
┃ ┃ ┗ resources/
┃ ┃   ┣ application.properties → Configuration
┃ ┗ test/                 → Unit tests
┣ pom.xml
┗ README.md

````

---

## 🔧 API Endpoints

### 📋 Task List APIs
| Method | Endpoint | Description |
|--------|-----------|-------------|
| `GET` | `/task-lists` | Get all task lists |
| `GET` | `/task-lists/{id}` | Get task list by ID |
| `POST` | `/task-lists` | Create new task list |
| `PUT` | `/task-lists/{id}` | Update existing task list |
| `DELETE` | `/task-lists/{id}` | Delete task list |

### 🧠 Task APIs
| Method | Endpoint | Description |
|--------|-----------|-------------|
| `GET` | `/api/task-lists/{id}/tasks` | Get all tasks for a list |
| `GET` | `/api/task-lists/{id}/tasks/{taskId}` | Get specific task |
| `POST` | `/api/task-lists/{id}/tasks` | Create new task under list |
| `PUT` | `/api/task-lists/{id}/tasks/{taskId}` | Update task |
| `DELETE` | `/api/task-lists/{id}/tasks/{taskId}` | Delete task |

---

## ⚙️ Run the Application

### 🧾 Prerequisites
- Java 17+
- Maven 3.8+
- IDE (IntelliJ / VS Code / Eclipse)

### ▶️ Steps
```bash
# 1. Clone the repository
git clone https://github.com/anis-mansuri-07/taskflow.git

# 2. Open the project in IntelliJ or VS Code

# 3. Build the project
mvn clean install

# 4. Run the Spring Boot application
mvn spring-boot:run
````

Application runs by default on:
👉 **[http://localhost:8080](http://localhost:8080)**

---

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

---

## 🧱 Future Enhancements

* Add user authentication (JWT)
* Integrate with a React.js frontend
* Add sorting, filtering.

---

## 🧑‍💻 Author

**Mahammedanis Mansuri**
🎓 MCA Student | 💻 Java & Spring Developer
📧 [[anishmansuri269@gmail.com](mailto:anishmansuri269@gmail.com)]
💻 [GitHub Profile](https://github.com/anis-mansuri-07)
🔗 [Connect with me on LinkedIn](https://www.linkedin.com/in/anis-mansuri-57b97a25a)

