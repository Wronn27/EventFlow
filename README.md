#  EventFlow

A scalable event ticket booking backend built with **Spring Boot**, inspired by real-world ticketing platforms like BookMyShow and Ticketmaster.

The project focuses on solving real backend engineering challenges such as authentication, seat booking concurrency, caching, QR-based ticket validation, and secure REST APIs.

---

##  Features

###  Authentication & Authorization
- JWT Authentication
- Spring Security 6
- Role-Based Access Control (USER / ORGANIZER / ADMIN)
- Secure REST APIs

###  Event Management
- Create Events
- Update Events
- Delete Events
- View Events
- Event Categories
- Venue Management

###  Seat Booking
- Seat Selection
- Real-time Seat Availability
- Booking Confirmation
- Booking Cancellation

###  Concurrency Control
- Prevent Double Booking
- Optimistic Locking
- Redis Distributed Locking *(Planned)*

### Performance
- Redis Caching
- Pagination & Sorting
- Efficient Database Queries

### 📱 Ticket Management
- QR Code Ticket Generation
- Ticket Validation
- Booking History

###  Admin Dashboard
- Manage Users
- Manage Events
- Booking Analytics
- Revenue Reports *(Planned)*

---

#  Tech Stack

## Backend
- Java 21
- Spring Boot 3
- Spring Security
- Spring Data JPA
- Hibernate

## Database
- PostgreSQL

## Authentication
- JWT (JSON Web Token)

## Caching
- Redis *(In Progress)*

## Build Tool
- Maven

## API Testing
- Postman

## Documentation
- OpenAPI / Swagger *(Planned)*

---

#  Project Structure

```
src
 ├── config
 ├── controller
 ├── dto
 ├── entity
 ├── exception
 ├── filter
 ├── mapper
 ├── repository
 ├── security
 ├── service
 └── util
```

---

#  Concepts Implemented

- RESTful API Design
- Dependency Injection
- DTO Pattern
- Repository Pattern
- Service Layer Architecture
- Exception Handling
- Validation
- JWT Authentication
- Role-Based Authorization
- Hibernate ORM
- Pagination
- Optimistic Locking
- Redis Caching
- Distributed Locking
- QR Code Generation

---

#  Future Improvements

- Microservices Architecture
- Kafka Event Streaming
- Elasticsearch
- Kubernetes Deployment
- Grafana Monitoring
- Prometheus Metrics
- Rate Limiting
- Payment Gateway Integration
- WebSocket Live Seat Updates

---

#  Author

**Markandey Upadhyay**

GitHub: https://github.com/Wronn27
