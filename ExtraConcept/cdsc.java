/*
 * 1.RunTime and process class ?
 * =>The Runtime class represents the runtime environment of the JVM. It
 * provides
 * methods to execute system commands, get memory details, run the garbage
 * collector, and exit the JVM.
 * 
 * The Process class represents an operating system process created by methods
 * like Runtime.exec() or ProcessBuilder.start(). It allows you to monitor and
 * control that process.
 * 
 * 2.what is ArrayClass ?
 * Arrays → A utility class in the java.util package that provides methods to
 * work with arrays.
 * 
 * 3.Why do we use the Arrays class?
 * Instead of writing loops for common operations, the Arrays class provides
 * ready-made methods to:
 * sort()
 * binarySearch()
 * equals()
 * fill()
 * toString()
 * 
 * 4.what is clonning ?
 * Cloning is the process of creating an exact copy (duplicate) of an object.
 * Instead of creating a new object and copying each field manually, Java
 * provides the clone() method.
 * The clone() method is defined in the Object class.
 * Cloneable is a marker interface.
 * If you don't implement it and call clone(), Java throws:(CloneNotSupportedException)
 * 
 * how it work ?
 * 1.the class must implements the cloneable interface
 * 2.Override the clone() method(usually making it public).
 * 3.Class clone() on the object
 * 
 * Shallow Copy ?
 * A shallow copy copies primitive value but share references to nested
 * objects.
 * 
 * 5.Asertion in java ?
 * An asertion is a statement used to test assumption in your program
 * during development
 * if the conditon is true,the program continues normallly
 * if the condition is false,java throws an asertionError.
 * Assertion is mainly used for debuuging and testin,not
 * for validaton user input
 * 
 * =>When to use Assertion ?
 * ->Check internal program logic.
 * ->verify method assumption.
 * ->Debug during development.
 * 
 * =>Which keyword is used for assertions?
 * .assert
 * 
 * 
 * 6.ENUM ?
 * In java ,an enum is a special data type used to defined a fixed
 * set of constent values.It make your code more readable,type-safe
 * and easier to mainatain
 * 
 * =>comon enum methos are -
 *  values - return all the enum constant
 * valuesOf(String) -convert string to coreressponding enum content
 * name()- return the name of the enum sontstent
 * ordinal() - return the position of the content(starting from 0)
 */
