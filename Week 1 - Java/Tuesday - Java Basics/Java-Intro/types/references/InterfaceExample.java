package types.references;

/*
    We will cover interfaces in more detail later, but for now just know that an interface is
    like a contract between itself and any class that implements the interface. Any properties
    defined in the interface will be added to the class the implements the interface

    Interfaces have a couple of default implementations:
        - all fields in an interface are "public static final" by default
            - public = can access the property from anywhere in your code
            - static = referenced via the class, not the objects of the class
            - final = the value can't be changed after it is defined

        - all methods in an interface are "public abstract" by default
            - public = can access the property from anywhere in your code
            - abstract = the method will be implemented somewhere else: it is just declared here
 */

public interface InterfaceExample {

    // this is the same as:
    // public static final String greeting = "Hello world!";
    String greeting = "Hello world!";

    // if defining a basic interface method leave off the {}
    // this is the same as:
    // public abstract void shareGreeting();
    void shareGreeting();

    // if you want to define the behavior of the method inside
    // the interface you use the default keyword
    default void defaultMethod(){
        System.out.println("This code was defined in the interface!");
    }

}
