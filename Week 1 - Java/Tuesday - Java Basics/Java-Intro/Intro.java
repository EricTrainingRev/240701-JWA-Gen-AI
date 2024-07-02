public class Intro {
    /*
        Some of the features of Java:

        - Java is a "high level" language
            - this means we don't have to worry about memory management

        - Java is a statically typed language
             - you have to declare your data types

        - Java is a strongly typed language
            - Java will not automatically change data types for you
                - there are a few exceptions to this rule

            - Java is an Object Oriented Programming language
                - works with classes and objects
                - classes are where we define our data
                - objects are where we implement our data

            - Java is a "Write once, run anywhere" language
                - as long as a computer has a compatible Java Runtime
                  Environment it can execute your code, no adjustments
                  needed

            - There are three main resources you should be aware of for
              Java
                - Java Development Kit
                    - this contains the tools needed to build a Java application
                        - compiler
                        - debugger
                        - development libraries
                - Java Runtime Environment
                    - this contains the runtime libraries necessary for a Java app to function
                - Java Virtual Machine
                    - The JVM takes your class data and converts it into byte code that
                      your computer can execute
     */

    public static void main(String[] args) {
        // static typing
        String greeting = "Hello world!";
        System.out.println(greeting);
    }
}
