package com.revature.exceptions;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestExceptions {
    /*
        Anytime you have a test where you need to verify your exceptions are working as
        you expect, you have two main options: you can wrap your code in a try/catch block
        and verify things in the catch block, or you can use the Assert class provide
        by Junit to handle your exception instead
     */

    @Test
    public void testByTryCatch(){
        /*
            When you use a try/catch block to handle your exceptions the way you actually
            craft the blocks helps you to understand what it is you are testing for. For
            instance, if you are simply testing that you get the correct message in your
            exception, you can specify that in your Assert call. However, if it is more
            important to check the correct kind of exception is being thrown in a scenario
            where you have multiple possible exceptions that could be thrown, then checking
            the type of the exception may be more important
         */
        try {
            int x = 10 / 0;
            // if testing exceptions using try/catch you need a Assert.fail here to
            // tell Junit this test failed and why
            Assert.fail("Arithemtic Exception should have been thrown");
        } catch (ArithmeticException e){
            Assert.assertEquals("/ by zero", e.getMessage());
        }
    }

    /*
        If you use the Assert.assertThrows method then you have to provide two arguments
        for Junit to test your Exception:
        1.  your expected Exception (can be specific or provide a parent option if the
            specific exception is not in question)
        2.  the code that triggers the exception (typically your method/s being tested,
            depending on whether you are doing integration or unit testing) in executable form.
            This typically looks like providing your code in a lambda
     */
    @Test
    public void testByAssert(){
        Assert.assertThrows(ArithmeticException.class, ()->{
            int x = 10/0;
        });
    }

    @Test
    public void saveExceptionForFurtherTesting(){
        Throwable exception = Assert.assertThrows(Throwable.class,()->{
            int x = 10 / 0;
        });
        Assert.assertEquals("/ by 0", exception.getMessage());
    }

}
