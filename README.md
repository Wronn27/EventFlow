# Event Ticket App

The Event Ticket Platform is a Spring Boot application that lets organizers create events and sell
tickets, event goers buy those tickets, and staff scan ticket QR codes at the event. Authentication
is handled by Keycloak. The frontend is a React application built with Vite.

## The Build Guide

The full step-by-step write-up of the build lives in
[docs/event-ticket-app-combined.md](docs/event-ticket-app-combined.md). It covers the project brief,
the user stories and UI designs, the domain and architecture design, and then builds the backend up
endpoint by endpoint.

## What's In This Repo

| Directory   | Contents                                                          |
| ----------- | ----------------------------------------------------------------- |
| `docs/`     | The build guide, with its UI designs and diagrams                 |
| `backend/`  | The Spring Boot backend, as built in the video                    |
| `frontend/` | The React frontend, provided for you to interact with the backend |

## Running It

You'll need JDK 21, Node 20 or later, and Docker.

```bash
# Start PostgreSQL, Adminer and Keycloak, then run the backend
cd backend
docker compose up -d
./mvnw spring-boot:run

# Run the frontend, in a second terminal
cd frontend
npm install
npm run dev
```

The frontend runs on http://localhost:5173 and proxies API calls through to the backend on port 8080.
The supporting services come up on these ports:

| Service    | URL                   |
| ---------- | --------------------- |
| Keycloak   | http://localhost:9090 |
| Adminer    | http://localhost:8888 |
| PostgreSQL | localhost:5432        |

Keycloak needs an `event-ticket-platform` realm containing an `event-ticket-platform-app` client, to
match the issuer URI configured in the backend and the OIDC config in `frontend/src/main.tsx`. The
guide walks through setting this up.

## Author
Markandey Upadhyay
