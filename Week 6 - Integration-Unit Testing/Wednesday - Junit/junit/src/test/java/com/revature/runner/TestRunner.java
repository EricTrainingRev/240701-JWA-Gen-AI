package com.revature.runner;

import com.revature.basics.TestAnnotations;
import com.revature.exceptions.TestExceptions;
import com.revature.parameterize.ParameterizeTest;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/*
    A runner class can be used to facilitate executing test suite in your code. Any test
    classes you associate with your runner can be executed all together. This gives you
    greater control over what tests you execute and when you execute them.
 */
@RunWith(Suite.class)
@SuiteClasses(
        {
                TestAnnotations.class,
                TestExceptions.class,
                ParameterizeTest.class
        }
)
public class TestRunner {

        @BeforeClass
        public static void runnerSetup(){
                System.out.println("This method will run before any tests in the suite");
        }

}
