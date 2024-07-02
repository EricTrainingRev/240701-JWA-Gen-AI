package classes;

/*
    When working with classes there are many features you should be aware
    of when building your own
 */
public class ClassBasics {
    public static void main(String[] args) {
        Person.checkPeopleInExistance(); // we can reference class (static) methods from the class directly
        Person bill = new Person(52, "Bill"); // this constructor sets the age and name of the object
        Person sally = new Person(); // this constructor does not set any instance fields of the object
        bill.shareAge(); // we can reference instance methods from objects of the class
        Person.checkPeopleInExistance();
    }
}
