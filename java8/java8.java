/*
 * ===============LAMBDA EXPRESSION==================
 * 1.what is a Lambda Expressin ?
 * A Lambda Expression is a feature introduced in Java 8 that allows us to write
 * a concise implementation of a functional interface's single abstract method.
 * 
 * =Lambda Expression Java 8 ka one of the most important features hai. Iska
 * main purpose hai code ko short, clean aur functional style mein likhna,
 * especially jab hume kisi single-method interface ka implementation dena ho
 * 
 * =It represents an anonymous function and helps us pass behavior as an
 * argument.
 * 
 * Ex.
 * Runnable r = () -> System.out.println("Hello");
 * r.run();
 * 
 * 2.What is the syntax of a Lambda Expression?
 * (parameters) -> expression
 * or
 * (parameters) -> expression
 * Ex.
 * (a, b) -> a + b
 * a, b → parameters
 * -> → lambda operator
 * a + b → body
 * 
 * 3.In which version of Java was Lambda Expression introduced?
 * Lambda Expression was introduced in Java 8.
 * 
 * 4.Why do we need Lambda Expressions?
 * Lambda Expressions reduce boilerplate code and make the code shorter,
 * cleaner, and more readable, especially when working with functional
 * interfaces, collections, and streams
 * 
 * Before Java 8:
 * Runnable r = new Runnable() {
 * 
 * @Override
 * public void run() {
 * System.out.println("Hello");
 * }
 * };
 * 
 * With Lambda:
 * Runnable r = () -> System.out.println("Hello");
 * 
 * 5.With what type of interface is a Lambda Expression used?
 * A Lambda Expression is mainly used with a Functional Interface.
 * 
 * Ex.
 * 
 * @FunctionalInterface
 * interface Calculator {
 * int add(int a, int b);
 * }
 * 
 * lambda
 * Calculator c = (a, b) -> a + b;
 * 
 * 6.What is a Functional Interface?
 * A Functional Interface is an interface that has exactly one abstract method.
 * It can also contain multiple default and static methods.
 * 
 * 7.What is @FunctionalInterface?
 * 
 * @FunctionalInterface is an annotation that tells the compiler that the
 * interface is intended to have exactly one abstract method.
 * Ex.
 * 
 * @FunctionalInterface
 * interface Test {
 * void show();
 * }
 * If we add another abstract method:
 * The compiler will report an error
 * 
 * 8.Can a Functional Interface have default and static methods?
 * Yes. A Functional Interface can have multiple default and static methods, but
 * it must have only one abstract method.
 * 
 * Ex.
 * 
 * @FunctionalInterface
 * interface Test {
 * 
 * void show();
 * 
 * default void display() {
 * System.out.println("Display");
 * }
 * 
 * static void hello() {
 * System.out.println("Hello");
 * }
 * }
 * 
 * 9.Give a practical example of Lambda Expression.
 * 
 * @FunctionalInterface
 * interface Calculator {
 * int add(int a, int b);
 * }
 * 
 * public class Main {
 * public static void main(String[] args) {
 * 
 * Calculator c = (a, b) -> a + b;
 * 
 * System.out.println(c.add(10, 20));
 * }
 * }
 * 
 * explanation-Calculator is a functional interface because it has one abstract
 * method. The Lambda (a, b) -> a + b provides the implementation of that
 * method.
 * 
 * 10.How do you pass parameters in a Lambda Expression?
 * No parameter:
 * One parameter:
 * Multiple parameters:
 * 
 * 11.What are the common built-in Functional Interfaces in Java 8?
 * ==>What is Predicate?
 * Predicate is a functional interface that takes an input and returns a boolean
 * value. It is mainly used for condition checking.
 * 
 * ==>What is Consumer?
 * Consumer takes an input but does not return any result.
 * 
 * ==>What is Function?
 * Function takes an input and returns an output.
 * 
 * ==>What is Supplier?
 * Supplier does not take any input but returns a value.
 * 
 * 12.How can you use Lambda with a Collection?
 * We can use Lambda with forEach().
 * Ex.List<String> names =
 * Arrays.asList("Kundan", "Rahul", "Amit");
 * 
 * names.forEach(name ->
 * System.out.println(name));
 * 
 * ==>What is the difference between Lambda Expression and Anonymous Class?
 * Both can provide an implementation for a functional interface, but Lambda
 * Expression reduces boilerplate code and makes the code more concise and
 * readable.
 * 
 * ==>What is the difference between Lambda Expression and Stream?
 * Lambda Expression represents behavior, while Stream API is used for
 * processing data.
 * They are often used together in Java 8.
 */
/*
 * Lambda does not directly create an object of the interface; it provides the
 * implementation of the functional interface, and Java creates the required
 * runtime instance.
 */