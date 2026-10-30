/*
 *
 * 6. What is JDBC ?
 * JDBC (Java Database Connectivity) is a standard Java API used to connect Java
 * applications with relational databases such as MySQL, PostgreSQL, Oracle, and
 * SQL Server. It provides interfaces and classes to execute SQL statements and
 * process results.
 * 
 * ==>What Can JDBC Do?
 * Using JDBC you can:
 * Connect to a database
 * Create tables
 * Insert records
 * Update records
 * Delete records
 * Retrieve records
 * Execute stored procedures
 * Manage transactions
 * Process query results
 * 
 * ==>+----------------------+
 * | Java Application |
 * +----------------------+
 * │
 * ▼
 * +----------------------+
 * | JDBC API |
 * +----------------------+
 * │
 * ▼
 * +----------------------+
 * | JDBC Driver |
 * +----------------------+
 * │
 * ▼
 * +----------------------+
 * | Database (MySQL etc.)|
 * +----------------------+
 * 
 * ==>JDBC Workflow
 * Load Driver
 * ↓
 * Create Connection
 * ↓
 * Create Statement
 * ↓
 * Execute SQL Query
 * ↓
 * Get Result
 * ↓
 * Close Resources
 * 
 * 7.What is the role of the JDBC driver?
 * Answer: The JDBC driver translates JDBC API calls into database-specific
 * commands so the database can understand and execute them.
 * 
 * ==>. What are the steps of a JDBC program?
 * Load the JDBC driver
 * Create a database connection
 * Create a Statement or PreparedStatement
 * Execute the SQL query
 * Process the ResultSet (if applicable)
 * Close all resources
 * 
 * 8.
 * 
 * 1. What is CallableStatement in JDBC ?
 * CallbaleStatement is an inteface in jdbc used to call Stored Prodecdure
 * and store Function that are already created in the database
 * it is part of java.sql.pacjage.
 * 
 * ==>.why do we use CallableStatmenet ?
 * Instead of writing sql queries in java,you can call a
 * procedure that already exist in the database.
 * .Faster execution(prcompiled in the database)
 * .Better security
 * .Reusable SQL Logic
 * .less javacode
 * 
 * ==>.What is a Stored Procedure?
 * A stored procedure is a precompiled set of SQL statements stored in the
 * database. It is used to perform specific tasks and can be executed multiple
 * times.
 * .it uses this to call- Uses prepareCall()
 * 
 * => It support
 * 1-> IN Parameter (Passes a value from java to the database)(CREATE PROCEDURE
 * GetEmployee(IN empId INT))
 * 2-> OUT parameter (Returns a value from the database to Java.)
 * 3.->INOUT (Acts as both input and output).
 * 
 * 
 * 2.BATCH PROCESSING IN JDBC
 * Batch Processing is a jdbc festures that allow you to execute multiple sql
 * statment together in a single database call.instead of
 * executing them one by one.
 * It imporves performance by reducing communication bteween
 * the java aplication and the database.
 * It returns an int[] array where each element represents the number of rows
 * affected by the corresponding SQL statement.
 * 
 * ==>When Do We Use Batch Processing?
 * .insert thousands of records
 * .Updata multiple recordds
 * .import data from Excel
 * .Bank transaction
 * 
 * =>jdbc batch Methods
 * ->addBatch()
 * ->executeBatch()
 * ->clearBatch()
 * 
 * 3.WHAT IS PREPAREDsTATEMENT
 * PreparedStatement is a JDBC interface used to execute parameterized SQL
 * queries. It uses ? placeholders instead of hardcoded values. It is faster
 * because the query is precompiled, more secure because it prevents SQL
 * Injection, and is ideal when the same query needs to be executed multiple
 * times with different values.
 * 
 * ==>Why do we use PreparedStatement?
 * .prevents sql injection attacks
 * .faster because the sql query is precompiled.
 * .easy to execute the same query multple time with different values
 * .improve code redability.
 * 
 * 4.STATEMENT
 * Statement is a jdbc interface that is used to execute static sql queries.The
 * sql
 * query is written directly in the java code and sent to the
 * database for excution
 * ==> Methods of statement
 * .executeQuery() -> Execute select query
 * .executeUpdate() -> Execute Insert,update ,delete
 * .execute() -> Execute any sql statement
 * close() -> close the statment
 * 
 * ==>Disadvantages
 * Vulnerable to SQL Injection.
 * Query is compiled every time it executes.
 * Slower than PreparedStatement for repeated queries.
 * Cannot pass parameters (? placeholders are not supported).
 * 
 * 5. WHAT IS RESULTSET ?
 * ResultSet is an interface in jdbc that stores the data returned
 * by a SELECT query.It allows us to read one row at a time from
 * the database.
 * -> when a resultSet is created the cursor is beofre the first row.
 * next()
 * Moves the cursor forward by one row.
 * 
 * ==> types of resultSet
 * 1.Forward Only(default) -> Moves only forward.
 * 2.Scrollable ResultSet -> allows forward and backward movement.
 * 
 * 
 * 6.What is Transaction ?
 * A transaction is a group of one or more SQL statment that are exceuted as a
 * single
 * unit of work
 * -> if all statment succeed -> save the changes(commint)
 * -> if any statmenet fail -> Rollback
 * 
 * ==>Transaction Methods in jdbc
 * ..setAutoCommit(false) -------starts manual transation
 * ..commit() ------- save changes permanently
 * ..roolback() -------- undo all changes
 * .. setAutoCommit(true) ----- back to default mode
 * 
 * ==> SavePoint
 * Sometimes we don't want to rollback the entire transaction.
 * We want to rollback from a particular point.
 * JDBC provides Savepoint.
 * 
 * 7.ACID Properties
 * ACID is a set of four properties that guarantee a database transaction is
 * processed correctly, reliably, and safely, even if there is a system failure.
 * 
 * 1.Atomicity (Either the entire transaction executes successfully or nothing
 * happens.)
 * 2.Consistency (A transaction moves the database from one valid state to
 * another valid state.)
 * Database rules must never be violated.
 * 3.Isolation (Multiple transactions execute independently without interfering
 * with each other.)
 * 4.Durabiblty (Once a transaction is committed, the changes are permanent,
 * even if the system crashes.)
 */

/*
 * 8.BLOB ?
 * BLOB is used to store large binary data such as images, videos and PDFs,
 * whereas CLOB is used to store large character/text data such as documents,
 * articles, XML and JSON.
 * BLOB is used to store binary data, such as:
 * Images
 * Videos
 * Audio files
 * PDF files
 * Word/Excel files
 * Other binary files
 * 
 * 9.WHAT IS CLOB ?
 * clob is used to store large text/character data.
 * Ex->Large articles
 * Books
 * XML
 * JSON
 * Logs
 * Large descriptions
 * Documents containing text
 */