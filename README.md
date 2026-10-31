# CampusOne — College ERP System

Full-stack College ERP Management System built as a monolithic application.

## Stack
Frontend: HTML, CSS, JavaScript
Backend: Java 17, Spring Boot, Spring Data JPA, Hibernate
Database: PostgreSQL
Build: Maven
Frontend integration: JavaScript Fetch API
Architecture: Monolithic layered architecture

## Architecture
Frontend -> REST API -> Controller -> Service -> Repository -> PostgreSQL

## Modules
Student, Teacher, Course, Attendance, Mark, Announcement, User

Each module has:
Entity + Controller + Service + Repository

## Setup
1. Create PostgreSQL database:
   CREATE DATABASE college_erp;
2. Edit backend/src/main/resources/application.properties with your local PostgreSQL username/password.
3. Run backend:
   cd backend
   mvn spring-boot:run
4. Serve the frontend with VS Code Live Server and open frontend/index.html.

## Main endpoints
/api/students
/api/teachers
/api/courses
/api/attendance
/api/marks
/api/announcements
/api/users
/api/dashboard/summary

## Note
The login page is currently a UI/demo login. It does not authenticate against the database yet. Spring Security/JWT can be added as a later enhancement.

## Current frontend
The current frontend uses plain HTML, CSS and JavaScript. React is intentionally not included in this version; it can be introduced later as a frontend replacement while keeping the same Spring Boot REST APIs.

## Layer responsibilities
- Controller: receives HTTP requests and returns HTTP/JSON responses.
- Service: contains application/business logic.
- Repository: uses Spring Data JPA to access PostgreSQL.
- Model: JPA entities mapped to database tables.

## Team contribution note
This is structured as a team full-stack project. Backend REST APIs are organized using Controller, Service and Repository layers.
