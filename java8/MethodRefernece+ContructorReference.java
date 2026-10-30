/*
 * 1. Method Reference in Java 8
 * Method Reference is a short way to write a lambda expression when the lambda
 * only calls an existing method.
 * Instead of:
 * (x) -> System.out.println(x)
 * we can write:
 * System.out::println
 * The :: operator is called the method reference operator.
 * 
 * 2.Four Types of Method References
 * =>Type 1 — Static Method Reference
 * ClassName::staticMethod
 * ==>Instance Method of a Particular Object
 * ClassName::instanceMethod
 * =>Type 4 — Constructor Reference
 * ClassName::new
 * 
 * ==>What is Constructor Reference?
 * Constructor Reference is a Java 8 feature used to refer to a constructor
 * using the ::new syntax. It is mainly used with functional interfaces and
 * streams to create objects.
 */
