package com.revature;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/*
    When you need to perform unit testing on a class that has other classes it relies on (think a service
    class that makes use of a repository class) it can be difficult to effectively create unit tests
    for these classes. This is because, by design, they can only perform their functions if their
    dependencies are working correctly. If you just need to do integration testing this is a non-issue,
    but if you need to do unit testing then your best option is to create "mock" version of the
    dependency classes and "stub" the results of their methods
        - mock = a class that is used as a dependency in place of the real thing
        - stub = a method that has a pre-determined return value used for testing
 */

public class MockTest {

    private Repo repo;

    private Service service;

    @Before
    public void setup(){
        /*
            anytime you need to mock a dependency you can use the Mockito class to create a mock
            object that can be used as the dependency
         */
        repo = Mockito.mock(Repo.class);
        service = new Service(repo);
    }


    /*
        testing the repo object requires no special setup: the class
        has no dependencies, so we can just call the method being tested
        and have confidence that it will succeed/fail on its own.

        commented out so mock examples will run smoothly
     */
//    @Test
//    public void testRepo(){
//        String result = repo.getPerson("Sally");
//        Assert.assertEquals("Sally found!",result);
//    }

    /*
        Unlike the test above, despite the test code being almost identical, the test case below
        is an integration test, not a unit test. That in itself is not a bad thing, but if your goal
        is to create unit tests (and your goal should be to create unit tests alongside your integration
        tests) then you need to find a way to decouple your service methods from their repo methods they
        rely on. This is where Mockito can help us
     */
    @Test
    public void testServiceNoMockConfiguration(){
        /*
            By default, if you don't tell Mockito what value to return
            for any methods called on the mock object, they will return
            the default initialize value for the type. In this case, since
            a string is returned by the repo method getPerson the value of
            null is returned, which is not what we want
         */
        String result = service.getValidPeople("Sally");
        Assert.assertEquals("Sally found!", result); // this will fail because "Sally found!" != null
    }

    @Test
    public void basicStub(){
        /*
            To actually stub the results of a dependency method we make use of the Mockito when()
            method: we need to provide the specific code that is going to to be executed, and then
            we provide what result we want
                - when() = where the code being executed is defined
                - thenReturn() = what value we want returned from the method call

            Note that the value you return only needs to be a valid type, and as long as it is, then
            it is a valid option to return from your stubbed method. Typically though, you would want
            to return the expected value (you would make the assumption that, if the method were actually
            implemented and called, this is the value you would get back)
         */
        Mockito.when(repo.getPerson("Sally")).thenReturn("Sally found!");
        String result = service.getValidPeople("Sally");
        Assert.assertEquals("Sally found!", result);
    }

    @Test
    public void canStubExceptions(){
        Mockito.when(repo.getPerson("Clark")).thenThrow(new RuntimeException("we can stub our exceptions"));
        Assert.assertThrows(RuntimeException.class, ()->{service.getValidPeople("Clark");});
    }

    @Test
    public void specificWhenDataRequired(){
        /*
            In this example, we tell the mock to expect this method and argument call, but we
            provide different data. Since we did not tell the mock in this example what to
            do when "Sally" is provided, it returns the default version of the type, which in
            this case, is null, and so the test fails
         */
        Mockito.when(repo.getPerson("Bruce")).thenReturn("Bruce found!");

        String result = service.getValidPeople("Sally");
        Assert.assertEquals("Sally found!", result);
    }

}
