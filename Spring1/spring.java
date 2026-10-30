/*
1. What is the Spring Framework?
Spring Framework is a lightweight Java framework used to develop enterprise applications.
It provides features like Inversion of Control and Dependency Injection, which help us create loosely coupled applications
It also provides support for web development, database operations, transaction management, and testing.
In simple words, Spring makes Java application development easier and more maintainable.

==>.Why do we use Spring Framework?
We use Spring Framework for several reasons.
First, it reduces tight coupling between classes.
Second, it manages object creation and dependencies.
Third, it makes our code easier to test and maintain.
Finally, it provides modules for web development, database access, and security.
That is why Spring is widely used to develop Java enterprise applications.

2. What is Spring Boot?
Spring Boot is built on top of the Spring Framework. It simplifies the development of standalone and production-ready Java applications.
It provides features like auto-configuration, starter dependencies, and embedded servers such as Tomcat.
Because of these features, we need less manual configuration, and we can develop applications faster.
For example, we can create a Spring Boot REST API and run it directly without manually deploying it to an external Tomcat server.

==>.Why was Spring Boot introduced?
Spring Boot was introduced to simplify Spring application development.
Earlier, developers often had to configure dependencies, set up the server, and manage a lot of configuration manually.
Spring Boot reduces this work through auto-configuration, starter dependencies, and embedded servers.
As a result, developers can focus more on business logic instead of spending too much time on configuration.

3. How does Spring Boot work?
When we run a Spring Boot application, the main method calls SpringApplication.run().
Spring Boot creates the Spring ApplicationContext, which manages the application beans.
It performs component scanning and auto-configuration based on the application's dependencies and configuration.
If it is a web application, Spring Boot starts an embedded server such as Tomcat.
After the application starts successfully, it can handle incoming HTTP requests.

4. What is @SpringBootApplication?
The @SpringBootApplication annotation is the main annotation used in a Spring Boot application.
It combines three important annotations: @SpringBootConfiguration, @EnableAutoConfiguration, and @ComponentScan.
@SpringBootConfiguration identifies the class as a source of Spring configuration.
@EnableAutoConfiguration configures beans based on the application's dependencies and existing configuration.
@ComponentScan discovers eligible Spring components in the package and its subpackages.
Together, these features simplify application setup.

5. Explain the Spring Boot project structure.
In a typical Spring Boot project, we organize our code into different packages according to their responsibilities.
The controller package handles incoming HTTP requests.
The service package contains business logic.
The repository package handles database operations.
The entity package contains classes that represent persistent data.
The DTO package contains objects used to transfer the required data between the client and the server.
The config package contains configuration classes, and the exception package contains custom exceptions and global exception handling.
This structure makes the application easier to understand, test, and maintain.

Remember each package
Package	What you should say
controller	Handles HTTP requests and responses.
service	Contains business logic.
repository	Performs database access.
entity	Represents persistent data, often database tables.
dto	Transfers selected data between application layers or between client and server.
config	Contains application configuration.
exception	Handles application errors and exceptions.

==>.Why do we use DTOs?
We use DTOs, or Data Transfer Objects, to transfer only the required data between the client and the application.
They help us avoid exposing unnecessary entity fields and allow us to design our API responses independently of our database entities.
For example, in a user API, we can return the user's name and email without exposing the password field.

6. What is application.properties?
The application.properties file is used to configure a Spring Boot application.
We can define properties such as the server port, database connection details, logging levels, and application-specific settings.
Spring Boot reads these properties during application startup
For sensitive information, such as database passwords and JWT secrets, we should prefer environment variables or a secure secrets manager instead of hardcoding them in the file.

7. Explain the flow of a request in Spring Boot.
In a typical Spring Boot REST application, a request first reaches the controller.
The controller receives the HTTP request and calls the appropriate service method.
The service layer executes the business logic and communicates with the repository when database access is required.
The repository interacts with the database and returns the result.
Finally, the service and controller pass the result back to the client as an HTTP response, often in JSON format.
This separation of responsibilities makes the application easier to maintain and test.

8. What is Dependency Injection (DI)?
Dependency Injection is a technique in which Spring provides the required objects to a class instead of the class creating those objects itself.
For example, a controller needs a service object to perform business operations.
Instead of creating the service using the new keyword, we let Spring inject it into the controller.
This reduces tight coupling and makes the code easier to test and maintain.
I generally prefer constructor injection because it makes dependencies explicit and supports immutable fields.

==>.How does Dependency Injection work?
First, Spring starts and creates the ApplicationContext.
Next, it discovers eligible components through component scanning and other bean registration mechanisms.
Spring creates and manages the required beans.
When one bean depends on another, Spring resolves that dependency and injects the required bean.
For example, if a controller depends on a service, Spring provides the service object to the controller through its constructor.

==>.Which annotations are used to create Spring beans?
Spring provides several annotations to identify classes as components.
@Component is a general-purpose component annotation.
@Service is commonly used for business logic classes.
@Repository is used for data access classes.
@Controller is used for MVC controllers, and @RestController is commonly used for REST APIs.
Spring can discover these classes through component scanning and manage their objects as beans.

==>What is a Spring Bean?
A Spring Bean is an object that is created, configured, and managed by the Spring IoC container.
For example, when we annotate a service class with @Service and Spring discovers it, Spring can create and manage its bean.
We can then inject that bean into other classes wherever it is required.

==>.What is the difference between IoC and DI?
IoC stands for Inversion of Control. It is a principle in which the responsibility for creating and managing objects is transferred 
from our application code to a container or framework.
DI stands for Dependency Injection. It is one way to implement IoC by providing the required dependencies to an object.
In Spring, the IoC container manages beans and injects their dependencies.
 */

/*
1. What are the types of Dependency Injection?
There are three types of Dependency Injection in Spring.
1. Constructor Injection: Dependencies are provided through a constructor. It is recommended.
2. Setter Injection: Dependencies are provided through setter methods.
3. Field Injection: Dependencies are injected directly into fields using @Autowired.
Constructor Injection is generally preferred because it makes testing easier and supports final fields.

2. Why is Constructor Injection recommended?
Constructor Injection is recommended because it makes dependencies mandatory and explicit.
It supports final fields and makes unit testing easier.
It also helps create loosely coupled and maintainable applications.

3. What is the Bean Lifecycle?
The Bean Lifecycle describes the stages of a Spring Bean.
First, Spring creates the bean and injects its dependencies.
Next, Spring initializes the bean, and it becomes ready for use.
When the application shuts down, Spring executes the configured destruction callbacks, when applicable.

4. Which annotations are used in the Bean Lifecycle?
Spring provides two important lifecycle annotations.
@PostConstruct is used to execute initialization logic after dependency injection.
@PreDestroy is used to execute cleanup logic before bean destruction, when applicable.
These annotations help us manage initialization and cleanup tasks.

5. What are the ways to create a Spring Bean?
We can register Spring Beans in different ways.
We can use @Component, @Service, @Repository, and @Controller for component scanning.
We can also use the @Bean annotation inside a @Configuration class.
Spring then manages these objects through its IoC container.

==>.What are the advantages of IoC?
The main advantages of IoC are loose coupling, easier testing, better code organization, and easier maintenance.
It centralizes object management and allows Spring to inject dependencies automatically.
As a result, applications become easier to test, modify, and maintain.
 */

/*
1. What is the difference between @Component and @Bean?
@Component is applied to a class and Spring detects it through component scanning.
@Bean is applied to a method inside a configuration class to register the object returned by that method.
@Component is commonly used for our own classes, while @Bean is useful for third-party classes or custom object configuration.

2. What are Bean Scopes in Spring?
Bean Scope defines how long a Spring Bean lives and how it is shared.

1. Singleton: One bean instance per Spring container. It is the default scope.
2. Prototype: A new bean instance is created whenever the container is asked for one.
3. Request: One bean instance per HTTP request.
4. Session: One bean instance per HTTP session.
Request and Session scopes are mainly used in web applications.

3. What are the most common Spring Boot Starters?
Spring Boot Starters simplify dependency management.
1. spring-boot-starter-web — Web applications and REST APIs.
2. spring-boot-starter-data-jpa — Database operations using JPA.
3. spring-boot-starter-security — Application security.
4. spring-boot-starter-test — Testing support.
5. spring-boot-starter-validation — Input validation.
6. spring-boot-starter-mail — Email sending.
7. spring-boot-starter-actuator — Application monitoring.
Starters reduce configuration and make development easier.

4. What is Auto-Configuration?
Auto-Configuration is a Spring Boot feature that configures beans automatically based on the application's dependencies and existing configuration.
For example, when the required web dependencies are present, Spring Boot can configure web components and an embedded server.
It reduces manual configuration and speeds up development.

5. What is an Annotation in Spring?
An annotation provides metadata that tells Spring how to process a class, method, or field.
For example, @Service identifies a service component, @Autowired supports dependency injection, and @Value injects configuration values.

6. What is the use of @Value?
@Value is used to inject values from configuration properties or other supported expressions into a Spring bean.
For example, @Value("${server.port}") can inject the configured server port into a field.

7. What is the use of @Qualifier?
@Qualifier is used to specify which bean should be injected when multiple beans of the same type are available.
It helps Spring select the required bean and avoid ambiguity.

8. What is the use of @Primary?
@Primary marks a bean as the preferred candidate when multiple beans of the same type are available for injection.
If no more specific selection is provided, Spring generally chooses the primary bean.

9. What is the difference between @Controller and @RestController?
@Controller is commonly used to handle web requests and return view names, such as HTML pages.
@RestController combines @Controller and @ResponseBody, so its methods return response data directly, usually as JSON.
It is commonly used for REST APIs.

10. What is the difference between @Primary and @Qualifier?
@Primary marks a bean as the default preferred candidate when multiple beans exist.
@Qualifier is used to select a specific bean for injection.
In simple words, @Primary provides a default choice, while @Qualifier helps specify the required bean.

11. What is Configuration in Spring Boot?
Configuration means defining application settings such as the server port, database connection, logging, and security properties.
Spring Boot allows us to keep these settings in files such as application.properties or application.yml instead of hardcoding them in Java code.

12. What is a Spring Profile?
A Spring Profile allows us to use different configurations for different environments, such as development, testing, and production.
For example, we can use application-dev.properties for development and application-prod.properties for production.
We can activate a profile using spring.profiles.active=dev.

13. How do Spring Profiles work?
When a Spring Boot application starts, it identifies the active profile.

If the active profile is dev, Spring Boot loads the general configuration along with the applicable development-specific configuration.
This allows us to use different database connections and settings for different environments without changing the application code.
 */

/*
1. What is @Profile?
The @Profile annotation registers a bean only when the specified profile is active.
For example, @Profile("dev") is used for development-specific beans.

2. What are the advantages of Spring Profiles?
Spring Profiles allow us to maintain separate configurations for development, testing, and production.
They make deployment easier and configuration management more organized.

3. What are HTTP methods?
GET retrieves data.
POST creates a resource.
PUT replaces or updates a resource.
PATCH updates specific fields.
DELETE removes a resource.

4. What is @RequestMapping?
@RequestMapping maps HTTP requests to controller classes or methods. It can define a base URL and request methods.

5. What is @GetMapping?
@GetMapping handles HTTP GET requests and is commonly used to retrieve data from the server.

6. What is @PathVariable?
@PathVariable extracts a value from the URL path.
For example, /students/10 provides the student ID 10.

7. What is @RequestParam?
@RequestParam extracts query parameters from a URL.
For example, /students?name=Kundan provides the name Kundan.

8. What is @RequestBody?
@RequestBody converts the HTTP request body, usually JSON, into a Java object.

9. What are HTTP status codes?
200 means OK.
201 means Created.
204 means No Content.
400 means Bad Request.
401 means Unauthorized.
403 means Forbidden.
404 means Not Found.
500 means Internal Server Error.

10. What are the important JpaRepository methods?
save() saves or updates an entity.
findAll() retrieves all entities.
findById() finds an entity by ID.
deleteById() deletes an entity by ID.
existsById() checks whether an entity exists.

11. What is Pageable?
Pageable is an interface used to specify pagination and sorting information, such as the page number, page size, and sorting order.

12. What is PageRequest?
PageRequest implements Pageable and creates pagination requests.
For example, PageRequest.of(0, 10) requests the first page with 10 records.

13. What are the important methods of Page?
getContent() returns the current page's records.
getTotalElements() returns the total record count.
getTotalPages() returns the total page count.
getNumber() returns the current page number.
getSize() returns the page size.

14. Explain the pagination flow.
The client sends a request containing page and size parameters.
The controller passes the pagination details to the service, which calls the repository using Pageable.
The repository retrieves the requested records, and the application returns the paginated result to the client.
 */

/*
1. What is a DTO?
DTO stands for Data Transfer Object.
It is used to transfer only the required data between the client and application layers.
DTOs help hide sensitive fields, control API responses, and separate the API structure from the database entity.
An Entity is used for persistence, whereas a DTO is used for data transfer.

2. Why do we use DTOs?
We use DTOs to hide sensitive information, avoid exposing entities directly, and return only the required data.
They also separate the API structure from the database structure and improve maintainability.

3. What is Mapping in Spring Boot?
Mapping means converting an Entity object into a DTO and a DTO into an Entity.
It helps us control which data is exposed through APIs.
For example, we can convert a User entity into a UserDTO without including the password.

4. What are the types of Mapping?
There are two common approaches to mapping.
1. Manual Mapping: We write the conversion code ourselves.
2. Automatic Mapping: We use libraries such as ModelMapper to convert objects based on matching fields
Manual mapping provides more control, while automatic mapping reduces repetitive code.

5. What is ModelMapper?
ModelMapper is a Java library used to map data between objects.
It can automatically map matching fields between an Entity and a DTO, reducing boilerplate code.
For complex conversions or sensitive fields, we should configure and verify the mapping carefully.

6. What are the advantages of Manual Mapping?
Manual Mapping provides complete control over data conversion.
It is easy to understand, customize, and debug.
It is especially useful when Entity and DTO structures differ or sensitive fields need careful handling.

7. When should we use ModelMapper?
We can use ModelMapper when Entity and DTO fields have similar names and types.
It reduces repetitive conversion code and is useful when an application contains many simple DTO conversions.

8. Can a DTO contain validation?
Yes, a DTO can contain validation annotations.
@NotBlank checks that a string is not blank.
@Email checks the email format.
@Size checks the allowed length or size.
In Spring Boot, we commonly use these annotations with @Valid in controller methods to validate incoming request data.

9. What is the typical flow when using DTOs?
In a typical Spring Boot application, the controller receives a DTO from the client.
The service processes the business logic and uses mapping to convert between DTOs and Entities when required.
The repository interacts with the database using Entities.
The application converts the result back into a DTO and returns it to the client.
 */

/*
1. What is File Upload?
File upload means sending a file from the client to a Spring Boot application, where the file can be stored locally or in cloud storage.

2. How does File Upload work?
The client sends a file using multipart/form-data.
The controller receives it as a MultipartFile, the service processes it, and the application stores it in the selected storage location.

3. What is MultipartFile?
MultipartFile is a Spring interface that represents a file uploaded through a multipart HTTP request.
It provides methods to access the filename, size, content type, and file contents.

4. What are the important MultipartFile methods?
getOriginalFilename() returns the original filename.
getSize() returns the file size in bytes.
getContentType() returns the content type.
isEmpty() checks whether the file is empty.
getBytes() returns the file contents as a byte array.
getInputStream() provides an input stream.
transferTo() transfers the uploaded file to a destination.

5. Which content type is used for file upload?
The multipart/form-data content type is commonly used to upload files through HTTP requests.

6. How do you receive an uploaded file?
We can receive an uploaded file using the @RequestParam annotation with MultipartFile in a controller method.
For example, @RequestParam("file") MultipartFile file.

7. How do you save an uploaded file?
We can use the transferTo() method to save an uploaded file to a destination.
Before saving, we should validate the file type and size and generate a safe, unique filename.

8. How do you download a file in Spring Boot?
We can download a file using ResponseEntity<Resource>.
Resource represents the file content, while ResponseEntity allows us to set HTTP headers such as Content-Type and Content-Disposition.

9. Why do we generate a unique filename?
We generate a unique filename to prevent filename collisions and reduce security risks associated with user-provided filenames.
It also helps us store multiple files safely.

10. Where should we store large files in production?
In production, large files are commonly stored in dedicated object storage, such as Amazon S3 or Cloudinary, instead of storing the entire file directly in the application database.
The database can store the file's metadata or storage reference.

1. What is Spring Boot Actuator?
Spring Boot Actuator provides production-ready endpoints for monitoring and managing a Spring Boot application.
It helps us check application health, metrics, and other operational information.

2. Why do we use Spring Boot Actuator?
We use Spring Boot Actuator to monitor application health, database connectivity, memory usage, uptime, and application metrics.
It helps developers identify operational problems in production.

3. What is the most commonly used Actuator endpoint?
The /actuator/health endpoint is commonly used to check the health status of a Spring Boot application.
It can also report the status of configured components, such as the database, when the relevant health indicators are available and enabled.
 */

/*
1. What is Spring Security?
Spring Security is a framework used to secure Spring applications through authentication and authorization.
It helps protect APIs, manage user access, and secure application resources.

2. Why do we need Spring Security?
We use Spring Security to prevent unauthorized users from accessing protected APIs.
For example, only an authorized admin should be allowed to delete student records.

3. Explain Spring Security Architecture.
When a request comes to a Spring Boot application, it first passes through the Spring Security filter chain.
Spring Security authenticates the user and checks whether the user has permission to access the requested resource.
If access is allowed, the request proceeds to the controller and the application processes it.

4. What is SecurityFilterChain?
SecurityFilterChain defines the security filters and rules applied to HTTP requests.
We use it to configure authentication, authorization, request access, and other security settings in Spring Security.

5. What is HttpSecurity?
HttpSecurity is used to configure web security in Spring Security.
It allows us to define authorization rules, login, logout, CSRF protection, and session management.

6. What is the difference between permitAll() and hasAuthority()?
permitAll() allows everyone to access a specified endpoint without authentication being required by that rule.
hasAuthority() allows access only when the user has the specified authority.

7. What is BCrypt?
BCrypt is a password-hashing algorithm used to store passwords securely.
It uses a salt and is designed to make password guessing more expensive.
A BCrypt hash is not decrypted to recover the original password; instead, the entered password is checked against the stored hash.

8. Why should passwords never be stored as plain text?
Plain-text passwords are dangerous because anyone who gains access to the database can read them directly.
We should store passwords using a strong password-hashing algorithm such as BCrypt.

9. What is SecurityContextHolder?
SecurityContextHolder provides access to the current SecurityContext.
After successful authentication, Spring Security stores the current Authentication information in the SecurityContext, which can be accessed through SecurityContextHolder.
 */

/*
30 CORS
 * 1.Cross-origin Resources Sharing
 * CORS is a browser security mechanism that controls whether a web application
 * from one origin can make requests to a server from another origin.
 * Ex-
 * Frontend
 * http://localhost:3000
 * ↓
 * ↓ API Request
 * ↓
 * Backend
 * http://localhost:8080
 * 
 * ==> What is an Origin?
 * it consists of(Protocol + host + Port)
 * 
 * ==>CSRF
 * .Protects against unwanted state-changing requests
 * .Especially important with cookie-based authentication
 * 
 * 
 * 31. GLOBAL FILTER AND INTERCEPTOR
 * Both Filter and Interceptor are used to execute common logic before or after
 * requests reach the Controller.
 * Exapmle =>
 * Logging
 * Authentication checks
 * Request validation
 * Measuring execution time
 * Adding headers
 */

/*
 * EAMIL INTEGRATION IN SPRING BOOT
 * 1.Email integration means sending emails from your Spring boot application.
 * common uses ->
 * Registration email
 * OTP
 * Password reset
 * Order confirmation
 * Notifications
 * Welcome email
 * 
 * 2.How Email Intergation works ?
 * Spring Boot Application
 * ↓
 * JavaMailSender
 * ↓
 * SMTP Server
 * ↓
 * Gmail / Outlook / Mail Server
 * ↓
 * User's Email
 * 
 * ==>what is javaMailSender ?
 * JavaMailSender is Spring's interface for sending emails.
 * Spring Boot automatically creates the JavaMailSender Bean from your mail
 * configuration.
 * 
 * ==Email Intergration Flow ?
 * User
 * ↓
 * POST /register
 * ↓
 * Controller
 * ↓
 * Service
 * ↓
 * Save User
 * ↓
 * EmailService
 * ↓
 * JavaMailSender
 * ↓
 * SMTP
 * ↓
 * User Email
 * 
 * ==> what is JavaMailMessage ?
 * Used for simple plain-text emails.
 * 
 * ==>what is MimeMessase ?
 * Used for advance emails such as HTML and attachments.
 * 
 * ==> what is MimeMessageHelper ?
 * A helper class that simplifies creating for sending email.
 */

/*
 * 36.SWAGGER /OPENAPI
 * 
 * 1. what is OpenAPI ?
 * Open Api is a specification used to describe REST APIs in a
 * standard format.
 * it describes:
 * API endpoints
 * HTTP methods
 * Request parameters
 * Request body
 * Response
 * Authentication
 * Status codes
 * 
 * 2.what is Swagger ?
 * Swagger is a set of tools used to design, document, and interact with APIs
 * based on OpenAPI.
 * Swagger UI
 * It provides a web page where you can see and test your APIs.
 * 
 * ==> why do we use Swagger in spring boot ?
 * To automatically generate interactive API documnetation and allow
 * developers to test APIs through Swagger UI.
 * 
 * ==> what is swagger UI ?
 * A web based interactive interface that display OPEnAPI documnetation and
 * allows users to sexcute API requests.
 * 
 * ==> what is @Operation ?
 * Used to describe an API operation.
 * (@operation(summary = "Get all students"))
 * 
 * 3.Advantages of Swagger/OpenAPI
 * Automatic API documentation
 * Interactive API testing
 * Easy for frontend developers
 * Shows request/response structures
 * Documents parameters
 * Documents status codes
 * Supports authentication documentation
 * Reduces manual API documentation
 */

/*
 * 37.Testing --JUNIT & MOCKITO
 * 
 * 1.what is Testing ?
 * 
 * 2.why do we need Testing ?
 * 
 * 3.what is a JUnit ?
 * JUnit is a Java testing framework.
 * It is used to write and execute test cases.
 * 
 * 4.what is Mockito ?
 * Mockito is a mocking framework used to create fake/mock dependecy
 * during tsting.
 * When testing StudentService, we don't want to access the real database
 * 
 * 5.what is @Mock ?
 * Create a Mockito mock object
 * 
 * @Mock
 * StudentRepository repository;
 * 
 * 6.what is @InjectMocks ?
 * Creates the class under test and injects the available mocks into it.
 * 
 * 7.What is when()?
 * Defines the behavior of a mock.
 * Ex-
 * when(repository.findById(1L))
 * .thenReturn(Optional.of(student));
 * 
 * 
 * 8.Most importatnt interview answer
 * JUnit is used to write and run test cases, while Mockito is used to mock
 * dependencies. In a Spring Boot service unit test, we commonly use @Mock for
 * the repository, @InjectMocks for the service, when() to define mock behavior,
 * verify() to check interactions, and JUnit assertions to verify the result.
 * 
 */

/*
 * 38.EXCEPTION HANDLING IN SPRING BOOT
 * 
 * In Spring Boot, I mainly handle exceptions using @RestControllerAdvice
 * and @ExceptionHandler.
 * 
 * @ExceptionHandler is used to handle a specific exception,
 * while @RestControllerAdvice allows us to handle exceptions globally across
 * all controllers.
 * 
 * For business-specific errors, I create custom exceptions by extending
 * RuntimeException. For example, if a user is not found, I can create a
 * UserNotFoundException.
 * 
 * Then, in the global exception handler, I catch that exception and return an
 * appropriate HTTP status such as 404 Not Found, along with a meaningful error
 * message.
 * 
 * I also handle validation exceptions such as MethodArgumentNotValidException
 * and return the validation errors to the client.
 * 
 * This keeps exception-handling logic separate from controller logic and
 * provides a consistent error response throughout the application.”**
 * 
 * // Custom Exception
 * public class UserNotFoundException extends RuntimeException {
 * 
 * public UserNotFoundException(String message) {
 * super(message);
 * }
 * }
 * 
 * // Global Exception Handler
 * 
 * @RestControllerAdvice
 * public class GlobalExceptionHandler {
 * 
 * @ExceptionHandler(UserNotFoundException.class)
 * public ResponseEntity<String> handleUserNotFound(
 * UserNotFoundException ex) {
 * 
 * return ResponseEntity
 * .status(HttpStatus.NOT_FOUND)
 * .body(ex.getMessage());
 * }
 * }
 * 
 * public User getUser(int id) {
 * 
 * return repository.findById(id)
 * .orElseThrow(() ->
 * new UserNotFoundException("User not found"));
 * }
 * 
 * User requests /users/10
 * ↓
 * Controller
 * ↓
 * Service
 * ↓
 * User not found
 * ↓
 * UserNotFoundException
 * ↓
 * 
 * @RestControllerAdvice
 * ↓
 * 404 NOT FOUND
 * 
 * “Why do we use global exception handling?”, say:
 * We use global exception handling to avoid writing the same try-catch or
 * exception-handling code in every controller. It centralizes exception
 * handling and gives consistent API responses.”
 * 
 * 
 * =15. Interviewer: Your API is returning 500 Internal Server Error. How will
 * you debug it?
 * .Check the Spring Boot console/logs.
 * .Check the complete exception and stack trace.
 * .Check the API URL and HTTP method.
 * .Check request JSON.
 * .Check Controller.
 * .Check Service
 * .Check Repository.
 * .Check database connection.
 * ,Check whether required data exists.
 * .Test the API again using Postman.
 * 
 * 19. Interviewer: Your frontend is React and backend is Spring Boot. Frontend
 * is getting a CORS error. What will you do?
 * -->I would configure CORS in Spring Boot.
 * @CrossOrigin(origins = "http://localhost:3000")
 */
 
