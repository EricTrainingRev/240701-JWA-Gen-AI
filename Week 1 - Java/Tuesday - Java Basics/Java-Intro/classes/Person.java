package classes;

public class Person {

    /*
        The fields defined below are instance variables: every time you make an object of this
        class each individual object will have its own age and name property: these value are
        not shared among objects.
     */
    int age;
    String name;

    /*
        If you want to make properties that are shared among your objects you need to make them
        "static": this changes ownership of the property from the individual objects to the class
        itself, which makes the properties shared among all your objects
     */

    static int peopleInExistance = 0;

    /*
        All classes have a "no args" constructor provided to them by
        default by Java. This is why you can make objects of any classes
        you define. You are able to define your own constructors to change
        what happens when you create objects of your classes
     */
    public Person(int age, String name){
        // this.age references the age property of the object being made
        // age references the value provided to the constructor in the first position
        this.age = age;

        // this.name references the name property of the object being made
        // name references the value provided to the constructor in the second position
        this.name = name;
        System.out.println("Hello! My name is " + name + "! Nice to meet you!");
        Person.peopleInExistance++;
    }

    public Person(){
        // If you still want access to a no args constructor you can define it for yourself
        // note: if you define your own custom constructor like above then you will lose access
        // to the pre-provided no args constructor
        Person.peopleInExistance++;
    }

    /*
        we could continue and make individual constructors to initialize each field individually,
        or some combination of fields, there is flexibility in what constructors you define
     */




    /*
        If you want to access your static properties via a method you make the method static
        so that it belongs to the Class and not Objects of the class. You can technically call
        static methods via objects, but your IDE will yell at you
     */
    public static void checkPeopleInExistance(){
        System.out.println("People in existance: " + peopleInExistance);
    }

    public void shareAge(){
        System.out.println("I am " + age + " years old");
    }

}
