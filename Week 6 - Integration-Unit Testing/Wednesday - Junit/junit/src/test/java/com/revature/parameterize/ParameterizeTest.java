package com.revature.parameterize;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

/*
    If you ever have a situation where you need to pass parameterized data into one or
    more test cases, you can tell Junit to run your tests using the Parameterized class
    by annotating your test class with the @RunWith annotation like below.
 */

@RunWith(Parameterized.class)
public class ParameterizeTest {

    /*
        When you are indicating the fields that are your parameters you annotate them
        with @Parameter. If your data sets include multiple values then you provide the
        index position of the data for your field as an argument to the annotation
     */
    @Parameter// no argument means data at index position 0 will be provided
    public int number;
    @Parameter(1)// 1 here means data from index position 1 will be provided
    public boolean isEven;

    /*
        To tell Junit what your parameterized data is you need to make a public static
        method and annotate it with @Parameters. The return value of this method will
        be used to inject your fields with the data you need. If your data have varying
        types then your best option is to create an array of Objects to hold all the
        data (since all types inherit from Object, all types are valid to be placed in the
        array). If you have multiple sets of data then creating a 2d array (an array of arrays)
        allows you to store all the information you need for your multiple types
     */
    @Parameters
    public static Object[][] inputs(){
        /*
            Here we are using a 2d array of Objects, meaning an array that contains
            an array of objects, to store our data for our parameterized test. For each
            array of data stored in the outer array the test case will be executed, and
            the data provided by the array will be set in the Parameter fields
         */
        return  new Object[][] {
                {10,true},
                {11,false}
        };
    }


    /*
        We can reuse this test case for each collection of data for our parameterized
        data: for each collection of data the test will be executed, and each individual
        execution will count as its own test case
     */
    @Test
    public void isEvenOrOdd(){
        Assert.assertEquals(isEven, number%2==0);
    }

    /*
        Any test class that is run with the Parameterized Runner will execute every
        test method a number of times equal to the number of parameter sets provided
        to the class. This means you should only create test cases that require the
        parameter data inside a class that is parameterized. Otherwise you will have
        tests that should only be executed once executing multiple times, which can lead
        to unexpected results
     */
    @Test
    public void noParametersNeeded(){
        System.out.println("this is just here");
    }

}
