# Library-Management-System
A simple Java-based RESTful API built using Spring Boot to manage a library’s book catalog.

---

## 🛠 Technologies Used
* Java 21
* Spring Boot 3.5.3
* Spring Web
* Spring Data JPA
* MySQL Database
* Hibernate ORM

**Note:** Use [Spring Initialzr](https://start.spring.io/) to initialize your Spring Boot application & refer below screenshot.
<img width="1724" height="972" alt="Screenshot 2025-07-13 095547" src="https://github.com/user-attachments/assets/b5864147-2170-4467-8720-71d55c890f74" />

---

## 🚀 Getting Started
Prerequisites <br />
Make sure you have installed:

* Java 21
* IntelliJ IDEA (Community or Ultimate)
* MySQL Server (Version 8.x recommended)
* Postman (for testing APIs)

---

## 📥 Download the Project
If you're using GitHub then download the zip file of project from GitHub or used GitHub link. <br />
[click here](https://www.youtube.com/watch?v=aBVOAnygcZw) to refer how to clone GitHub project on IntelliJ IDEA

---

## ▶️ Running the Application in IntelliJ IDEA
1. Open IntelliJ IDEA
2. Click on "Open" or "Open Project"
3. Navigate to the folder where your project is located (pom.xml should be there)
4. Wait for Maven to import dependencies
5. Run the main class:
```java
com.dipak.dipak.LibraryManagementSystemApplication
```
6. The application will start on port 8080.
You can now access the API at:
```bash
http://localhost:8080/api/books
```

---

## 🔧 MySQL Configuration
Since you've included MySQL as a dependency, we'll configure it to use MySQL.
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/librarydb
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```
Replace your_username and your_password with your actual MySQL password.

### Create the Database
Before starting the application, create the database in MySQL:
```sql
CREATE DATABASE librarydb;
```

---

## 📥 Sample Request & Response
### 1. Add a New Book (POST)
**URL:** http://localhost:8080/api/books <br />
Request Body:
```json
{
    "title": "Quantitative Aptitude",
    "author": "R. S. Aggarwal",
    "isbn": "97-893-525-3402-9",
    "available": true
}
```
Response (201 Created):
```json
{
    "id": 1,
    "title": "Quantitative Aptitude",
    "author": "R. S. Aggarwal",
    "isbn": "97-893-525-3402-9",
    "available": true
}
```

### 2. Get All Books (GET)
**URL:** http://localhost:8080/api/books <br />

Response:
```json
[
  {
    "id": 1,
    "title": "Quantitative Aptitude",
    "author": "R. S. Aggarwal",
    "isbn": "97-893-525-3402-9",
    "available": true
}
]
```

### 3. Get Book by ID (GET)
**URL:** http://localhost:8080/api/books/1

Response:
```json
{
    "id": 1,
    "title": "Quantitative Aptitude",
    "author": "R. S. Aggarwal",
    "isbn": "97-893-525-3402-9",
    "available": true
}
```
Error if Book ID not found (404 Not Found):
```json
{
  "message": "Book ID not found",
  "status": 404
}
```

### 4. Update Book Availability (PUT)
**URL:** http://localhost:8080/api/books/1/availability

Request Body:
```json
false
```

Response:
```json
{
    "id": 1,
    "title": "Quantitative Aptitude",
    "author": "R. S. Aggarwal",
    "isbn": "97-893-525-3402-9",
    "available": true
}
```

### 4. Delete a Book (DELETE)
URL: http://localhost:8080/api/books/1

Response (204 No Content):
No body returned.

Error (404 Not Found):
```json
{
  "message": "Book ID not found",
  "status": 404
}
```
