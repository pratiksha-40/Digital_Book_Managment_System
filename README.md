Digital Library Book Management System
A Spring Boot-based application that manages library books, allowing users to add, update, delete, and search for books. Built with Spring Boot, Hibernate, and MySQL Workbench.

🚀 Features
📚 Add, update, delete, and view books

🔍 Search for books by title, author, or category

🏗 Built using Spring Boot, Hibernate, and MySQL

🔄 RESTful API for backend interactions

🛠 Technologies Used
Backend: Java, Spring Boot, Hibernate

Database: MySQL (Workbench)

API Testing: Postman

📌 Setup Instructions

1️⃣ Prerequisites
JDK 17+ installed

Maven installed

MySQL Workbench installed

Postman (for API testing)

2️⃣ Clone the Repository
bash
Copy
Edit
git clone https://github.com/yourusername/Digital-Library.git
cd Digital-Library

3️⃣ Configure Database
Open MySQL Workbench

Create a database:

sql
Copy
Edit
CREATE DATABASE library_management;
Update application.properties in src/main/resources/:

properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/library_management
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

4️⃣ Build and Run the Application
bash
Copy
Edit
mvn clean install
mvn spring-boot:run

5️⃣ Test APIs in Postman
Base URL: http://localhost:8080/api/books

Sample Endpoints:

GET /books → Fetch all books

POST /books → Add a new book

PUT /books/{id} → Update book details

DELETE /books/{id} → Remove a book

🎯 Challenges Faced
Database Connection Issues – Ensured proper configuration in application.properties.

API Response Optimization – Improved query performance with Hibernate caching.

Error Handling – Implemented global exception handling using @ControllerAdvice.

📌 Future Improvements
Implement frontend using Angular.

Add JWT authentication for user roles (Admin, User).

Deploy on Heroku or Railway for public access.
