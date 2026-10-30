/*
 * DAY1
 * 1.What is Hibernate?
 * Hibernate is an ORM framework for Java. It maps Java objects to database
 * tables and reduces the need to write SQL queries manually.
 * 
 * ==> What is ORM?
 * Object Relational Mapping
 * Break it down:
 * Object → Java object
 * Relational → Database table
 * Mapping → Connecting the two
 * ORM is a technique that maps Java objects with database tables. Hibernate is
 * one of the popular ORM frameworks.
 * 
 * ==>Why do we use Hibernate?
 * Without Hibernate, we generally write JDBC code:
 * We also need SQL:
 * With Hibernate, we can work with Java objects:
 * Hibernate generates the required SQL internally.
 * 
 * ==>benefits
 * Less SQL/JDBC boilerplate
 * Maps Java objects to tables
 * Provides CRUD operations
 * Supports relationships
 * Provides transaction management integration
 * Supports caching
 * Database-independent query capabilities through HQL/JPQL
 * 
 * ==>Hibernate Architecture
 * Java Application
 * ↓
 * Hibernate
 * ↓
 * ORM
 * ↓
 * JDBC
 * ↓
 * Database
 * 
 * ==> what is @Entity ?
 * 
 * @Entity tells Hibernate:This Java class should be mapped to a database
 * table."
 * 
 * @Entity marks a Java class as a persistent entity that Hibernate maps to a
 * database table.
 * 
 * ==>What is @Id?
 * This field is the primary key of the table."
 * 
 * ==>Hibernate Session
 * A connection/work area between your Java application and Hibernate for
 * performing database operations.
 * Session is used to perform database operations such as save, find, update and
 * delete.
 * .Session session = sessionFactory.openSession();
 * 
 * ==>SessionFactory
 * SessionFactory is used to create Hibernate Session objects.
 * 
 * =>SessionFactory is a heavyweight, thread-safe object used to create
 * Hibernate Sessions. Normally, an application maintains one SessionFactory for
 * a database configuration.
 * 
 * ==>Hibernate in Spring Boot
 * In modern Spring Boot applications, we normally don't manually create
 * SessionFactory and Session
 * We commonly use:
 * Spring Data JPA + Hibernate
 */
/*
 * DAY2
 * 1.@Entity
 * 
 * @Entity tells Hibernate that a Java class should be mapped to a database
 * table.
 * 
 * =>@Table
 * 
 * @Table is used when we want to customize the table name.
 * 
 * =>@GeneratedValue
 * Instead of manually assigning IDs, we can let the database generate them.
 * 
 * =>Entity Relationships
 * .There are four major relationships:
 * 
 * @OneToOne
 * 
 * @OneToMany
 * 
 * @ManyToOne
 * 
 * @ManyToMany
 * 
 * =>@OneToOne represents a relationship where one entity is associated with one
 * other entity.
 * 
 * @OneToMany represents a relationship where one entity is associated with
 * multiple entities.
 * Ex.One department has many students.
 * 
 * =>@ManyToOne represents a relationship where many entities are associated
 * with one entity.
 * Ex.Many students belong to one department.
 * 
 * =>@ManyToMany
 * 
 * @ManyToMany represents a relationship where multiple entities are associated
 * with multiple other entities.
 * 
 * =>mappedBy tells JPA that the relationship is managed by the field on the
 * other entity.
 */

/*
 * DAY3 ======Entity Lifecycle & CRUD Operations=========
 * 
 * 1.What is Entity Lifecycle?
 * "First, when I create a new Java object, it is in the transient
 * state. When I call persist(), Hibernate starts managing the object
 * and it becomes persistent. If I detach it, it becomes detached and
 * Hibernate stops tracking it. I can use merge() to bring its state
 * back into a managed entity. Finally, I can use remove() to mark
 * the managed entity for deletion."
 * 
 * ==>Persistence Context
 * Persistence Context is the environment in which JPA/Hibernate manages entity
 * objects
 * and tracks their state changes.
 * 
 * ==>Dirty Checking
 * Hibernate automatically detects changes in managed entities and
 * synchronizes those changes with the database.
 */

/*
 * DAY-4 =======CRUD with Spring Boot + MySQL===============
 * 
 * ==>Explain how a request is processed in your Spring Boot CRUD application.?
 * "First, the client sends an HTTP request to the Controller. The Controller receives 
 * the request and calls the Service layer. The Service contains the business logic
 *  and calls the Repository. The Repository uses Spring Data JPA, which uses Hibernate
 *  as the ORM implementation. Hibernate generates SQL and communicates with the database 
 * through JDBC."
 * 
 * ==>"Why do we use JpaRepository?"
 * "JpaRepository provides ready-made CRUD operations such as save, findAll, findById 
 * and deleteById. It reduces boilerplate code and internally uses JPA, with Hibernate 
 * commonly acting as the JPA implementation."
 * 
 * ==>What is JpaRepository?
 * It is a Spring Data interface that provides common CRUD and JPA-related operations for an entity.
 * 
 * ==>Does Spring Data JPA itself execute SQL?
 * Spring Data JPA provides the repository abstraction. The JPA provider, commonly Hibernate, generates 
 * and executes the SQL.
 * 
 * ==>What is ddl-auto=update?
 * It tells Hibernate to update the database schema based on the entity mappings.
 * 
 * ==>What is @PathVariable?
 * It extracts a value from the URL.
 */

/*
DAY 5

1.What is @JoinColumn?
It specifies the foreign-key column used to join two entities.

2.What is mappedBy?
It identifies the field on the other entity that manages the relationship

3.What is a bidirectional relationship?
A relationship where both entities have references to each other.

4.What is cascade?
Cascade controls whether operations on one entity are propagated to its related entities.

5.What is FetchType.LAZY?
It delays loading related data until it is needed.

==>What is FetchType.EAGER?
It loads related data eagerly when the entity is loaded.

=>What is a many-to-many relationship?
A relationship where multiple records on both sides can be associated with each other.

=>What is a junction table?
A separate table used to store relationships between two entities in a many-to-many relationship

 */

/*
DAY 6
What is JPQL?
JPQL is an object-oriented query language used to query JPA entities rather than database tables directly.

==>Difference between SQL and JPQL?
SQL works with database tables and columns, while JPQL works with entities and their fields.

==>What is @Query?
@Query is used to define a custom query on a Spring Data repository method.

=>What is a derived query?
It is a query automatically generated by Spring Data JPA based on the repository method name.

=>What is Pageable?
Pageable represents pagination information such as page number, page size, and sorting.

==>What is pagination?
Pagination divides a large result set into smaller pages so that we don't retrieve all records at once.

=>What is Sort?
Sort is used to specify the sorting field and direction of query results.

=>What is @Param?
@Param binds a Java method parameter to a named parameter in a JPQL query.
 */
