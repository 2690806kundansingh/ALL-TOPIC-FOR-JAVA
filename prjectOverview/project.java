/*
1. Project Overview & Objective
"In my recent project, I designed and developed an enterprise-grade, event-driven AI-Powered Fitness 
& Wellness Microservices Platform built with Java 17, Spring Boot 3, Spring Cloud, RabbitMQ, Keycloak,
 and React 19.

The core objective was to solve a major limitation in traditional fitness
 trackers. Standard applications act as passive logs—they store distance,
  duration, and calories, but fail to explain what those numbers mean or how
   an athlete should recover. On the other hand, platforms that tried integrating
    LLMs synchronously suffered from 3 to 5 seconds of UI freezing, causing high 
    bounce rates.

Our goal was twofold:

Build a resilient, high-throughput backend capable of ingesting
 diverse workout telemetry in under 40 milliseconds.
Decouple generative AI athletic coaching using an asynchronous
 event-driven architecture with RabbitMQ and Google Gemini, delivering sports-science insights, injury prevention guidelines, habit streak gamification, and a 24/7 conversational gym coach called FitBot."
 */

/*
2.Tech Stack & High-Level Architecture
"We designed the system as a distributed microservices ecosystem running on Docker containers,
 following 12-factor application principles.

At the perimeter, all traffic hits our Spring Cloud API Gateway
 (Port 8085). The gateway acts as an OAuth2 Resource Server that 
 validates signed JWT tokens against Keycloak 24 using asymmetric JWKS 
 public keys. It resolves downstream service locations dynamically through the
  Netflix Eureka Service Discovery Server (Port 8761), ensuring zero hardcoded 
  IP addresses, while configurations across environments are managed centrally 
  via Spring Cloud Config Server (Port 8888).

Our business logic is partitioned into three independent 
domain microservices:

1.User Service (Port 8081): Built with Spring Data JPA and 
PostgreSQL. It handles user accounts, physical profiles,
 and consecutive daily streak algorithms.

2.Activity Service (Port 8082): Built with Spring Data MongoDB.
 It ingests telemetry (running, cycling, HIIT, strength) and publishes
  workout events to RabbitMQ.

3.AI Service (Port 8083): An asynchronous worker consuming events
 from RabbitMQ, calling Google Gemini (gemini-1.5-flash),
  and running the FitBot conversational engine.
We implemented Polyglot Persistence: PostgreSQL for relational, 
ACID-compliant user records, and MongoDB for dynamic workout 
metrics and nested AI coaching reports."
 */

/*
3.Your Specific Role & Core Responsibilities
"I served as the Backend and Microservices Engineer, owning 
the end-to-end architecture, inter-service communication, 
security pipeline, and cloud deployment.

Specifically, my core responsibilities included:

1.Microservices Architecture & Routing: Setting up Spring Cloud
 Gateway with Eureka dynamic discovery and externalizing environment
  configs via Spring Cloud Config Server.

2.Zero-Trust Identity & Token Relay: Integrating Keycloak
 OAuth2 with the PKCE flow. I wrote a custom reactive KeycloakUserSyncFilter 
 at the Gateway level to automatically provision Keycloak users 
 into our PostgreSQL database on their very first request and forward
  their identity downstream via X-User-ID headers.

3.Asynchronous Pipeline Engineering: Designing the RabbitMQ messaging
 topology (fitness.exchange with activity.tracking routing keys) 
 to eliminate UI blocking.

4.AI Integration & Prompt Engineering: Implementing ActivityAIService
 with Google Gemini, enforcing rigid JSON schema responses, and
  creating a rule-based fallback engine for high resilience.

5.Data Modeling & Business Logic: Designing PostgreSQL schemas
 for user streaks (calculating consecutive calendar check-in 
 dates) and MongoDB document stores for polymorphic workout telemetry.

6.Containerization & Infrastructure: Writing multi-stage Dockerfiles and 
orchestrating the full stack (8+ containers) using Docker Compose and Cloudflare
 Tunnel for secure remote staging."
 */

 /*
 4.Key Challenges & Engineering Decisions
 
  */