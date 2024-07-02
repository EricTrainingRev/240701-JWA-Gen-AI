package operators;

public class Maths {
    /*
        Anytime you want to do basic math you can use a mathematical
        operator to perform your intended action
     */

    public static void main(String[] args) {
        int sum = 5 + 5;
        int difference = 10 - 5;
        int product =  5 * 5;
        int quotient = 5 / 5;

        /*
            Note below how we can use these operators even in non
            mathematical operations: while they are normally used
            for math, while we are programming these operators can
            also be used to perform other software related actions.

            in the examples below the + operator is being used to
            perform string concatenation: this is where one or
            more values are appended to the String and used in
            whatever operation you are trying to perform
         */
        System.out.println("addition: " + sum);
        System.out.println("difference: " + difference);
        System.out.println("product: " + product);
        System.out.println("quotient: " + quotient);
    }
}
