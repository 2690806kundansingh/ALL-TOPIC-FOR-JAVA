/*
 * 1. what is primary difference between SQL and PL/SQL ?
 * SQL is a declarative language used to perform database operations, while
 * PL/SQL is Oracle's procedural extension of SQL used to write programs
 * containing variables, conditions, loops, procedures, and functions.
 * 
 * 
 * Structured Query Language-- Procedural Language/SQL
 * Mainly executes one query at a time ---Can execute multiple SQL statements
 * together
 * Used to retrieve/manipulate data--- Used to write business logic
 * No variables, loops, IF-ELSE in normal SQL---- Supports variables, IF-ELSE,
 * loops, etc.
 * Example: SELECT, INSERT, UPDATE, DELETE ----Example: Procedures, Functions,
 * Triggers, Cursors
 * 
 * 2.what is the main difference between Primary key,Unique key and foreign key
 * ?
 * Primary Key uniquely identifies each record in a table and cannot contain
 * NULL or duplicate values. Unique Key is used to ensure that a column contains
 * unique values, such as email or phone number. Foreign Key is used to
 * establish a relationship between two tables by referring to a key in another
 * table. Unlike Primary and Unique Keys, Foreign Key values can be repeated
 * because multiple records can belong to the same parent record.
 * 
 * 3. JOIN ?
 * A JOIN is used to combine data from two or more tables based on a related
 * column.
 * 
 * 1.INNER JOIN
 * INNER JOIN returns only the records that match in both tables.
 * INNER JOIN = matching records from both tables
 * SELECT e.name, d.dept_name
 * FROM Employee e
 * INNER JOIN Department d
 * ON e.dept_id = d.dept_id;
 * 
 * 2.LEFT JOIN
 * LEFT JOIN returns all records from the LEFT table and matching records from
 * the RIGHT table.
 * SELECT e.name, d.dept_name
 * FROM Employee e
 * LEFT JOIN Department d
 * ON e.dept_id = d.dept_id;
 * 
 * 3.RIGHT JOIN returns all records from the RIGHT table and matching records
 * RIGHT JOIN = everything from right + matching data from left
 * from the LEFT table.
 * SELECT e.name, d.dept_name
 * FROM Employee e
 * RIGHT JOIN Department d
 * ON e.dept_id = d.dept_id;
 * 
 * 4.FULL OUTER JOIN
 * FULL OUTER JOIN returns everything from both tables.
 * It includes:
 * Matching records
 * Unmatched records from left
 * Unmatched records from right
 * 
 * SELECT e.name, d.dept_name
 * FROM Employee e
 * FULL OUTER JOIN Department d
 * ON e.dept_id = d.dept_id;
 * 
 * Note: MySQL does not directly support FULL OUTER JOIN; it is commonly
 * simulated using LEFT JOIN + RIGHT JOIN with UNION.
 * 
 * 5.CROSS JOIN
 * CROSS JOIN creates every possible combination of rows from both tables.
 * SELECT e.name, d.dept_name
 * FROM Employee e
 * CROSS JOIN Department d;
 * 
 * 6.SELF JOIN
 * A SELF JOIN means joining a table with itself.
 * Both refer to the same table, but we give them different aliases.
 * SELECT
 * e.name AS employee,
 * m.name AS manager
 * FROM Employee e
 * LEFT JOIN Employee m
 * ON e.manager_id = m.emp_id;
 * 
 * 
 * 3. What is Normalization and How does it work ?
 * It is the process of designing database tables to minimise the data
 * redudency is called normalisation .
 * ->we need to divide a database into two or more tables and define
 * relationship between users.
 * 
 * Types of Normalization ?
 * 1.1NF(first normal form)
 * Each column contains atomic/single values
 * There are no multiple values in one cell
 * There are no repeating groups
 * 
 * 2.2NF(Second normal form)
 * A table is in 2NF if the following consition hold true ..
 * .The table is in 1NF.
 * .2NF means there should be no partial dependency on a composite key.
 * Example -> a school stores the data about the teachers and the
 * subject they teach. A teacher can teach more than one subject
 * 
 * 
 * 3.3NF-Third Normal Form ?
 * .The table in 2NF.
 * .Non-key columns should depend only on the Primary Key, not on another
 * non-key column.
 * 
 * ==> why Normalization is important
 * ->Data redundancy.
 * ->Update anomly-If department name changes, we may need to update many rows.
 * ->Insert Anomly-We may not be able to insert department information unless an
 * employee exists.
 * ->Delete anomly -Deleting the last employee of a department could
 * accidentally remove the only information about that department.
 * 
 * 
 * Normal Form Main Idea
 * 1NF ---One cell → one value
 * 2NF ---No partial dependency
 * 3NF---- No transitive dependency
 * BCNF--- Stronger version of 3NF
 * BCNF stands for Boyce-Codd Normal Form. It is a stronger version of Third
 * Normal Form. A table is in BCNF if, for every functional dependency A → B, A
 * is a super key. BCNF is used to remove certain redundancy and dependency
 * problems that may still remain after applying 3NF.
 * 
 * Normalization is a database design technique used to organize data into
 * multiple related tables. Its main purpose is to reduce data redundancy and
 * prevent insert, update, and delete anomalies. The commonly used normal forms
 * are 1NF, 2NF, and 3NF. In 1NF, each cell contains a single value; in 2NF,
 * partial dependency is removed; and in 3NF, transitive dependency is removed.
 * 
 * Question No.6
 * What is the difference between a superkey and the candidate key ?
 * =>A Super Key is any combination of one or more columns that can uniquely
 * identify a row in a table.
 * Student_ID
 * Student_ID + Name
 * Student_ID + Email
 * 
 * ==> A Candidate Key is a minimal Super Key, meaning it can uniquely identify
 * a row without any unnecessary column.
 * Student_ID
 * Email
 * 
 * 
 * Question No.7
 * what is deifferent type of statement available in sql ?
 * In SQL, statements are mainly divided into 5 types. This is a very
 * common interview question.
 * 1.DDL(Data Definition Language)
 * =>DDL is used to create or change the structure of database objects, such as
 * tables.
 * CREATE
 * ALTER
 * DROP
 * TRUNCATE
 * 
 * 2.DML(Data Manipulation Language)
 * DML is used to insert,modify,and delete data inside tables.
 * INSERT
 * UPDATE
 * DELETE
 * 
 * 3.DQL -(Data Query language)
 * DQL is used to retireive data from the database
 * .SELECT
 * 
 * 4.DCl-(Data Control Language)
 * DCL is used to control user permission/access to the database
 * GRANT
 * REVOKE
 * 
 * 5.TCL(Transaction Control Language)
 * TCl is used to manage transactions.
 * COMMIT(Permanently saves the transaction.)
 * ROLLBACK(Undo changes since the relevant transaction boundary.)
 * SAVEPOINT(Creates a point to which you can roll back. 50 50 commit and
 * roolback)
 * 
 * 6.what is the common properties of database transaction ?
 * The common properties of a database transaction are called ACID properties.
 * 1. Atomicity
 * Atomicity means: either the complete transaction happens, or nothing happens.
 * Both operations successful → COMMIT
 * OR
 * Any operation fails → ROLLBACK
 * Atomicity = All or Nothing
 * 
 * 2. Consistency
 * Database rules must always be maintained
 * The database rules and constraints must remain valid.
 * 
 * 3. Isolation
 * Isolation means that multiple transactions running at the same time should
 * not incorrectly interfere with each other.
 * Isolation = Transactions should not interfere incorrectly with each other
 * 
 * 4. Durability
 * Durability means that once a transaction is successfully committed, its
 * changes are permanently saved.
 * After COMMIT, even if the database/server crashes, the committed change
 * should not be lost.
 * 
 * The common properties of a database transaction are ACID properties:
 * Atomicity, Consistency, Isolation, and Durability. Atomicity ensures all
 * operations of a transaction succeed or none do. Consistency ensures database
 * rules and constraints are maintained. Isolation ensures concurrent
 * transactions do not interfere incorrectly with each other. Durability ensures
 * that committed changes are permanently stored even after a system failure.
 * 
 * 10.different between delete transaction and drop ?
 * Delete -> it is a DML element.
 * .it is applied on filter based on an optional where cluse to identify
 * rows that will get deleted.
 * DELETE is used to remove rows/data from a table.
 * You can also delete all rows:
 * 
 * TRUNCATE ->TRUNCATE is used to remove all rows from a table quickly.
 * TRUNCATE TABLE Student;
 * DDL command in many database systems
 * Removes all rows
 * Cannot use WHERE
 * Table structure remains
 * 
 * DROP ->DROP removes the entire table, including its structure and data.
 * DROP TABLE Student;
 * DDL command
 * Removes data and table structure
 * Table no longer exists
 * WHERE cannot be used
 * 
 * DELETE → Remove rows
 * TRUNCATE → Empty the table
 * DROP → Remove the table
 * 
 * Question No.11
 * what is an Index ? Explain the different types of index.?
 * An Index is a database object that helps the database find data faster
 * without scanning the entire table.
 * 
 * ==> types of index
 * 1.Primary Index(Efficient access using primary key)
 * 2.unique index (Prevent duplicate indexed values)
 * 3.Composite index (Index multiple column)
 * 4.Clustered index (Organaise table data around index key)
 * 5.Full text Index(searh words in text)
 * 6.Function-based index(Index calculated/function result)
 * 
 * Question No.12
 * What is the perpose of a subquery in sql ?
 * =>A subquery is a query written inside another sql query.
 * it main perpose is to use the rsult of one query as input for
 * another query
 * SELECT name, salary
 * FROM Employee
 * WHERE salary > (
 * SELECT AVG(salary)
 * FROM Employee
 * );
 * 
 * =>Why do we use Subqueries?
 * .To use the result of another query
 * .To compare data with another set of data
 * .To check whether matching records exist
 * 
 * ==> Types of Subquery ?
 * 1.Single-row subquery(return one value)
 * SELECT *
 * FROM Employee
 * WHERE salary > (
 * SELECT AVG(salary)
 * FROM Employee
 * );
 * 
 * 2.Multiple-row subquery(return multiple row)
 * usaually used with IN ANY ALL
 * SELECT name
 * FROM Employee
 * WHERE dept_id IN (
 * SELECT dept_id
 * FROM Department
 * WHERE location = 'Delhi'
 * );
 * 
 * 3.Correlated Subquery(A correlated subquery depend on the current row of the
 * outer query)
 * SELECT e.name, e.salary
 * FROM Employee e
 * WHERE e.salary > (
 * SELECT AVG(e2.salary)
 * FROM Employee e2
 * WHERE e2.dept_id = e.dept_id
 * );
 * 
 * Question No.13
 * what is Constraint ? Explain the different constraints vailbale in
 * sql ?
 * 
 * A constraint is a rule applied to a table or column to control what data can
 * be stored in the database.
 * Constraints make sure that only valid and correct data is inserted into a
 * table.
 * 
 * ==>Types of sql Constraints
 * NOT NULL(means a column must have a value.)
 * CREATE TABLE Student (
 * student_id INT NOT NULL,
 * name VARCHAR(50) NOT NULL
 * );
 * UNIQUE(ensures that values in a column cannot be duplicated.)
 * CREATE TABLE Student (
 * student_id INT,
 * email VARCHAR(100) UNIQUE
 * );
 * PRIMARY KEY(is used to uniquely identify every row in a table.)
 * 
 * FOREIGN KEY(is used to create a relationship between two tables.)
 * CREATE TABLE Employee (
 * emp_id INT PRIMARY KEY,
 * name VARCHAR(50),
 * dept_id INT,
 * FOREIGN KEY (dept_id)
 * REFERENCES Department(dept_id)
 * );
 * CHECK(ensures that data satisfies a specific condition.)
 * 
 * DEFAULT(automatically provides a value when the user doesn't supply a value.)
 * 
 * Question No.14
 * What is different between Union and Union All ?
 * =>Both UNION and UNION ALL are used to combine the results of two or more
 * SELECT queries.
 * The main difference is:
 * UNION removes duplicate rows, while UNION ALL keeps duplicate rows.
 * SELECT name FROM Employee_1
 * UNION
 * SELECT name FROM Employee_2;
 * 
 * Question No.15.
 * what is stored procedure discuss the advantage and disadvantage
 * A Stored Procedure is a predefined group of SQL statements stored inside the
 * database that can be executed whenever needed.
 * Instead of writing the same SQL queries again and again, we can store them as
 * a procedure and call the procedure.
 * 
 * DELIMITER //
 * 
 * CREATE PROCEDURE GetEmployee(IN empId INT)
 * BEGIN
 * SELECT *
 * FROM Employee
 * WHERE emp_id = empId;
 * END //
 * 
 * DELIMITER ;
 * 
 * ==>Advantage
 * 1.Code Reuseability(A procedure can be created once and called many times)
 * CALL GetEmployee(101);
 * CALL GetEmployee(102);
 * CALL GetEmployee(103);
 * You don't have to rewrite the SQL each time.
 * 
 * 2.Better Security
 * 3.Reduce Network traffic
 * 4.Centralized Bussiness Logic(Some database-related logic can be kept inside
 * the database.)
 * 
 * ==>Disadvantage of sotred procedures
 * 1.Database Dependency
 * 2. Difficult to Maintain for Large Logic
 * 3.Testing Can Be More Difficult
 * 
 * Question No.16
 * What is view ? what are its advantage and disadvantage ?
 * A view is a virtual table based on result of sql query.It is
 * mainly used for security,data abstaraction,simplify complex
 * ,and providing reusable access to data
 * 
 * ==> advantage of view...
 * .A view can restrict access to sensitive column
 * .Simplify Complex queries(If a query contains multiple joins and conditions,
 * we can save it as a view.)
 * .data abstraction
 * ==>Users don't need to know the structure of the underlying tables.
 * They interact with the view instead of directly interacting with multiple
 * tables.
 * .Reusability
 * ==> Once a view is created,it can be reused multiple times.
 * 
 * ==> disadcantage of views
 * .Perofrmance
 * For a complex view involving many joins, performance can be slower.
 * .Restriction on Modification
 * Not every view can be used for INSERT, UPDATE, or DELETE.
 * .. Complex Views Can Be Difficult to Maintain
 * 
 * Question No.17
 * List the built-in functions available in sql ?
 * 1.Aggregate Functions(These functions operate on multiple rows and return a
 * single result.)
 * count(),sum(),avg()
 * max(),min()
 * 
 * 2.String/Character Function(Used to manipulate text values)
 * Upper(),lower(),length(),concat()
 * substring(),trim(),replace()
 * 
 * 3.Numeric functions
 * ABS(),ROUND(),CEIL/CEILING(),FLOOR(),
 * MOD(),
 * POWER(),SqRT()
 * 
 * 4.DAte and time function(used to work with dates and times)
 * CURRENT_DATE(),CURRENT_TIME,CURRENT_TIMESTAMP
 * ,EXTRACT(),DATE_ADD(),DATE_SUB()
 * 
 * 5.cConversion Functions
 * Used to convert data from one datatype to another
 * .CAST(),CONVERT()
 * 
 * Question NO.18
 * what is triggers? what are its benefits ? Can we invoke a trigger explicitly
 * ?
 * =>A trigger is a special type of stored program that is automatically
 * executed by the database when a specified event occurs on a table or view.
 * Common events are:
 * INSERT
 * UPDATE
 * DELETE
 * A trigger can execute BEFORE or AFTER the event, depending on the database
 * system.
 * No, normally a trigger cannot be invoked explicitly like a stored procedure.
 * it is automatically fired when its associated event occurs.
 * 
 * Question No.19
 * =>Top
 * .It specify the number of record to return.This clause is available
 * for large tables with thousands of records
 * SELECT TOP number column1, column2
 * FROM table_name;
 * 
 * ==>Group BY
 * The GROUP BY clause is used to group rows that have the same values in one or
 * more columns.
 * It is mainly used with aggregate functions such as:
 * count(),sum(),avg(),max()
 * 
 * ==>Having
 * The HAVING clause is used to filter groups of records created by the GROUP BY
 * clause.
 * It is mainly used with aggregate functions such as COUNT(), SUM(), AVG(),
 * MAX(), and MIN().
 * 
 * ==>Union
 * UNION is a set operator used to combine the results of two or more SELECT
 * queries into a single result set while removing duplicate rows.
 * 
 * ==> Between
 * BETWEEN is a SQL operator used to check whether a value lies within a
 * specified range. It is inclusive, meaning the lower and upper boundary values
 * are included.
 * 
 * Question No.20
 * what is the perpose of isolation levels in sql ?
 * ==> Isolation level tells us how much one transaction should be
 * separate from another transaction when multiple transaction run at same time.
 * 
 * Suppose Transaction A is updating an employee's salary, while Transaction B
 * is reading that salary.
 * Isolation level decides:->
 * Can Transaction B see Transaction A's changes before A commits?
 * 
 * ==> why do we use isolation levels ?
 * They are used to prevent problems when multiple transactions work on the
 * database at the same time.
 * 
 * ==>Four Main Isolation Levels:
 * Isolation Level Simple Meaning
 * Read Uncommitted --Can read uncommitted data
 * Read Committed --Can read only committed data
 * Repeatable Read-- Same row gives consistent result during transaction
 * Serializable-- Transactions behave almost like they run one by one
 * 
 */