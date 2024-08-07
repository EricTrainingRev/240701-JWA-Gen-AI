package com.revature.basics;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/*
    You could shorthand the imports above with: import org.junit.*;
*/

public class TestAnnotations {

    // this field is used for our @Before example and testThree
    private String input;


    /*
        Anytime you have resources you need for your tests that are shared across test methods you can use a
        setup method annotated with @BeforeClass to initialize those shared resources. To make this work the
        setup method must be a static method: since the resources being initialized are assumed to be shared
        resources, Junit makes the assumption they are static and therefore any @BeforeClass annotated methods
        must be static methods, otherwise an exception will be thrown
     */
    @BeforeClass
    public static void setup(){
        System.out.println("This runs once before everything else");
    }

    /*
        When you have objects you need to initialize for your test methods a @Before annotated method is used to do
        so. A method with this annotation will run before each @Test annotated method, and can be thought of as similar
        to a constructor for your test classes. The reason you should use the @Before method as your constructor as
        opposed to an actual constructor is because the @Before annotation will give you better feedback if something
        goes wrong in the setup. Also, from a practical perspective, Junit assumes your test classes have only a single
        no args constructor, and will throw an exception if you try creating your own custom constructor.
     */
    @Before
    public void initialize(){
        System.out.println("This runs before every @Test annotated method");
        input = "We provide this manually";
    }

    /*
        The @Test annotation is how you tell Junit a method is a test case. When you run your tests Junit will create
        a new object of your class that holds the test case for each run of any method annotated with @Test annotation.
        This means that you can not use the test class itself to share any information between your test cases: you either
        have to use another solution to share information (not recommended) or you need to design your test cases in such
        a way that they do not rely on each other for their success
     */
    @Test
    public void testOne(){
        System.out.println("Test one executed");
        System.out.println(this); // this will be different from testTwo
    }

    /*
        Ideally, your test cases should be written in such a way that they succeed/fail in isolation from each other.
     */
    @Test
    public void testTwo(){
        System.out.println("Test two executed");
        System.out.println(this); // this will be different from testOne
    }

    @Test
    public void testThree(){
        // because we initialize the input field in our @Before method, it will print correctly here
        System.out.println(input);
    }

    /*
        You can use an @After annotated method to perform any sort of teardown that needs to happen after each test method
        is executed. This is particularly useful when you have non-static resources that need to be closed after a test
        case is executed. You can think of an @After annotated method as being similar to a finally block.
     */
    @After
    public void afterTest(){
        System.out.println("This runs after each @Test annotated method");
    }

    /*
        Anytime you have static resources that need to be handled (closed, destroyed, etc.) or any closing actions that
        need to be taken, a teardown method annotated with @AfterClass will execute after all test cases associated
        with the class are executed. Methods annotated with @AfterClass follow the same rules as those annotated with
        @BeforeClass
     */
    @AfterClass
    public static void teardown(){
        System.out.println("This runs once after everything else");
    }

}
