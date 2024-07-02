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
Java handles two kinds of data types: primitives and references. Primitives are variables that store simple values. There are eight in Java.
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

common conventions:
- constant values: UPPERCASE
- class/interface names: PascalCase
    - unique words start with upper case letter, no space or special character between words
- others: camelCase
    - first unique word starts with lower case letter, all following words start with upper case letter, no special characters between words

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

## methods & parameters
```java
class myClass{
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
2. Instance/object scope
    - available to the instance of an object
    - **this** keyword is used to interact with an instance variable
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
        MyClass.classCount += addOneToClass; // referenced by the class name
        this.objectName = objectName; // referenced by the "this" keyword
    }

    public static void countClass(){
        if (MyClass.classCount > 0){
            System.out.println(MyClass.classCount);
        } else {
            int zero = 0; //block scope: only exists here in the code
            System.out.println(zero);
        }
    }
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

## control flow
these keywords control the flow of logic and code execution in your program
```java
// if statements only run when their indicated logic is achieved
int x = 5;
if(x == 5){
    System.out.println("this is true");
}

// you can include an else statement that will run if your if block does not run
int x = 5;
if(x==6){
    System.out.println("this is true");
} else {
    System.out.println("this is not true");
}

// you can utilize else if statements to add more potential triggers
int x = 7
if(x==5){
    System.out.println("this is not true, so it will not trigger")
} else if (x == 7){
    System.out.println("this block of code will trigger because x = 7")
} else if (x == 8){
    System.out.println("This also will not trigger")
} else {
    System.out.println("this will not trigger because the else if is going to trigger")
}

// for loops re-execute the same block of code until their condition is met
for (int x = 0; x < 10; x++){ //(declaration;condition;declaration)
    System.out.println(x);
}

// enhanced for loops can iterate through an object that implements the iterable interface
int[] myInts = new int[]{1,2,3,4,5};
for (int num : myInts){
    System.out.println(num);
}

// while loops test a condition and execute code in a loop till the condition is no longer true
int x = 0;
while (x < 10){
    System.out.println(x);
    x++;
}

// do while loops work the same as above, except the code executed in the do executes at least once
int x = 10
do{
    System.out.println("this prints once despite x !< 10")
} while (x < 10);

// switch statements take a variable and execute code based upon the given value
// can take in a byte, short, char, int, enum, and string. use break to prevent cascading code
int x = 10;
switch(x){
    case 1:{
        System.out.println("this will not show because x = 10");
        break;
    }
    case 5:{
        System.out.println("this also does not show");
        break;
    }
    case 10:{
        System.out.println("this will show because x = 10");
        break;
    }
    default:{
        System.out.println("this shows if no other condition is met");
        break;
    }
}
```