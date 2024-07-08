# Java Study Guide
## Java Basics
- high level
    - automatic memory management (no developer pointers, garbage collection handled for you)
- compiled
    - source code is all compiled together and then it can be run
- statically typed
    - must declare variable types
- strongly typed
    - can not coerce data types
- OOP
    - makes use of classes and objects
- Write Once, Run Anywhere
    - Anyone with a JRE and JVM can run a Java app
- rich open source community
    - vast amount of libraries you can add to your program

## Programming and Compiling
Most Java applications only require the **JRE** (Java Runtime Environment). But to write and compile you need the **JDK** (Java Development Kit). While the JRE provides Java's standard libraries and exceptions as well as a JVM, the JDK provides all the above as well as *javac*, the compiler. Java source code is written in text files labeled with *.java* extension. It is then compiled into bytecode in *.class* files by *javac*. Then the bytecode is executed by the JVM, which translates the Java commands into low-level instructions to the operating system.

Since Java 6, all Java programs not run inside a container (such as a Servlet Web Container) start and end with the main method. The class containing the main method can have any name, but the method itself should always be named *main*

```java
class Example {
    public static void main(String[] args) {
        System.out.println("Num args:" + args.length);
    }
}
```

- *public* is a Java access modifier keyword that means the `main` method can be accessed from any method during the program's execution.
- *static* is a Java keyword that means the method can be invoked without creating an instance of the class that contains it, making it a global method.
- *void* is a Java return type keyword that means the method doesn't return any values of any data type.
- *args* is a Java variable of type String array which means the method can take command line arguments as an array of Strings

We can compile this code into a *.class* file of the same name:
>javac Example.java
And to run the resulting `Example.class` file:
>java Example
The `java` and `javac` commands require the full directory path or class path to any source code or binary file respectively. If you have a package `com.demo` in the first line of Example, then you would nest the java file into a `com/demo/` directory and then run:
>javac com/demo/Example.java 
>java com.demo.Example
From here we can add packages and imports, expanding the application into a set of interacting objects. By default, the *javac* compiler implicitly imports several base packages from the standard library. the `-help` flag can display available options. For example, the following will compile using UTF-8 encoding while conforming to Java 1.8 features:
>javac -encoding UTF-8 -source 8 -target 8 Example.java

## jdk, jre, jvm
- JVM
    - the jvm takes compiled Java code and runs it.
- JRE
    - the jre contains the runtime libraries necessary for a Java app to run, and it houses the jvm too
- JDK
    - the jdk contains developer tools (compiler, debugger, documentation tools) that allow for the creation of Java apps

## Primitive data types
Java handles two kinds of datatypes: primitives and references. Primitives are variables that store simple values. There are eight in Java.
- Integer types: **byte**, **short**, **int**, and **long** (42)  
- Floating-point types: **float**, and **double** (3.1415)  
- Logical types: **boolean** (true)  
- Character type: **char** ('x')

## Reference types
Reference types store the memory address location of more complex data types in the heap. Reference types include:
- Classes
- Interfaces
- Enums
- Arrays

## Variables
A value is stored and identified in memory by a variable. Variables have a name that makes it possible to access the value, and a type that defines what sort of value it stores.
```java
int variableName = 64;
String txtVar = "Hello World";
```

## Naming variables
- Case sensitivity
- Can only use letters, numbers, and *$* or *_* characters
- Cannot begin with a number
- Cannot be a reserved Java keyword

## class/object
|class|object|
|-----|------|
|declared using class keyword| declared using new keyword|
|declared once|declared as many times as needed|
|no memory allocated when created|memory allocated when created|
|blueprint for creating objects|instantiated class|
```java
public class myClass {

}
// public = access modifier
// class = needed for class declaration
// myClass = name of class
```

## stack & heap
- the heap is where objects are stored in memory (and the string pool)
- the stack is where local variables references are stored
    - a new stack is created for each method invocation

## Object-Oriented Programming
Although Java accommodates several paradigms, OOP is the foundation for most applications. In OOP, a program is organized into objects encapsulating related fields (representing its *state*) and methods (usually to control that state or perform related functions). When defining objects, Java reserves the keyword *class* (not to be confused with the *.class* file extension) which serves as their blueprint. An object in Java represents an instance in memory of a class, and also every class implicitly inherits from the *Object* superclass which provides useful convenience methods such as *equals()* and *toString()*. Java popularized several 'Pillars' of OOP design theory. While the numbers vary between OOP languages, Java focuses on four:

- **Abstraction** By simplifying objects to a set of useful features, we hide irrelevant details, reduce complexity, and increase efficiency. Abstraction is important at all levels of software and computer engineering, but essential to designing useful objects. Complicated real-world objects are reduced to simple representations.

- **Encapsulation** Objects should group together related variables and functions and be in complete control over them. So the state of an object should only change, if ever, through the object itself. Also known as data hiding, because the object has sole responsibility for its fields, and no outside object or function should interfere.

- **Inheritance** Code reuse is an important principle of programming (DRY - Don't Repeat Yourself), and new classes can reuse code from existing ones. This establishes a superclass-subclass (or parent-child) relationship where the derived classes inherit (and sometimes change) fields and methods from its parent.

- **Polymorphism** With inheritance, an object of a derived class can be referenced as instances of its parent class. This provides flexibility when invoking inherited methods with varying implementations in derived classes.


## methods & parameters
```java
class MyClass{
    public static void myBasicMethod(){
        System.out.println("This is where the code for the method goes");
    }
}
// public = access modifier
// static = non-access modifier keyword. Allows access to the method without instantiation
// void = return type. void indicates there is nothing to return
// myBasicMethod = name of the method
// () = any parameters for the method are listed here
```
## Constructors
Constructors are special methods that determine how classes are to be instantiated as objects. They handle the build logic
```java
public class MyClass{
    int myInt;
    String myString;

    // this is a basic "no args" constructor
    public MyClass(){
        // every constructor calls super() (or this()) as its first line of code, whether you place it or not
    }

    /*
        methods in Java support "overloading": this is where you have the same method name but different parameters. You can also
        change the return type, but it must be accompanied by adjusted parameters. Below are some examples of overloading the constructor
    */

    // this is a constructor that only initializes one variable
    public MyClass(int myInt){
        this.myInt = myInt;
    }

    // this is a constructor that initializes both variables
    public MyClass(int myInt, String myString){
        this.myInt = myInt;
        this.myString = myString;
    }

    // this is a constructor that takes in an argument for one variable and sets a default for the other
    public MyClass(String myString){
        this.myInt = 0;
        this.myString = myString;
    }
}
```
## Variable Scopes
1. Class/static scope
    - available to all instances of the class by invoking the class itself
    - the static keyword makes a variable class scope
    - class scope methods/variables can not interact with instance variables/methods
2. Instance/object scope
    - available to the instance of an object
    - this keyword is used to interact with an instance variable
    - instance variables do not cross objects: they are unique per object
3. Method scope
    - available within the method it is instantiated in
    - the variable no longer exists after the method is finished, so it can not be used outside the method
4. Block scope
    - available within the {} it is instantiated in
    - usually your control-flow statements
``` java
public class MyClass{

    static int classCount = 0; // class scope: available to all myClass objects
    String objectName; // instance scope: each object of this class will have their own objectName field

    public MyClass(String objectName){
        int addOneToClass = 1; // method scope: only available within this method
        MyClass.classCount += addOneToClass;
        this.objectName = objectName;
    }

    public static void countClass(){
        if (MyClass.classCount > 0){
            System.out.println(myClass.classCount);
        } else {
            int zero = 0; //block scope: only exists here in the code
            System.out.println(zero);
        }
    }
}
```
## access modifiers
|modifier|access|
|-------|-------|
|public|anywhere|
|protected|within same package and sub-classes|
|default (no keyword)|within same package|
|private|within same class|
## packages & imports
packages are a way of organizing our Java code. The naming convention is to write a reverse web domain separating words with periods:
```java 
package com.revature.mypackage;
```
classes can be referenced anywhere in your program by either using their "fully qualified name" or by importing them.
``` java
// you use the import keyword to import from another package or class
import packagename.classname

// fully qualified class names include the package
packagename.classname.method()
```
## Collection API
![Collection API](CollectionHierarchy.png)

## Generics
When passing objects into methods and data structures, a developer can overload or extend for its specific type or cast the object up and down its inheritance hierarchy. In contrast a generic type improves code reuse and type safety, reducing code by allowing methods and data structures to accept any type without risking dynamic runtime exceptions. Generic type parameters act as placeholders in a method signature while diamond operators specify the type for the compiler to enforce at compile time:
```java
ArrayList<String> list = new ArrayList<>();
public <T> String genericToString(T a) {   
    return a.toString();
}
public <T, E> String genericToStringCat(T a, E b) {   
    return a.toString() + b.toString();
}
```
The type parameters T and E will be replaced by the compiler through type erasure:
```java
String s1 = genericToString(1);
String s2 = genericToString("Hello", 3.5);
```

## Collections Framework
Java's collections framework provides an API and reference implementations for common data structures
- **List** is an ordered collection of elements. A user has the ability to place an element anywhere in the list. The elements are accessible by their index. Unlike **Set**, **List** typically allows for duplicate elements such that element1.equals(element2). In addition to duplicates, **List** allow for multiple null elements to be stored.  
```java
// ArrayLists are arrays that can dynamically resize. Fast searching, slow adding
List<Integer> arrayList = new ArrayList<>();
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(3);
    arrayList.add(4);
    arrayList.add(5);

// LinkedLists implement List and Queue. Composed of nodes that reference the next/previous node (double linked). Fast adding, slow searching
List<Integer> linkedList = new LinkedList<>();
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);
    linkedList.add(4);
    linkedList.add(5);
```
- **Set** is a collection of non duplicate elements meaning there will never exist a situation where element1.equals(element2). In addition to this, it is implied that there can only exist one null element due to the no duplicates rule. Some implementations also use **SortedSet** for proper ordering.
```java
// HashSets are backed by HashMap, fast insertion and search. Not indexable
Set<String> hashSet = new HashSet<>();
    hashSet.add("Billy");
    hashSet.add("Sally");
    hashSet.add("Slagathor");

// TreeSets maintain order. insertion and removal is slow because of ordering. No null allowed
Set<String> treeSet = new TreeSet<>();
    treeSet.add("Timmy");
    treeSet.add("Betty");
    treeSet.add("Cthulhu");
```
- **Queue** is a collection of elements who in essence cannot be iterated, instead the **Queue** follows the **FIFO** (First In First Out) rule. When an element is added to the **Queue** it is placed at the back and when an element is pulled it is pulled from the from the front (index :0).  
- **Deque** extends **Queue** but augments the ability to insert and remove elements at either end. The name is short for "Double Ended Queue" and is pronounced "Deck". Can be used as a LIFO (Last In First Out) Stack.
```java
// ArrayDeque allows for adding to the start or end of the queue. It has some useful methods
// pop()
// push()
// peekFirst()
// peekLast()
// pollFirst()
// pollLast()
// offerFirst()
// offerLast()
Deque<Integer> queue = new ArrayDeque<>();
    queue.add(2);
    queue.addFirst(1);
    queue.add(3);
    queue.add(4);

// PriorityQueue orders by priority instead of FIFO. Null is not allowed, natural ordering does not allow non-comparable objects
```
- **Map** is an interface which stores data with a key. A map cannot contain duplicate keys; each key can map to at most one value. **Map** can be visualized like a dictionary where only one word is paired with one definition. Unlike most other interfaces in the Collections Framework, it does not implement Collection nor Iterable. 
```java
// HashMaps are unordered key value pairs, fast insertion and deletion
Map<Integer,String> myHashMap = new HashMap<>(); // must indicate what the key type and value type are
myHashMap.put(1,"first value");
myHashMap.put(2,"Second value");

// TreeMaps are ordered key value pairs, slower insertion and deletion
Map<Integer, String> myTreeMap = new TreeMap<>();
myTreeMap.put(1,"First Value");
myTreeMap.put(2, "Second Value");
```
### Comparable vs Comparator
Comparable is a functional interface used to define a 'natural ordering' between instances of a class, commonly used by sorted collections such as TreeSet.
Comparator is another functional interface used in a dedicated utility class that can compare two different instances passed to it. It can be passed to a sort method, such as Collections.sort() or Arrays.sort(), or to sorted collections.
For example, to automatically sort a TreeSet of type Person according to age. We can either make the object class comparable or pass the constructor a comparator.

#### Comparable
```java
class Person implements Comparable<Person>{
	int age;
 
	Person(int age) {
		this.age = age;
	}
 
	@Override
	public int compareTo(Person o) {
		return o.age - this.age;
	}
}
 
public static void main(String[] args) {
	TreeSet<Person> persons = new TreeSet<Person>();
	persons.add(new Person(43));
	persons.add(new Person(25));
	persons.add(new Person(111));
}
```
#### Comparator
```java
class Person {
	int age;
 
	Person(int age) {
		this.age = age;
	}
}
 
class PersonAgeComparator implements Comparator<Person> {
	@Override
	public int compare(Person a, Person b) {
		return a.age - b.age;
	}
}
 
public static void main(String[] args) {
	TreeSet<Person> persons = new TreeSet<Person>(new PersonAgeComparator());
	persons.add(new Person(43));
	persons.add(new Person(25));
	persons.add(new Person(111));
}
```

## Non-Access Modifiers
Java includes some keywords that are not used to denote access levels: these three are the most common ones you will interact with in training
- static
    - marks the method/variable as part of the class scope
- final
    - makes a variable unable to be reassigned a new value
    - makes a method incapable of being overridden
    - makes a class incapable of being extended
- abstract
    - makes a class incapable of being instantiated
    - marks a method as being defined without any implementation, which must be handled somewhere else

There are other keywords as well, but we will not make much (if any) use of them:
- synchronized 
    - relevant to threads and preventing deadlock phenomena
- transient 
    - marks a variable as non-serializable, meaning it will not be persisted when written to a byte stream

## Interfaces & Abstract Classes
Interfaces are like "contracts" that give classes access to the variables and methods they contain: their methods default to public abstract, but interfaces can hold static methods, along with pre-defined methods that are intended to be overwritten. Abstract classes work like regular classes except they can't be instantiated

Key differences between abstract classes and interfaces:
|Abstract|Interface|
|--------|---------|
|class can't be instantiated|contract can't be instantiated|
|instance variable/access modifiers|public static final variables|
|concrete methods allowed|abstract methods normally(default/static allowed)|
|can only inherit one class|can implement multiple interfaces|

```java
public abstract class MyAbstractStuff{
    /*
        abstract classes are very similar to regular classes, but they have two key differences: the first is
        that they can declare their methods to be abstract, meaning that their implementation will be handled
        by any class that extends this abstract class
    */

    public abstract void myAbstractMethod();

    /*
        the second key difference is that an abstract class can not be instantiated directly: to access the fields
        and behaviors in the abstract class you need to extend the class with a child class and instantiate the
        child class
    */

    // MyAbstractStuff myObject = new MyAbstractStuff() will cause an error in your code

    /*
        Other than the two points above, you can treat an abstract class like a regular class: fields can be class
        or object scope, methods can have implementations, and you can utilize access modifiers like regular.
    */
}
```

```java
public interface MyInterfaceStuff{
    boolean myBoolean = true; // this is public static final by default

    void someMethod(); // this is public abstract by default
}
```

## Functional Interfaces and Lambdas
Functional Interfaces are interfaces with a single method that is used to create lambda templates.
```java
@FunctionalInterface // the annotation informs the compiler the interface is a functional interface
interface MyFunctionalInterface{
    // this is the abstract method we will use as our lambda template
    int mathematics(int num);
}
```
Lambdas are a way to do functional programming in Java (sorta). Instead of tying a method to a class it (sorta) stands alone. You can call lambdas without needing to also call a class. Collections have a built in system for a lambda: the forEach() method
```java
List<String> names = new ArrayList<>();
names.add("Billy");
names.add("Bob");
names.add("Jill");
names.forEach(name -> System.out.println(name)); // notice name requires no type declaration
```
you can also create your own lambdas by creating functional interfaces and implementing their single abstract method
```java
@FunctionalInterface
interface MyFunctionalInterface{
    int mathematics(int num);
}
MyFunctionalInterface addFive = num -> num + 5;
System.out.println(addFive.mathematics(5)); // this will print 10
MyFunctionalInterface subtractFive = num -> num - 5;
System.out.println(subtractFive.mathematics(5)); // this will print 0
```
## Exception hierarchy
![Exception Hierarchy](ExceptionHierarchy.jpg)
## Exception Handling/Declaring
Java throws exceptions when they occur. If no code is provided to handle the exception it will go all the way to the JVM and the JVM will terminate the program. You can handle exceptions as the developer by using try/catch blocks, similar to if/else blocks. This is called handling. You can also "duck" or declare exceptions by adding a throws clause to your method signature. This allows you to throw checked exceptions without catching it in the method
```java
// try to be specific with exceptions when possible
public static void duckMethod() throws Exception{

}
```
## Custom Exceptions
You can create custom exceptions relatively easily. Create a class, extend either exception or runtime exception (or a more specific exception) add a constructor that has a message parameter, and in the constructor call super(argument). You're done
```java
class MyCheckedException extends Exception{
    public MyCheckedException(String message){
        super(message);
    }
}
class MyUncheckedException extends RuntimeException{
    public MyUncheckedException(String message){
        super(message);
    }
}
```
## Checked vs Unchecked Exceptions
checked exceptions need to be in try catch blocks, unchecked do not. If you add throws to a method signature you can list any checked exceptions and throw them without a try catch block.
```java
try{
    throw new MyCheckedException("this message shows when the exception is thrown");
} catch (MyCheckedException exception){
    exception.printStackTrace();
} finally{
    // Anything you want to happen, whether an exception is caught or not, can go in a finally block
}

if (2 > 1){
    throw new MyUncheckedException("you don't need to handle this with a try catch");
}

public static void throwsMethod() throws MyCheckedException{
    throw new MyCheckedException("I can do this without a try catch block");
}
```

## String API
Strings are immutable objects in Java. They have a pool (string pool) in the heap that allows for multiple references to point to the same String object. This makes them work a little differently from other objects
```java
// these two strings point to the same object in memory, return true when the .equals() method is called
String myString = "this is a valid way of declaring a string";
String myStringTwo = "this is a valid way of declaring a string";
System.out.println(myString.equals(myStringTwo)); // returns true

// using the new keyword will create a new instance of the string in the pool
String myString = "this is a valid way of declaring a string";
String myStringTwo = new String("this is a valid way of declaring a string");
System.out.println(myString.equals(myStringTwo)); // returns true, compares content
System.out.println(myString == myStringTwo);// returns false, compares memory location of objects 
```

## Wrapper Classes
Wrapper classes are the object versions of primitives. There are methods that require the use of objects for them to function, these wrapper classes allow primitives to be passed in as arguments. Java can handle much of this logic for you:

Autoboxing
- Java's automatic conversion of a primitives to an object, or vice versa

Boxing
- converting a primitive to a wrapper class

Unboxing
- converting a wrapper class to a primitive
```java
public static void main(String[] args){
    int x = 5;
    needObject(x)// will print 10, x will be autoboxed into its wrapper class
}
public static void needObject(Integer num){
    System.out.print(num + 5);
}
```

# Maven
Maven is a Java "build" tool that allows you to manage your Java projects, some of the common use cases are:
- add third party libraries to your application
- package your application for distribution
- facilitate your software tests

## Maven Repository
A central location where you can download libraries and frameworks for your Java application. These are managed by your POM.xml, if you create maven project. There is a local maven repository ($HOME/.m2/repository) maven will check first, then it will check the online repository for artifacts. If found, it will download the library for your project.

## Project Object Model
The Project Object Model (.xml) is how Maven knows how to build your project. It includes your dependencies, plugins, build information, and other resources needed to package and manage your application
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!--the project tag is the root tag-->
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <!--determins what pom version to use-->
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>examplework</artifactId>
    <version>1.0-SNAPSHOT</version>
    <!--project specific settings-->
    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>
    <!--This is where you put your various dependencies. They include groupID, artifactId, and version-->
    <dependencies>
        <!--each dependency goes inside its own tags-->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
    </dependencies>

</project>
```

## Project Coordinates
These are various identifiers for your Maven project:
- group-id: The group, company, team, organization, project, or other group. for example: "com.revature"
- artifact-id: A unique identifier under groupId that represents a single project. for example: "myproject"
- version: A specific release of a project. Projects in development usually include "SNAPSHOT"
- packaging: The type of project, defaulting to jar, describing the packaged output produced by a project.

## Maven Life Cycle
These are the phases of a Maven build life cycle, note that many of the later phases require using additional software to work properly:
1. Validate => project is correct and all necessary information is available
2. Compile => compiles project source code
3. Test => tests all compiled code
4. Package => packages all compiled code to WAR/JAR file
5. Integration => performs all integration tests on WAR/JAR
6. Verify => runs checks on the results of integration tests
7. Install => installs WAR/JAR to local repository
8. Deploy => copies final WAR/JAR to the remote repository

