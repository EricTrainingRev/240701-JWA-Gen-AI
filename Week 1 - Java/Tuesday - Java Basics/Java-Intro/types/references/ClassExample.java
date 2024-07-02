package types.references;

/*
    This is our bread and butter of reference types: we define
    information in our classes and then create "objects" of those
    classes to do the things we want to do
 */

public class ClassExample {

    // classes can have fields (individual references)
    int numData;
    String phrase;


    // classes can also have "behaviors" (methods)
    public void sayPhrase(){
        System.out.println(phrase);
    }


    public static void main(String[] args) {
        /*
            to make use of the ClassExample data I have defined
            I need to create an object of my class.

            When instantiating objects of a class make sure you initialize
            all the data you need to work with. You can reference the
            fields directly to set the values, but we will cover more
            convenient ways to do this in the future
         */
        ClassExample exampleObject = new ClassExample();
        exampleObject.phrase = "Hello world!";
        exampleObject.sayPhrase();
        exampleObject.numData = 567;
        exampleObject.phrase = "numData is: " + exampleObject.numData;
        exampleObject.sayPhrase();
    }

}
