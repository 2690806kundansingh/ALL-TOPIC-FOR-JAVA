/*
 * 1.Explain how Java works internally from writing code to execution.
 * When we write Java code, it is called source code and saved with .java
 * extension.
 * 
 * 1️⃣ First, we use the javac command.
 * The Java compiler converts the source code into bytecode.
 * Bytecode is saved as a .class file.
 * 
 * 2️⃣ This bytecode is platform-independent (Write Once, Run Anywhere).
 * 
 * 3️⃣ When we run the program using the java command,
 * the JVM (Java Virtual Machine) loads the bytecode into memory.
 * 
 * 4️⃣ JVM converts the bytecode into machine code according to the operating
 * system using:
 * 
 * Interpreter
 * 
 * JIT (Just-In-Time) Compiler
 * 
 * 5️⃣ Finally, the program executes.
 * 
 * 2. What is the difference between JDK, JRE, and JVM?
 * JDK (Java Development Kit)
 * JDK is used to develop Java applications.
 * It contains:
 * 
 * JRE
 * 
 * Compiler (javac)
 * 
 * Debugger
 * 
 * Development tools
 * 
 * So, JDK = JRE + Development Tools.
 * 
 * JRE (Java Runtime Environment)
 * JRE is used to run Java applications.
 * It contains:
 * 
 * JVM
 * 
 * Libraries
 * 
 * Supporting files
 * 
 * But it does NOT contain compiler.
 * 
 * JVM (Java Virtual Machine)
 * JVM is responsible for:
 * 
 * Loading bytecode
 * 
 * Verifying bytecode
 * 
 * Converting bytecode into machine code
 * 
 * Executing the program
 * 
 * JVM makes Java platform-independent.
 * 
 * 🎯 Simple Formula (Very Important for Interview)
 * 
 * JDK = JRE + Compiler + Tools
 * 
 * JRE = JVM + Libraries
 * 
 * JVM = Converts bytecode to machine code
 * 
 * 3. 👉 “Can we run Java program without JDK?”
 * yes,we can using JRE only,but to develop/compile we need jdk
 * 
 * 4. Why is Java called Platform Independent?
 * Java is called platform independent because it does not convert source code
 * directly into machine code.
 * 
 * Instead:
 * 
 * 1️⃣ Java source code is compiled into bytecode using javac.
 * 2️⃣ This bytecode is platform-independent.
 * 3️⃣ The bytecode runs on JVM (Java Virtual Machine).
 * 4️⃣ Each operating system has its own JVM implementation.
 * 
 * That is why Java follows:
 * 
 * Write Once, Run Anywhere (WORA)
 * 
 * So the same .class file can run on Windows, Linux, or Mac without changing
 * the code.
 * 
 * "Platform independence is achieved because Java uses JVM as an abstraction layer between bytecode and operating system."
 * 
 * 5. what is the different between java comand and javac command ?
 * javac Command
 * 
 * javac is the Java compiler.
 * It converts source code (.java file) into bytecode (.class file).
 * java Command
 * 
 * java is used to run the program.
 * 
 * It executes the .class file.
 * 
 * 5.what do we install to run java ?
 * we install JDK(java Development kit)
 * jdk contains
 * .JRE(java Runtime Environment)
 * .JVM(java Virtual matchine)
 * .Compiler(javac)
 * .Development tools
 * 
 * 6.what is JVM
 * JVM (java virtual machine) is responsible for executing java bytecode and
 * making java plataform independent
 * each operating system has its owm JVM
 * 
 * 7. What is JRE
 * JRE provides the environment required to run tha java program
 * it contains
 * .JVM
 * .core libreries
 * .Run time componenets
 * 
 * 8. why java is plateform independent?
 * Because java code is compiled into bytecode,which run on jvm,
 * since every operating system has its own jvm,the smae bytecode can run on any
 * sysytem
 * i.e why java follow Write once and Run anywere
 * 
 * 4.what is java ?
 * java is a hight level,object-oriented,plateform-independent programming
 * language
 * developed by Sun Microsystem(now owned by oracle).
 * =>features
 * .plateform independent
 * .Object-oreiented
 * .Secure
 * .Robust
 * .Multithreaded
 * 
 * 13 why main method is static ?
 * Because JVM calls the main method without creating an object,so it must be
 * static
 */
/*
 * 1.class
 * class is a blue print (template) used to create an object
 * Representation of similar type of obect .it is implimentation of
 * encapsulation
 * => it define
 * .variables(data)
 * .methods(function)
 * 
 * 9. what are the component of class ?
 * 1.Variables(field)
 * 2.methods
 * 3.Constructors
 * 4.Blocks
 * 5.Nested Classes
 * 
 * 2.Object
 * .->Object is just a buffer or a memory area in a heap in which
 *  all the instance data member are getting a memory.
 * .->In java object are runtime entities they always get the memory at runtime.
 * -> In java only object are getting memory at runtime
 * .-> In java new operator is only used to allocate a memory for an object only.
 * .->An object is instace of class which represent real world entity.The object is
 *   created in heap memory.
 * 
 * ==>.what happen when object is created ?
 * .memory is allocated in heap memmory
 * .Constructor is called
 * .Object reference is stored in stack memory
 * 
 * 
 * ==>what is reference variables ?
 * A reference vairable stroes the address(reference) of an object in memory
 * instead of storing the actual object
 * student s1 = new Student();
 * student=> class Type
 * s1 => reference variables
 * new Student()=>create object
 * 
 * =>Object create in heap memory
 * =>Reference variable stored in stack memory
 * => s1 stroes the address of object
 * 
 * ==>what is object reference ?
 * An object reference is the memory address that point to an object stored in
 * heap memory.
 * 
 * 11.Encapsulation in java
 * It the process of wrapping data and methods together and restricting direct
 * acess using private variables and getter/setter methods.
 * 
 * 11. How do we achieve encapsulation in java ?
 * Encapsulation is achieve by
 * .Making variables private
 * .Provinding getter and setter methods
 * 
 * 12. why use encapsulation?
 * .Data security
 * .Data hinding
 * .better constrol
 * .Code maintainability
 * 
 * Example
 * -"For example, in an Employee class, I keep salary as private and 
 * provide getter and setter methods. The salary cannot be directly 
 * accessed or modified. Through the setter, I can also apply validation. 
 * This is called encapsulation."
 * 
 * 16. what happens if reference becomes null ?
 * Student s1 = new Student();
 * s1 = null;
 * ======== stack===
 * s1->null
 * Now the object in heap has no reference
 * This object becomes eligible for Garbage Collection
 * 
 * 17. Explain this code
 * Student s1 = new Student();
 * Student s2 = s1;
 * Ans -> s1 is reference variable
 * new Student() create object in heap memory
 * s2 = s1 meeans both variables refer to the same object
 * 
 * 18. when the interviewr asks about object reference always mention------
 * .object stores in heap memory
 * .reference vairables are stored in stack emory
 * .Reference variables stores address of object
 * .multiple reference can point to same object
 * 
 * 19.what is instanec Data memeber ?
 * ->Instance data member is variable inside a class that store data of object.
 * ->An instance data memeber is a variable inside a calss whose value is
 * different for every object
 * 
 * 20.what is instance member function ?
 * ->"An instance member function is a non-static method that belongs to an object of a class. 
 * It is called using an object and can directly access the instance variables of that object."
 * 
 * 21.what is static data member ?
 * static variable belongs to class, not object.
 * Onlyone copy created in memory.
 * Sharedby all objects.
 * Declared using static keyword.
 * Acess using ClassName.variable
 * 
 * 22.what is static member function ?
 * A static member function is a method that belongs to the class and can be
 * called without creating a object.
 * 
 * 23.what is this keyword ?
 * =>this always point to the current object.
 * => this is the reference variable which hold the reference id of current
 * object ?
 * => whenever class level variable and a local variable both are having same
 * name then this concept is called data shadowing.
 * =>Priority always goes to local variable.
 * =>you can not acess instace data memeber of class without using reference id
 * dot.
 * => this keyword not use as static function
 * =>if you psssing "this" as argumnet in any instamce function of a class then
 * it must be the first argument.
 * 
 * ==> what is static class ?
 * "In Java, we cannot make a top-level class static. However, we can make a nested class static, 
 * which is called a static nested class. A static nested class does not require an object of the 
 * outer class to create its object. We can access it using the outer class name."
 * 
 * 24.Rule for function overloading ?
 * =>funcion overloading says that u can have more than one function with same
 * name in class having the different prototype.
 * =>Access modifier do not play any role in case of funtion overloading.
 * =>function over loading can only be achieve by changing only in argument.
 * 
 * 25.Polymorphism ?
 * =>one name many form.
 * =>Ability to take more than one form.
 * =>whenever an object gives a different different behaviour in different
 * different condition or circumtances then that behaviour of object is known as
 * polymorphism.
 * =>It reduces the complexity of object.
 * =>Polymorphhism is always achieve via beahaviour of object properties of an
 * object don noot play any role in case of polymorphism.

 * =>method overloading - in compile time
 * => mehtod overriding - in run time
 * 
 * 26 Polymorphism
 * 1.Compile time =>when ever object is bound with their functionality at
 * compile
 * time then it is compile time polymorphism
 * 2.Run time => when ever an object is bound with their functionality at run
 * time then it is knwn as run time polymorphism.
 */

/*
 * ========All About on constructor=========
 * 27 Constructor
 * =>constructor are the special member of class which are used to initialize
 * to an object.
 * if you want to perform any task only once in the life cycle of a object
 * then put the code of tha task into the constructor.
 * =>if you want to provide common resources to the each object of ypur class
 * like databse connection,creating gui,file connection etc,then put the code
 * of these resourcess into the costructor,in java constructor are by default
 * static
 * 
 * =>Type of constructor...
 * 1.Parameterise constructor
 * if you want to initialise the data member of each object with the different value
 * then always use parameterise constructor.
 * 
 * 2.Copy Constructor
 * Copy constructor is used to create the duplicate copy of existing object.
 * it works like photostate machine.
 * 
 * 3.default constructor 
 * if you want to initialise data member of each object with common value
 * this is the reson why we use default constructor.
 * 
 * ==>Constructor chaining
 * .constructor chaining is the process of calling a one constructor from another
 * constructor with rspect to current object.
 * .when ever you are achieving constructor chaining using this() then 
 * thier must be at leat one constructor which is not having a this()
 * as first line.
 * 
 * =>init()
 * .Init block is always executed before the only constructor
 * .u can have more than one init block in a single class and they
 * are executed in order in which they are depend in class
 * 
 * ==> static block
 * static block is usd to initialise static data member dynamically
 * static block is always excute a class loading time.
 * 
 */

/*
 * 3. Dynamic dispatch ?
 * Dynamic method dispatch is the process where the method call is resolved at
 * runtime based on the actual object type, not the reference type.
 
 * 5.how we create user/custom exception in java ?
 * 
 * Custom exceptions are user-defined exceptions created by extending Exception
 * or RuntimeException. They are used to handle application-specific errors such
 * as InvalidAgeException or InsufficientBalanceException. Custom exceptions
 * make code more readable, easier to debug, and help represent business logic
 * clearly. Checked custom exceptions extend Exception and must be handled at
 * compile time, whereas unchecked custom exceptions extend RuntimeException and
 * are handled at runtime."
 * 6.what is collection ?
 * 7.Different between array and collection ?
 * 8.file handling in java and how we create ?
 * 9.Tell five pre defined interface in java ?
 * 
 * 10.what is object class ?
 * "The Object class is the superclass of all classes in Java and is present in
 * the java.lang package.
 * Every class either directly or indirectly inherits from Object.
 * It provides common methods such as toString(), equals(), hashCode(),
 * getClass(),
 * clone(), wait(), notify(), and notifyAll() that can be used by all Java
 * objects."
 * 
 * ====================Inheritance in java ================
 * -Inheritance is a process of achieving amoung the object
 * It is also used to achieve dynamic binding.
 * => by default all the data member and member function of a parent
 * class are available to child class if they are not private
 * =>java does  not support multiple inheritance
 * => Inheritance is happening at compile time or runtime ?
 * ans -> Runtime
 * 
 * Example -> For example, suppose we have a parent class Vehicle with a method start(). 
 * A Car class extends Vehicle, so the Car can directly use the start() method. 
 * This is called inheritance, 
 * where a child class acquires the properties and methods of a parent class.”
 * 
 * 
 * 18. =====================Abstraction =====================
 * 
 * Definition => “Abstraction means showing only the necessary functionality and
 * hiding internal implementation details. It helps in reducing complexity and
 * achieving loose coupling. For example, in a car, we use the steering and
 * brakes without knowing how the internal engine works.”
 * 
 * 19 . 👉 How do we achieve abstraction in Java?
 * Definition =>“We can achieve abstraction in Java using abstract classes and
 * interfaces. Abstract class allows partial abstraction with both abstract and
 * concrete methods, while interface provides full abstraction by defining
 * methods without implementation.”
 * 
 * 20. 👉 Can we create an object of an abstract class? Why or why not?
 * Definition =>No, “Because it has incomplete methods (no body), so object
 * cannot be created.”
 * “We can create a reference of abstract class, but not an object.”
 * 
 * 21.What happens if a subclass does NOT implement all abstract methods?
 * Definition =>“If a subclass does not implement all abstract methods, then the
 * subclass must also be declared as abstract. Otherwise, the compiler will give
 * an error.”
 * 
 * 23.👉 Why do we use abstract class instead of normal class?
 * Definiton=>We use an abstract class when we want to provide common features
 * and force child classes to complete the missing features.
 * 
 * ==>Abstract Class
 * “An abstract class is a class declared with the abstract keyword. It can contain both 
 * abstract methods, which have no body, and concrete methods, which have a body. 
 * We cannot create an object of an abstract class directly. It is mainly used to 
 * provide common functionality to child classes and achieve abstraction.”
 * 
 * ==>abstract method
 * “An abstract method is a method that has only a declaration and no implementation. 
 * Its implementation is provided by the child class through method overriding.”
 * 
 * An abstract method can be declared inside an abstract class.
 * We cannot declare an abstract method as final, static, or private.
 * 
 * ======================function overriding==============
 * 
 * 24.Why private methods cannot be overridden?
 * Definition=>Private methods are not inherited by the subclass, so they are
 * not accessible in the child class.
 * Since overriding requires inheritance, private methods cannot be overridden.
 * 
 * 25.Difference between Method Overriding and Method Hiding?
 * Definition=>Overriding is runtime polymorphism, while method hiding is
 * compile-time behavior of static methods.
 * 
 * 26.Main purpose of method overridng ?
 * We use overriding when:
 * Same method name
 * But different behavior required
 * “We use method overriding to achieve runtime polymorphism and allow a
 * subclass to provide its own implementation of a method defined in the parent
 * class.”
 * 
 * ========================Interface==========================
 * 27.Interface in java ?
 * Definition=>An interface in Java is a blueprint of a class that contains
 * abstract methods and constants. It is used to achieve abstraction and
 * multiple inheritance by defining a contract that implementing classes must
 * follow.
 * 
 * key Rules => Cnanot create object of interface
 * => No constructor
 * => support multiple inheritance
 * =>methods are public abstract (by default)
 * =>variable are public static final
 * 
 * 28.❓ Q2. Why do we need interface when we already have abstract class?
 * definition =>“We use interface instead of abstract class mainly to achieve
 * multiple inheritance, because a class can implement multiple interfaces but
 * cannot extend multiple classes. Also, interfaces provide full abstraction and
 * help in achieving loose coupling, which makes the code more flexible and
 * maintainable.”
 * 👉 “Interface is preferred when we want to design loosely coupled systems.”
 * 
 * 29.❓ Q3. Can interface have method with body? If yes, explain types.
 * Defintion=>“Yes, an interface can have methods with body. From Java 8
 * onwards, interfaces can contain default and static methods with
 * implementation. And from Java 9, interfaces can also have private methods.
 * 
 * 3.Difference Between Abstract Class and Interface?
 * Abstract Class Interface
 * Uses extends - Uses implements
 * Can have constructors - Cannot have constructors
 * Supports single inheritance Supports - multiple inheritance
 * Can have instance variables -Variables are public static final
 * 
 * 4. 7. What are Default Methods?
 * Answer:
 * Methods with a body inside an interface. Introduced in Java 8.
 * 
 * 13. What is a Marker Interface?
 * Answer:
 * An interface with no methods or variables.
 * Used to provide special information to the JVM.
 * 
 * 14.What is Dispatch in Java?
 * Dispatch means deciding which method should be called at runtime.
 * 
 * Exapmle - “Interface comes into the picture when we have a common functionality 
 * but different implementations. For example, in a payment system, UPI, Credit Card 
 * and PayPal all perform payment, but their internal implementation is different. 
 * So we create a Payment interface with a pay() method and each payment type provides its own implementation. 
 * This gives us abstraction, loose coupling, and flexibility to add new payment methods easily.”
 * 
 */
/*
 * ====================== All about try and catch important problem=============
 * 
 * 
 * 1. what is autoclosable ?
 * Autoclosable is an interface that allow an object to be automaticalyy
 * closed when it is used in a try-with-resource statement.
 * 
 * 2.what is Try-With-Resources ?
 * it is a features in java 7 that automatically closed all the resources
 * after use.No need to write a finaaly block.
 * 
 * 3.Exception propagation ?
 * Unchecked exception are autoatically forward in clling chain and this concept
 * is konw as Exception propagation
 * 
 * 4-Eception handling ?
 * Eception handling is a maechanism to handle run time error so the program
 * does not
 * teminate abnormally. it help miantain the normal flow of the progrram.
 * 
 * 5-what is an exception ?
 * An exception is an abnormal event that occurs during program execution and
 * disrupte the normal flow of instruction.
 * 
 * 6-types of Exception
 * => checked(IOEXception,sqlException,classNotFoundException) -checked at
 * compile time. Compiler forces you to handle them.
 * => Unchecked(Artimatic nullpoiter,arrayindexoutofbound,numberFormate)occurs
 * at run time.Compiler does not check them.
 * 
 * 7-what is throwable ?
 * Throwable is the root of java's exception system.Evertything that can be
 * thrown from throwabale
 * 
 * 8-what is error ?
 * Error reperesent serious problem generated by jvm.Programmer usually cannot
 * recover from themm.
 * Exapmle -> outofmemory,StackOverflowError,virtualmachineEror
 * Errors are not handled normally.
 * Exceptions are handled.
 * 
 * 9-How JVM handle Exception >
 * step1-jvm crete exception object
 * step2-search matching catch block
 * step3-transfer control there.
 * 
 * 10-Why Child Catch Before Parent Catch?
 * because catches everything child never gets chnce
 * 
 * 11-what is finally block ?
 * Always executed.whether eception ouurs or not.
 * 
 * 12-what is Throw ?
 * Throw keyword is used for throwing exception explicitly.
 * java cretes exception autmatically sometimes we want our own rules.
 * 
 * 13 what is throws ?
 * Throws keywird is used to give indicator about an exception to the end user.
 * throws keyword is used to make the program handle freee.
 * throws keyword is also used for forwarding the checked exceotion in calling
 * chanin
 * it make the code debugging easy.
 * 
 * 14 what is custeom Exeption ?
 * jvm provide thrie won exception but suppose comapny has its own rule
 * ex=> if salary <200000
 * throw lowSalaryException
 * 
 * 15.Important method of exception class
 * 1.getMessage()-return only message.
 * 2.toString() ->class Name +mesage,It is a method of the Object class that
 * returns the string representation of an object.
 * 3.PrintStackTrace()->Retuen completeinfomation(Exception
 * name,mesage,linenumber,method name) used mostly for debugging
 * 4.why do we override toString()?
 * To display meaningful information about an object instead of the default
 * ClassName@HashCode format.

/*
 * =============All about I/O means input and output=============-========
 * 
 * 1.what is I/O ? ALL BYTE STREAM CLASSES
 * =>Input means receiving data from a source such as keyboard,file,network,or
 * database.
 * =>output means sending data from a program to a destination such as
 * screen,file printer,or network
 * =>In java ,i/o operation are performed using classes provided in java.io
 * package.java uses the concept of stream to read and write data efficiently.
 * 
 * 2.what is stream ?
 * =>Stream is flow of data/byte betwen the java program and an external source
 * or destination.
 * =>In java stream are represented via object.
 * =>low level stream are dirctly connect to the input output device.
 * => high level stream are connected to the other stream,they are used to
 * increase the performance
 * of other stream they are also known ass filter stream
 * 
 * =>In java Stream class are divided in to two part -----
 * a.> Byte Stream class.(ASCII code system)(work with binary
 * data)(images,Audio,video,pdf file
 * )
 * b.> Character stream classes.(unicode system)
 * 
 * 3.why use bufferedinputStream ?
 * BufferedInputStream reads a large chunk of data into memory and serves
 * subsequent read requests from the buffer, reducing disk access and improving
 * performance.
 * 
 * 4.why pass FileInputStream to it ?
 * FileInputStream actually reads bytes from the file, while BufferedInputStream
 * adds buffering on top of it to make reading faster.
 * =>BufferedInputStream: Reads data from a file using a buffer to make reading
 * faster.
 * 
 * 5.BufferOutputStream ?
 * BufferedOutputStream is used to write data to a file efficiently using a
 * buffer.
 * 
 * 6.why do we use DataOutputStream ?
 * To write primitive data type (int,double,boolen etc) to a file in a machine
 * indepenedent binary format.
 * 
 * 7.why do we use DataInputStream ?
 * To reaad prirmitve data types written by DataOutputStream in the same formate
 * 
 * 8.what is sequencialInputStream ?
 * SequencialInputStream is used to combine multiple input Stream into a single
 * stream.it read the first stream completely and then sutomatically switch to
 * the next strem.
 * 
 * 8-Buffered Stream ?
 * Used to improrve perofmance
 * ->without Buffer ->Read one byte at a time
 * ->with Buffer -> Read large chunks at one
 * 
 * 9-why buffere Stream ?
 * .faster
 * .less disk acess
 * .Better performance
 * 
 * 10-BufferedReader?
 * used for reading text efficiently
 * 
 * 
 * 9. what is Serialization ?
 * Serialization is the process of converting a java object into a byte stream
 * so that it can be
 * stroed in a file or sent over a network using ObjectouptuStream.
 * 
 * 10..what is Deserialization ?
 * Deserialization is the process of reconstructing the object from the byte
 * stream using ObjectInputStream.
 * 
 * Note -> out.writeObject(obj) ------//Serialization
 * -> in.readObject(); ---------//Deserialization
 * 
 * 11. why does Serializable comes in the picture ?
 * Serializable is the marker interface that tells the jvm that an object is
 * allowed to be converted
 * into a byte stream and dtore in a file or transmited over a network
 * wihtout implementing Serializable,objectOutputStream.writeObject() throws
 * NotSerializableException
 * 
 * 12.what is transient ?
 * skip the variable during serialization.
 * 
 * 
 * 13.StringTokenizer ?
 * StringTokenizer is a class in java to break a string into smaller parts
 * called
 * token based on a delimeter(separator).
 * It is present in the java.util package.
 * A token is a piece of string separated by a delimiter.
 * Instead of manually splitting the string, StringTokenizer does it
 * automatically. OR
 * 
 * StringTokenizer is a class from the java.util package used to break a string
 * into tokens based on delimiters such as space, comma, colon, etc. It provides
 * methods like hasMoreTokens(), nextToken(), and countTokens(). Internally it
 * maintains a pointer and returns one token at a time. Although StringTokenizer
 * is still available, nowadays String.split() is preferred because it is more
 * flexible and supports regular expressions.
 * 
 * 14. Stream Tokenizer ?
 * StreamTokenizer is a class from the java.io package used to read data from a
 * stream and break it into tokens such as words, numbers, and special
 * characters. It automatically identifies token types. nextToken() reads the
 * next token, ttype stores the token type, sval stores word values, and nval
 * stores numeric values. It is useful when parsing structured text files or
 * streams.
 * 
 * =>method of tokenizer
 * 1. hasMoreTokens()->check wether more tokens exist
 * 2.nextToken()->return next Token
 * 3.countTokens() ->Returns number of remaining tokens.
 * 
 * 
 * 15 Scanner ?
 * Scanner is a class in the java.util package used to reaad input from
 * keyboard(System.in),files,Strings
 * System.in --> Keyboard Input Stream
 * Scanner --> Reads and converts input
 * 
 * 16-Console class ?
 * The Console class in Java provides methods to interact with the system
 * console. It allows reading text using readLine(), reading passwords securely
 * using readPassword(), and obtaining character streams through reader() and
 * writer(). The main advantage of Console over Scanner is secure password input
 * because typed characters are not displayed on the screen. It is commonly used
 * in command-line applications requiring authentication or sensitive user
 * input.
 * 
 * 
 * 
 * 
 * 
 * 14. ========================FILE CLASS==========================
 * 1. what is file class ?
 * the file class is available in the java.io package.
 * The File class is used to represent a file or directry path in the file
 * system
 * the file class do not read and write ,it only perform
 * create,delete,rename,create directry,get file informaton,
 * check permision.
 * 
 * 2.Realtive and absolute path ?
 * Realtive path is dependent on current woking directry
 * while Absolute path contain the complete location of a file.
 * 
 * 3.list() ->Returns names only. -> String[] arr = f.list();
 * listFiles() ->Returns File Objects. -> File[] arr = f.listFiles();
 * 
 * 4.Limitation of File Class ?
 * Read content,Write content, Modify content.
 * 
 * 5.which exception is thrown by createNewFile() ?
 * IOException.
 * 
 * 6.what is the modern alternative to File Class ?
 * Java NIO package.
 * classes -> path,paths,files
 * 
 * 7-whatis NIO ?
 * NIO stand for New Input output .
 * It was introduced in java 1.4 to provider.
 * =>Fater i/o operation.
 * =>Non-bloacking i/o.
 * =>Better FIle handling.
 * =>Buffer-based opeartion.
 * =>Channel-based communication
 * => Two-way data flow
 * 
 * 8-why NIO is faster ?
 * because NIO used buffer and channels instead of traditional Streams.
 * 
 * 
 * /*
 * ================SOME IMPORTANT POINT ON IT======================
 * 
 * 
 * 1.what is System.out ?
 * System.out is a static final object of the printStream class used to display
 * output on the console.
 * and out is a static variable of System class.
 * 
 * 2.what is the type of System.out ?
 * printstream.
 * 
 * 3. Is System a class or an Object ?
 * System is a class
 * 
 * 
 * 
 */

/*
 * ============================REFLECTION================
 * 1.what is reflection in java ?
 * Refelction in java is a features provided by the java.lang.reflect
 * package that allows a program to inspect and manipulate classes,methods,
 * constructor,fields,andobjects at runtime.it was introduced so that program
 * and
 * framework can work with classes whose name or structrue are only known while
 * the
 * apllication is running.Reflection is widely used in framework such as
 * Spring,hibernate
 * jUnit,and JDBC for tasks like dependency injection,object creation,and
 * dynamic method
 */
/*
 * =================String All Point =========================
 * String
 * StringBuffer
 * StringBuilder
 * String Pool
 * Immutable Strings
 * String Methods
 * 
 * 1.How to make String immutable ?
 * ->do not use setter.
 * -> blank final and private
 * ->don't allow subclass to override. The simple to make class final to make
 * the contructor private.
 * 
 * 2.Different between concat and Plus(+)
 * using concate we add only string type beacause in constructor always take
 * String parameter. using plus we add any type if one operands is String type.
 * 
 * 3.CompareTo() -> it is the method of interface .
 * -> it take first word of string and substract to ASCII value if it come zero
 * then true
 * 
 * 4- Rule for String Handling ?
 * .String is a sequnce of character
 * .in java everything is representd in the form of object except the primitive
 * data type.
 * .in java String are representd via object.
 * .String all immutable class.
 * .can you make ur own class immutable =>yes.
 * .if you want to make ur own class immutable then make all the instance data
 * memeber of that class as a blank final variable
 * .in java all the string literal like "hellow" are trated as a string calss
 * object.
 * 
 * 
 * 3.String buffer ?
 * if you wnat to change in string the use String buffer .
 * when you crteate string buffer class Object using a default constructor
 * jvm create a char type arry of size 16 which is known as string buffer
 * capacity
 * formul = (intialcapacity + 1)*2
 * all the method of string y default is synchronize
 * so it is thread safe.
 */

/*
 * ===============All ABOUT THREAD =======================
 * 12. Multithreading
 * Thread Class
 * Runnable Interface
 * Thread Lifecycle
 * Synchronization
 * Deadlock
 * Inter-thread Communication
 * wait()
 * notify()
 * notifyAll()
 * Daemon Thread
 * 
 * 1.What is Multithreading ?
 * It is used to achieve multitasking in a java program that means single
 * program or application of java can perform so many
 * task smultanoously.Thread are light weight process execute on a seperate path
 * and use to schieve multitasking in an application
 * 
 * 2. what is thread ?
 * Thread is the smallest unit of executin process.A program can have multiple
 * threads running concurrently.
 * 
 * 3. What is thread class ?
 * The thread class is used to create new thread by extending it and overrding
 * the run() method.
 * 
 * 4. why start instead of run() ?
 * t.start() ->creating new thread.internally the JVM calls the run() method.
 * run() ->contains the actual task that the thread performs. If we call run()
 * directly, it behaves like a normal method call and no new thread is created.
 * 
 * 5.Runnable Interface
 * Runnable is used when a class is already extend in other class because java
 * does not support multiple inhertiance
 * "Runnable is preferred because it supports better design and avoids the limitations of single inheritance."
 * 
 * 6.Thread life cycle ?
 * NEW -> START()->RUNNABLE->(cpu
 * schedular)RUNNING->WAITING/BLOACKED->TERMINATED
 * 
 * 7.what is join method ?
 * .->join method from thread class is an important method and used to improve
 * order on excution of multiple thread.
 * ->join is a final method on java.lang.thread class and can not override it.
 * ->join method throw interrupptedException if another thread inteerupted
 * waiting
 * thread as result of join() call
 * ->Join is also an overloaded method in java.
 * 
 * 
 * 7.Why is thread scheduling unpredictable?
 * Thread scheduling is unpredictable because it is managed by the JVM and the
 * operating system scheduler, not by the programmer."
 * 
 * 8.what is syncronization ?
 * -> at a time only one thread can enter in the sycronise method if it one
 * having same object
 * -> when we use common value in multple thread then we use synconisation
 * -> Syncronisation is a mechanism that allows only one thread at atime to
 * acess a shared resource.
 * ==> its main purpose is to :
 * =>prevent race conditions
 * =>maintain data consistency
 * =>Ensure thread safty
 * 
 * ==> why do we need Sycronization ?
 * =>Suppose two thread are accesisig the same bank account.
 * ->because both thread read the balance at the same time.
 * =>Only one thread can excute the method at a time.
 * 
 * ==> Types of Syncronisation
 * 1.Sycronisation method-(Entire method is loacked)
 * 2.Sycronisation block-(make some particular method Syncronized which one have
 * data member)
 * 3.Static Syncroniztion
 * 
 * 9.what is Deadloack ?
 * Deadlock occurs when two or more thread wait forever for each to release
 * resources
 * Ex-> Thread 1 holds Lock A
 * waiting for Lock B
 * 
 * Thread 2 holds Lock B
 * waiting for Lock A
 * 
 * 10. wait() ?
 * wait() cause the current thread to release the lock and move into weiting
 * state.
 * thread waits until another thread notifies it.
 * 
 * 11.notify() ?
 * notify() wakes up one waiting thread.
 * 
 * 12.notifyAll() ?
 * notifyAll() wakes up all waiting threads.
 * 
 * 13.Daemon thread ?
 * It gives the service to other thred.whom daemon give service if he died than
 * daemon thread also dead
 * Ex.Garbage Collector
 * . JVM helper threads
 */

/*
 * ==========================WRAPPER TOPIC ===========================
 * 1. what is wrapper class ?
 * A wrapper class is a class whose object is wrap or contains primitive
 * data types.they wrap the primitive datatype into an object of that class.
 * 
 * 2.why do we need them ?
 * java is obejct orinted lanuguage,but primitive are not objects.
 * wrapper classes allow primitve to be used where only
 * objects are allowed -such as in Collection(arrayList,HashMap),serialization
 * and synchronization.
 * 
 * 3.Autoboxing ?
 * The automatic conversion of primitive types to its corressponding wrapper
 * classs object.
 * 
 * 4.Unboxing ?
 * The automatic conversion of wrapper calss object to its corressponding
 * primitve types.
 * 5.All wrapper class in java are immutable.
 * 
 * Summary for Your Interview
 * If an interviewer asks about wrappers, make sure to hit these four pillars:
 * 
 * They turn primitives into objects so they can play nice with
 * Generics/Collections.
 * 
 * Autoboxing/Unboxing happens automatically but can cause NullPointerException
 * if you aren't careful.
 * 
 * They are immutable.
 * 
 * Integer Caching exists between -128 and 127.
 */

/*
 * ===================ALL ABOUT GENRIC CLASSES==================
 * 1.what is Genric Class ?
 * A genric class is a class that can work with different data types using a
 * type parameter
 * (T), avoids explicit type casting,providing type safty and code reusebility.
 * 
 * 2.why are Genric used ?
 * .type safty
 * .code reuseabilty.
 * .No explicit type casting
 * .Fewer runtime errore
 * 
 * 3.what does T mean?
 * T is a type parameter.it is replaced with the actual(String,Integer)
 * when an object is created.
 * 
 * 4.Can prmitive types work only with reference types ?
 * No. Genrics work only with reference types.
 * 
 * 5.why do we use Genric ?
 * without genrics java uses objects.
 * 
 * 6.Different between Genric class and Genric method ?
 * in genric class-> Entire class uses type paramter.
 * in genric method ->Only method is genric.
 * 
 * 7.what are Bounded Genric ?
 * Sometimes we want to restrict the allowed types.
 * 
 * 8.what are Wildcards (?) ?
 * WildCards means unknown type. eg.List<?>list
 */

/*
 * =>CompileTIme in java
 * Compile time is the phase when the Java compiler (javac) checks and converts
 * your Java source code (.java) into bytecode (.class).
 * The compiler checks things like:
 * Syntax errors
 * Type errors
 * Variable declarations
 * Method signatures
 * 
 * ==>RunTime
 * Runtime is the time when the JVM executes the compiled bytecode and the
 * program is actually running.
 * The JVM loads the .class file and executes the program.
 * 
 * Compile time = Code is checked and converted to bytecode.
 * Runtime = Bytecode is executed by JVM.
 */

/*
 * =>what is protected access modifieer ?
 * "Protected is an access modifier in Java. A protected member can be accessed
 * within the same class,
 * same package, and in subclasses even if the subclass is in a different
 * package."
 * Bas ek important point yaad rakho: different package mein child class ke
 * through access allowed hai,
 * lekin unrelated class ke through nahi.
 * 
 * ==>difference between runnable and collable interface ?
 * 
 */