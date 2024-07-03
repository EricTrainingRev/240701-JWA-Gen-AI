import java.util.Scanner;

/*
    We are going to build an application that converts variable names into different cases.
 */

public class Main {
    public static void main(String[] args) {

        /*
            Scanner objects do not close themselves by default, even if your application stops
            running. An easy way to make sure your scanner is not taking up system resources
            after your application is done running is to wrap it in a try with resources block.
            Scanners implement an auto closeable interface that allows for Java to automatically
            close the object and free the resources it was using for you

         */
        boolean continueApplication = true; // we will change this to false when the app finishes
        try(Scanner scanner = new Scanner(System.in)){
            while(continueApplication){
                // this is where we will put our code to get the user input
                System.out.print("Please give me your variable name (enter q to quit): ");
                String initialVariable = scanner.nextLine();
                if(initialVariable.equals("q")){
                    // this is where we will put our code to exit the loop
                    System.out.println("Goodbye!");
                    continueApplication = false;
                }
                // we will also get the initial case styling of the input
                System.out.print("Please indicate what case your variable is in by selecting the \n" +
                        "associated number:\n" +
                        "1. UPPERCASE\n" +
                        "2. PASCAL\n" +
                        "3. CAMEL\n" +
                        "4. SNAKE\n" +
                        "5. SCREAMINGSNAKE\n" +
                        "your choice: ");
                String startingCase = scanner.nextLine();
                // and we will get the target casing to change the input into

                // this is where we will put our code to show the output
                // of the case conversion
                System.out.println(initialVariable);
                System.out.println(startingCase);

            }
        }

    }
}
