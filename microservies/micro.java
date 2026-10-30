/*
 * 1. What is Microservices?
 * Microservices is an architectural style where a large application is divided
 * into small, independent services, and each service handles one specific
 * business functionality.
 * For example, an e-commerce application can be divided into:
 * E-Commerce Application
 * |
 * -------------------------------------
 * | | | |
 * User Service -Product Order- Service Payment
 * Service
 * Each service is a separate application.
 * 
 * ==>Real-Life Example
 * Think about Amazon.
 * User Service
 * ↓
 * Login / Register / Profile
 * 
 * Product Service
 * ↓
 * Products / Search / Categories
 * 
 * Order Service
 * ↓
 * Create / Cancel / Track Order
 * 
 * Payment Service
 * ↓
 * Payment / Refund
 * 
 * Inventory Service
 * ↓
 * Stock Management
 * 
 * Notification Service
 * ↓
 * Email / SMS
 * Instead of having one huge application, we have multiple smaller
 * applications.
 * 
 * ==> What is a Monolithic Application?
 * In a monolithic architecture, everything is inside one application.
 * You build and deploy the entire application as one unit.
 * 
 * ==>Biggest Advantage
 * Suppose Payment Service gets heavy traffic.
 * You don't necessarily need to scale the entire application.
 * You can run multiple Payment Service instances:
 * 
 * ==>How Microservices Communicate
 * There are two major approaches
 * *Synchronous
 * REST API
 * OpenFeign
 * WebClient
 * *Asynchronous
 * Kafka
 * RabbitMQ
 * 
 * ==>Important Microservices Components
 * API Gateway
 * |
 * Service Discovery
 * (Eureka)
 * |
 * --------------------------------
 * | | |
 * User Service -Order Service -Payment Service
 * | | |
 * DB DB DB
 * 
 * ==>Monolith vs Microservices
 * Monolithic Microservices
 * One large application --Multiple small services
 * Usually one deployment unit-- Independent deployment
 * Usually shared database --Database per service is common
 * Scaling whole application is common --Individual services can scale
 * Simple initially-- More complex
 * Easier to develop initially --Better for large distributed systems
 * Failure can affect whole application-- Failures can be isolated
 * 
 * ==>Advantages of Microservices
 * .Independent Deployment
 * .Team Independence
 * .Technology Flexibility
 * 
 * ==>Disadvantages
 * .Network communication
 * .Distributed debugging
 * .Security
 * .Deployment complexity
 * 
 * 2.Why Do Services Need to Communicate?
 * Suppose we have:
 * User Service
 * Hotel Service
 * Rating Service
 * .The User Service has user information:
 * But User Service doesn't have hotel information.
 * Hotel Service owns hotel data:
 * f the client asks User Service: (Give me user + hotel information)
 * User Service needs to call Hotel Service.
 * User Service needs to call Hotel Service.
 * 
 * ==>What is Mono?
 * Mono<T> represents zero or one result.
 * 
 * ==>What is Flux?
 * Flux<T> represents zero to many results.
 * 
 * ==>"RestTemplate is still available, but it is in maintenance mode.
 * For new development, WebClient is generally preferred, especially when
 * reactive/non-blocking communication is required."
 * 
 * ==>OpenFeign
 * There is an even easier way to communicate between services.
 * Feign client is a tool in spring boot used to communicate between the
 * micriservices
 * It make calling another microsservices RESt API very easy
 * Instead of wrting HTTP code manually,you create an interface and define the
 * api you want to call
 * without feign you migh use restTemplate and and WebClient.
 * It can also work with Eureka for service resistroy and load balancing.
 * 
 * @FeignClient(name = "HOTEL-SERVICE")
 * public interface HotelClient {
 * 
 * @GetMapping("/hotels/{id}")
 * Hotel getHotel(@PathVariable String id);
 * }
 * 
 * ==>What is service-to-service communication?
 * It is the communication between two or more microservices to exchange data or
 * perform operations.
 * 
 * ==>How can microservices communicate?
 * They can communicate synchronously using REST, WebClient, RestTemplate, or
 * OpenFeign, and asynchronously using messaging systems such as Kafka or
 * RabbitMQ.
 * 
 * ==>What is RestTemplate?
 * RestTemplate is a synchronous, blocking HTTP client traditionally used in
 * Spring applications to communicate with REST APIs and other microservices.
 * 
 * ==>What is WebClient?
 * WebClient is a modern HTTP client from Spring WebFlux that supports
 * non-blocking communication and is commonly used for reactive applications.
 * 
 * ==>What is the problem with hardcoded service URLs?
 * If the service's host, port, or instance changes, the calling service must be
 * updated. It also doesn't work well with dynamically scaled service instances.
 * 
 * ==>Which is better: RestTemplate or WebClient?
 * It depends on the application. For new applications, WebClient is preferred
 * when reactive/non-blocking communication is needed; RestTemplate remains
 * common in existing synchronous applications.
 * 
 * 3.Today is very important because we're solving the hardcoded URL problem
 * from Day 2.
 * ==>What is Eureka?
 * Eureka is a service discovery system used to register and discover
 * microservices.
 * Think of Eureka as a phone directory for microservices.
 * .For example:
 * Eureka Server
 * 
 * USER-SERVICE → 8081
 * HOTEL-SERVICE → 8082
 * RATING-SERVICE → 8083
 * -Instead of User Service remembering Hotel Service's IP and port, it asks
 * Eureka:
 * Where is HOTEL-SERVICE?
 * Eureka answers:
 * HOTEL-SERVICE is running at this address.
 * 
 * ==>Eureka Server vs Eureka Client
 * There are two important terms.
 * -Eureka Server
 * The registry that maintains information about available services.
 * Eureka Server
 * |
 * +-- USER-SERVICE
 * +-- HOTEL-SERVICE
 * +-- RATING-SERVICE
 * 
 * -Eureka Client
 * A microservice that registers itself with Eureka and can discover other
 * services.
 * User Service → Eureka Client
 * Hotel Service → Eureka Client
 * Rating Service → Eureka Client
 * API Gateway → Eureka Client
 * ==Eureka Server → Service Registry
 * 
 * ==>Eureka Is Not a Load Balancer
 * eureka is Where are the service instances
 * 
 * =>Load Balancer
 * A loadbalancer distribute incoming client request amoung multiple instance
 * of a microservices.It help improve performance,scalibilty and avalibility
 * by preventing a single serviveinstance from handle of the traffic.
 * 
 * ==>What is Eureka?
 * Eureka is a service discovery and service registry system used to register
 * and discover microservices dynamically.
 * 
 * ==>What is Eureka Server?
 * Eureka Server acts as a central service registry that maintains information
 * about registered service instances.
 * 
 * ==>What is Eureka Client?
 * Eureka Client is a microservice that registers itself with Eureka Server and
 * can discover other registered services.
 * 
 * ==>Why do we use Eureka?
 * To avoid hardcoded service URLs and enable dynamic service discovery.
 * 
 * ==>What is the default port commonly used by Eureka Server?
 * 8761
 * 
 * ==>What is spring.application.name?
 * It identifies the service in the Eureka registry.
 * spring.application.name=HOTEL-SERVICE
 * 
 * 
 * 4.What is Load Balancing?
 * ==>Load balancing is the process of distributing incoming requests across
 * multiple instances of a service.
 * HOTEL-SERVICE
 * Instance 1 → :8082
 * Instance 2 → :8084
 * Instance 3 → :8085
 * And 6 requests arrive:
 * Request 1 ──→ 8082
 * Request 2 ──→ 8084
 * Request 3 ──→ 8085
 * Request 4 ──→ 8082
 * Request 5 ──→ 8084
 * Request 6 ──→ 8085
 * Instead of sending everything to one server, requests are distributed.
 * 
 * ==>Why Do We Need Load Balancing?
 * Imagine 10,000 users accessing your application.
 * 10,000 Requests
 * |
 * ↓
 * HOTEL-SERVICE :8082
 * That single instance can become overloaded.
 * 10,000 Requests
 * |
 * ↓
 * Load Balancer
 * / | \
 * ↓ ↓ ↓
 * :8082 :8084 :8085 -The load is distributed.
 * 
 * 
 * ==>Eureka vs Load Balancer
 * 
 * 
 * ==>What Does @LoadBalanced Do?
 * With @LoadBalanced, you can use the service name:
 * restTemplate.getForObject(
 * "http://HOTEL-SERVICE/hotels/H101",
 * Hotel.class
 * );
 * 
 * 
 * ==>Request Flow You Should Understand
 * Client
 * |
 * ↓
 * User Service
 * |
 * ↓
 * 
 * @LoadBalanced RestTemplate
 * |
 * ↓
 * Load Balancer
 * |
 * ↓
 * Eureka
 * |
 * Finds instances
 * |
 * ┌───────────┼───────────┐
 * ↓ ↓ ↓
 * Hotel Hotel Hotel
 * :8082 :8084 :8085
 * |
 * ↓
 * Response
 * 
 * 
 * Q1. What is Load Balancing?
 * Load balancing distributes requests among multiple instances of a service to
 * improve scalability, availability, and performance.
 * 
 * Q2. What is Spring Cloud LoadBalancer?
 * It is Spring Cloud's client-side load-balancing solution that selects an
 * available service instance for a request.
 * 
 * Q4. What is the difference between Eureka and LoadBalancer?
 * Eureka is responsible for service discovery and maintains information about
 * service instances. LoadBalancer selects an instance from those available
 * instances.
 */

/*
 * 5.what is Api Gateway
 * Api gateway is single entry point for cleint to access multiple
 * microservices instead of the frontend directlyncalling every
 * microservices,it send request to apiGateway,which routes them to
 * the correct service
 * ==>what does API gateway do ?
 * .request Routing
 * .Authentication/authoerization
 * .load balancing
 * .Logging and monitoring
 * .Rate limiting
 * .scurity
 */

/*
 * Java Microservices Interview Study Guide (Fresher Edition)
 * A high-yield, quick-access preparation guide specifically designed for junior
 * and fresher Java developers focusing on Spring Boot and Spring Cloud.
 * 
 * SECTION 1: CORE CONCEPTS (EASY & DIRECT)
 * 1. Monolith vs. Microservices
 * Interview Context:
 * "Can you explain the difference between a Monolith and Microservices in simple terms?"
 * 
 * Feature Monolith Architecture Microservices Architecture
 * Structure All features in a single codebase and single deployable jar/war.
 * Split into small, independent services based on business domains.
 * Scalability Scale the entire application, even if only one feature has high
 * load. Scale only the specific service that needs more resources.
 * Deployment Redeploy the whole app for even a 1-line change. (Risky, slow)
 * Deploy each service independently. (Faster, low-risk)
 * Fault Tolerance If one module crashes, the entire application goes down. If
 * one service fails, others keep running (with graceful degradation).
 * Technology Locked into one programming language and stack. Polyglot:
 * Different services can use different languages or versions.
 * 
 * 2. Microservice Communication: Sync vs. Async
 * Interview Context: "How do two microservices talk to each other?"
 * 
 * A. Synchronous Communication (Blocking)
 * Definition: The caller service sends a request and waits for the response
 * before proceeding.
 * Tools:
 * RestTemplate: Legacy blocking HTTP client.
 * WebClient: Modern reactive, non-blocking HTTP client.
 * OpenFeign: Declarative REST client (highly recommended).
 * Simple Example:
 * // Calling Order Service from User Service synchronously
 * OrderResponse response = feignClient.getOrderDetails(userId);
 * B. Asynchronous Communication (Non-Blocking / Event-Driven)
 * Definition: The caller sends a message to a broker and continues its work
 * without waiting for a response.
 * Tools: RabbitMQ, Apache Kafka.
 * Simple Example:
 * // Publishing order placement event to Kafka broker
 * kafkaTemplate.send("order-topic", new OrderEvent("ORDER_CREATED"));
 * 
 * 3. Service Discovery (Spring Cloud Netflix Eureka)
 * Interview Context: "What is Eureka and why do we need it in microservices?"
 * 
 * The Problem: Microservice instances spin up and down dynamically with
 * changing IP addresses and port numbers. Hardcoding URLs of other services is
 * impossible.
 * The Solution (Eureka Server): Act as a dynamic phonebook registry.
 * Service Registration: Every microservice register itself with the Eureka
 * Server (providing its name, IP, and port).
 * Service Discovery: When Service A wants to call Service B, it asks Eureka for
 * Service B's active location.
 * Analogy: Eureka is like a dynamic contact list on your phone; you call by
 * contact name (order-service) rather than memorizing changing phone numbers.
 * 
 * 4. API Gateway (Spring Cloud Gateway)
 * Interview Context: "What is the role of an API Gateway in microservices?"
 * 
 * An API Gateway is the single entry point for all client requests (Mobile,
 * Frontend) before they reach the backend services. Its 3 main roles are:
 * 
 * Routing: Directs incoming requests to the correct microservice based on path
 * rules (e.g., /orders/** routes to Order-Service).
 * Security (Authentication & Authorization): Validates incoming JWT tokens at
 * the gateway level. If invalid, rejects the request immediately, protecting
 * internal microservices from unauthorized traffic.
 * CORS (Cross-Origin Resource Sharing): Handles cross-origin requests
 * centrally, ensuring the frontend app can communicate with different
 * microservice routes without domain blocking.
 * 
 * 5. Circuit Breaker (Resilience4j) & Fallback Methods
 * Interview Context:
 * "What happens if a downstream service is down? How do you handle it?"
 * 
 * Circuit Breaker: A design pattern that monitors remote calls. If the failure
 * rate of calling a service exceeds a threshold, the circuit trips open, and
 * all subsequent calls are diverted immediately to avoid resource exhaustion
 * (cascading failure).
 * Fallback Method: The backup plan. A method that runs automatically when the
 * circuit is open or if the target service throws an exception. It returns
 * dummy or cached data.
 * State Analogy:
 * CLOSED: Everything is normal. Requests flow.
 * OPEN: Target service is failing. Requests are blocked immediately; fallback
 * is called.
 * HALF-OPEN: Testing the target service with a few requests to see if it
 * recovered.
 * 
 * 
 * 6. Centralized Config Server (Spring Cloud Config Server)
 * Interview Context:
 * "How do you manage application properties across 20+ microservices?"
 * 
 * The Problem: Storing configuration properties (application.properties / yml)
 * inside each service JAR makes it hard to update them. You would have to
 * rebuild and redeploy the service for a simple database password change.
 * The Solution: Use a central Git or filesystem repository to host
 * configuration files.
 * Config Server: A microservice that reads these configurations and serves them
 * to all client microservices at startup.
 * Dynamic Reloading: By using @RefreshScope and triggering the
 * /actuator/refresh endpoint, properties can be updated on the fly without
 * restarting the microservices.
 * 
 * 
 * 7. Distributed Tracing (Micrometer Tracing & Zipkin)
 * Interview Context:
 * "A request travels through 5 microservices and fails. How do you track where it failed?"
 * 
 * The Challenge: Standard console logs are scattered across different
 * servers/containers. It is impossible to connect logs of a single request
 * across multiple services manually.
 * The Solution (Distributed Tracing):
 * TraceId: A unique ID generated at the API Gateway when a request enters. This
 * ID is passed along HTTP headers to all downstream services. All logs
 * associated with this request print the same TraceId.
 * SpanId: Represents a single unit of work (e.g., inside one service).
 * Micrometer Tracing: Automatically attaches these IDs to the MDC logging
 * context in Spring Boot 3.x.
 * Zipkin: A visualization dashboard tool that collects these traces and
 * displays a timeline diagram showing where delays or errors occurred.
 * SECTION 2: PRACTICAL SCENARIOS & CODE QUESTIONS ASKED TO FRESHERS
 * Scenario 1: FeignClient Implementation
 * Question:
 * "Show me how to make a REST call from Service A to Service B using OpenFeign."
 * 
 * Step 1: Enable Feign in the Main Class
 * 
 * @SpringBootApplication
 * 
 * @EnableFeignClients // Activates Feign client scanning
 * public class OrderServiceApplication { ... }
 * Step 2: Define the Client Interface
 * 
 * @FeignClient(name = "payment-service") // Registered name in Eureka
 * public interface PaymentClient {
 * 
 * @GetMapping("/payments/{orderId}")
 * PaymentResponse getPaymentStatus(@PathVariable("orderId") String orderId);
 * }
 * Step 3: Inject and Use it in your Service
 * 
 * @Autowired
 * private PaymentClient paymentClient; // Direct declarative call
 * Scenario 2: Writing a Circuit Breaker Fallback
 * Question:
 * "Write a controller method with a @CircuitBreaker annotation and its fallback method."
 * 
 * @RestController
 * public class OrderController {
 * 
 * @GetMapping("/order-details/{id}")
 * 
 * @CircuitBreaker(name = "paymentServiceCB", fallbackMethod =
 * "paymentFallback")
 * public String getOrderDetails(@PathVariable String id) {
 * // Assume this calls payment-service which might fail
 * return paymentService.callPaymentAPI(id);
 * }
 * 
 * // Must have same return type and include the Exception parameter
 * public String paymentFallback(String id, Throwable ex) {
 * return
 * "Payment service is currently unavailable. Please try again later. Error: " +
 * ex.getMessage();
 * }
 * }
 * Scenario 3: Passing JWT Tokens Across Services
 * Question:
 * "How do you forward the JWT authorization header from the Gateway to microservices, or between microservices?"
 * 
 * A. Gateway to Microservices (Spring Cloud Gateway Configuration)
 * The Gateway extracts the token and forwards it down the chain automatically
 * using the TokenRelay filter or global configuration.
 * 
 * spring:
 * cloud:
 * gateway:
 * routes:
 * - id: order-service
 * uri: lb://order-service
 * predicates:
 * - Path=/orders/**
 * filters:
 * - TokenRelay= # Passes the OAuth2/JWT token down
 * B. Service-to-Service Propagation (Feign Client Interceptor)
 * To pass the token when Service A calls Service B using Feign, configure a
 * request interceptor:
 * 
 * @Component
 * public class FeignAuthInterceptor implements RequestInterceptor {
 * 
 * @Override
 * public void apply(RequestTemplate template) {
 * ServletRequestAttributes attributes = (ServletRequestAttributes)
 * RequestContextHolder.getRequestAttributes();
 * if (attributes != null) {
 * String token = attributes.getRequest().getHeader("Authorization");
 * template.header("Authorization", token); // Inject header into outgoing call
 * }
 * }
 * }
 * Scenario 4: Handling CORS Errors
 * Question:
 * "How do you resolve CORS errors when your Angular/React frontend tries to access the backend APIs via Gateway?"
 * 
 * Solution: Configure CORS centrally in your API Gateway's application.yml:
 * 
 * spring:
 * cloud:
 * gateway:
 * globalcors:
 * cors-configurations:
 * '[/**]':
 * allowedOrigins: "http://localhost:3000" # Frontend URL
 * allowedMethods:
 * - GET
 * - POST
 * - PUT
 * - DELETE
 * allowedHeaders: "*"
 * allowCredentials: true
 * SECTION 3: TOP 10 RAPID-FIRE 1-LINER INTERVIEW QUESTIONS
 * Use this section as a final 5-minute refresher before entering your
 * interview:
 * 
 * Q: What is the default port of Eureka Server?
 * A: Port 8761.
 * 
 * Q: How do you register a Spring Boot app with Eureka Server?
 * A: Add spring-cloud-starter-netflix-eureka-client dependency and configure
 * eureka.client.service-url.defaultZone in properties.
 * 
 * Q: What annotation makes a Feign client load-balanced automatically?
 * A: @FeignClient integrates with Spring Cloud LoadBalancer under the hood; no
 * extra annotations are needed.
 * 
 * Q: What does the @RefreshScope annotation do?
 * A: It allows Spring Beans to dynamically reload their configuration values
 * (@Value) when a config change is pulled, without restarting the JVM.
 * 
 * Q: How do you monitor circuit breaker states and metrics?
 * A: Using Spring Boot Actuator combined with Prometheus and Grafana
 * dashboards.
 * 
 * Q: What is the difference between Spring Cloud Gateway and Netflix Zuul?
 * A: Zuul is blocking/synchronous (based on servlet filter api), whereas Spring
 * Cloud Gateway is non-blocking (built on Spring WebFlux and Netty), offering
 * better performance.
 * 
 * Q: What is Hystrix and is it still used?
 * A: Netflix Hystrix is a deprecated circuit breaker library. Modern Spring
 * Boot projects use Resilience4j.
 * 
 * Q: How does a microservice client fetch properties from Config Server?
 * A: By importing the spring-cloud-starter-config dependency and defining
 * spring.config.import=optional:configserver:http://localhost:8888 in its
 * settings.
 * 
 * Q: What is database per microservice design?
 * A: Each microservice has its own separate database (e.g., MongoDB,
 * PostgreSQL) and no service can read/write another service's database directly
 * to preserve loose coupling.
 * 
 * Q: What is the role of a Spring Cloud LoadBalancer?
 * A: It distributes incoming requests evenly among multiple instances of the
 * same microservice registered in Eureka.
 */

/*
 * 6.what is Kafka ?
 * Kafka is a distributed event-streaming platform used for high-throughput,
 * asynchronous communication between applications and microservices.
 * 
 * 1.what is kafka Producer ?
 * A producer publishes/sends messages to Kafka topics.
 * 
 * 2.What is a Kafka Consumer?
 * A consumer reads messages from Kafka topics.
 * 
 * 3.what is topics ?
 * A topic is a named category where Kafka stores messages/events.
 * 
 * 4.what is Partition ?
 * A parition in kafka is an ordered ,distributed log within a topic
 * .A topic can hava multiple partitions,allowing kafka to
 * process messages in parallel and scale horijontly
 * 
 * 5.what is OFFset ?
 * An offset is the position/index of message within a kafka partition.
 * 
 * 6.what is Consumer Group ?
 * A consumer group is a group of consumers that work together to consume
 * messages from a topic. Within a group, a partition is assigned to only one
 * consumer at a time.
 * 
 * 7.why use Kafka in microservices ?
 * .Asynchronous communication
 * .hight throughtput
 * .Decoupling services
 * Event-driven architecture
 * .Scalibility
 * 
 * 8.what is Resilience /Fault TOlrence
 * =>Resilience means a microservices application can continue working even when
 * one service fails.
 * =>Fault tolerance means the system is designed to handle failures without
 * bringing down the entire application.
 * 
 * =>"Resilience or fault tolerance in microservices means designing the system
 * so that
 * failure of one service does not cause the entire application to fail. We use
 * techniques
 * like timeout, retry, circuit breaker, fallback, bulkhead, and rate limiting.
 * In Spring Boot,
 * Resilience4j is commonly used to implement these patterns."
 * 
 * 8.what is Circuit Breaker ?
 * A Circuit Breaker is a design pattern used in microservices to prevent
 * repeated calls to a service that is failing
 * =>3 States of Circuit Breaker
 * .Closed =>Requests are allowed normally.
 * .Open =>Too many failures occurred. Requests are blocked temporarily.
 * .Half_open=>After a waiting period, a few test requests are allowed. If the
 * service has recovered → CLOSED. If it still fails → OPEN.
 * 
 */