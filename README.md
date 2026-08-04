# 🏨 Front Office Management System (FOMS)

## 📌 Project Description

The **Front Office Management System (FOMS)** is a web-based application developed to automate the day-to-day operations of a hotel's front desk. It enables reception staff to efficiently manage customers, rooms, bookings, check-ins, and check-outs while maintaining booking history.

The project eliminates manual record keeping by providing a simple, user-friendly interface backed by a Spring Boot REST API and a MySQL database.

---

# 🎯 Objectives

* Digitize hotel front office operations.
* Reduce manual errors during room allocation.
* Prevent duplicate customer and room records.
* Automate room availability management.
* Maintain complete booking history.
* Provide a simple and scalable backend architecture.

---

# 🏗️ Project Architecture

The application follows a **3-Layer Architecture**.

```
Presentation Layer (HTML, CSS, JavaScript)
                │
                ▼
Controller Layer (Spring REST Controllers)
                │
                ▼
Service Layer (Business Logic)
                │
                ▼
Repository Layer (Spring Data JPA)
                │
                ▼
MySQL Database
```

### Layers

### Presentation Layer

* HTML
* CSS
* JavaScript
* Fetch API

Responsible for collecting user input and communicating with the backend.

---

### Controller Layer

Receives HTTP requests and returns responses.

Controllers include:

* CustomerController
* RoomController
* BookingController

---

### Service Layer

Contains all business logic.

Examples:

* Customer validation
* Duplicate customer checking
* Room allocation
* Check-in
* Check-out
* Booking history

---

### Repository Layer

Uses Spring Data JPA to interact with MySQL.

Repositories:

* CustomerRepository
* RoomRepository
* BookingRepository

---

### Database Layer

Stores all application data.

Tables:

* Customers
* Rooms
* Bookings

---

# 🛠️ Tools & Technologies Used

## Backend

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* Maven

---

## Frontend

* HTML5
* CSS3
* JavaScript
* Fetch API

---

## Database

* MySQL

---

## Development Tools

* IntelliJ IDEA
* MySQL Workbench
* Postman
* Git
* GitHub

---

# 👨‍💻 My Role

This project was designed and developed independently.

Responsibilities included:

* Designing the application architecture
* Developing REST APIs using Spring Boot
* Implementing business logic
* Designing the MySQL database
* Building the frontend using HTML, CSS and JavaScript
* Integrating frontend and backend using Fetch API
* Implementing validation and exception handling
* Testing APIs using Postman
* Managing source code using Git and GitHub

---

# 📂 Project Structure

```
src
│
├── controller
│      CustomerController
│      RoomController
│      BookingController
│
├── entity
│      Customer
│      Room
│      Booking
│
├── repository
│      CustomerRepository
│      RoomRepository
│      BookingRepository
│
├── service
│      CustomerService
│      RoomService
│      BookingService
│
└── resources
       static
       application.properties
```

---

# 🗄️ Database Overview

## Customer

Stores customer information.

Fields

* ID
* Name
* Phone Number

---

## Room

Stores room information.

Fields

* ID
* Room Number
* Availability

---

## Booking

Stores booking information.

Fields

* Booking ID
* Customer
* Room
* Check-In Time
* Check-Out Time
* Active Status

---

# 🚀 How to Run the Project

## Step 1

Clone the repository

```bash
git clone https://github.com/ramrs123/foms.git
```

---

## Step 2

Open the project using IntelliJ IDEA or Eclipse.

---

## Step 3

Create a MySQL database.

```sql
CREATE DATABASE gemini;
```

---

## Step 4

Configure the database in `application.properties`.

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gemini
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
```

---

## Step 5

Run

```
FomsApplication.java
```

Spring Boot starts an embedded Tomcat server.

By default the application runs at:

```
http://localhost:8085
```

---

# ▶️ Application Workflow

When the application starts:

1. Spring Boot initializes all components.
2. Hibernate establishes a connection with MySQL.
3. Database tables are created (if not already present).
4. REST APIs become available.
5. Static HTML pages are served.
6. The frontend communicates with the backend using Fetch API.

---

# 🧭 Navigation Guide

The application contains separate pages for each module.

### Customer Management

Used to manage hotel customers.

Functions:

* Add Customer
* View Customers

Validation:

* Name must contain only alphabets.
* Phone number must be unique.
* Duplicate customers are not allowed.

---

### Room Management

Used to manage hotel rooms.

Functions:

* Add Room
* View Rooms

Validation:

* Room numbers must be unique.
* Rooms are available immediately after creation.

---

### Booking Management

Handles customer check-in.

Functions:

* Select customer
* Automatically assign the next available room
* Generate booking
* Update room availability

Business Rules:

* One customer can occupy only one room.
* One room can be assigned to only one customer.
* Booking ID is generated automatically.

---

### Checkout

Allows reception staff to check out customers.

Functions:

* Checkout using Booking ID
* Mark booking as completed
* Update checkout time
* Make room available again

Business Rules:

* Only active bookings can be checked out.
* Duplicate checkout is not allowed.

---

### Booking History

Displays all bookings made in the system.

Information displayed:

* Booking ID
* Customer Name
* Room Number
* Check-In Time
* Check-Out Time
* Booking Status

---

# 📋 Business Rules Implemented

* Customer names must contain only alphabets.
* Phone numbers must be valid Indian mobile numbers.
* Duplicate customer records are prevented.
* Duplicate room numbers are prevented.
* Newly created rooms are available by default.
* Automatic allocation of the next available room.
* One customer can occupy only one room at a time.
* One room can be occupied by only one customer at a time.
* Checkout frees the room automatically.
* Booking history is permanently maintained.

---

# 🔌 REST API Endpoints

## Customer

| Method | Endpoint     | Description    |
| ------ | ------------ | -------------- |
| POST   | `/customers` | Add customer   |
| GET    | `/customers` | View customers |

---

## Room

| Method | Endpoint | Description |
| ------ | -------- | ----------- |
| POST   | `/rooms` | Add room    |
| GET    | `/rooms` | View rooms  |

---

## Booking

| Method | Endpoint                         | Description   |
| ------ | -------------------------------- | ------------- |
| POST   | `/bookings/checkin/{customerId}` | Check In      |
| POST   | `/bookings/checkout/{bookingId}` | Check Out     |
| GET    | `/bookings`                      | View Bookings |

---

# 💡 Future Enhancements

* Login authentication
* Role-based access control
* Room categories
* Customer search
* Booking cancellation
* Payment module
* Invoice generation
* Dashboard and analytics
* Email notifications
* Online reservation system

---

# 📄 License

This project was developed for educational purposes and demonstrates the implementation of a basic hotel front office management system using Spring Boot and MySQL.

---

# 👤 Author

**Ramakrishna Dachepalli**

Bachelor of Technology (Computer Science & Engineering)

GitHub: https://github.com/ramrs123/foms
