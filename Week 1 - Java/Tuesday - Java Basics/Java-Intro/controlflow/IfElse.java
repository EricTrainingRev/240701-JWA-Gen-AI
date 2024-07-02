package controlflow;

/*
    When you need to control the flow of your application your
    if, else, and else if?. Using these keywords you can control
    what sections of your code you execute depending on logical
    statements you place inside your code
 */

public class IfElse {
    public static void main(String[] args) {
        /*
            your basic logical operators
            - > greater than
            - < less than
            - >= greater or equal to
            - <= less or equal to
            - == equal
            - != not equal

            you can also add '!' to the start of a logical statement to flip the logic: if false
            then do the thing

            you are not limited to making only one logical check: you can chain them if you want
         */
        if(10 < 5){
            System.out.println("if the logical statement above returns true this will print");
        }

        /*
            If you want to trigger your code if one or more conditions are true you can use the
            logical OR operator '||'. If you want both/all statements to be true in order to execute
            the code you use an '&&'
         */
        if (5 < 10 && 6 < 4){
            System.out.println("this will print if either statement is true");
        }

        // if you want to trigger a different block of code if the logic is not met use an else statement

        if(10<5){
            System.out.println("You should not be seeing this!");
        } else {
            System.out.println("10 is not less than 5");
        }

        /*
            If you have multiple logical checks you could make, but don't need to if earlier
            checks return true, you can use an else if statement to further refine what code
            is executed when run
         */
        if(false){
            System.out.println("You should not be seeing this!");
        } else if (true){
            // only this block of code should execute from this if/else if/else chain
            System.out.println("You should be seeing this!");
        } else{
            System.out.println("You should not be seeing this!");
        }

    }
}
