import controller.CaseController;
import controller.SystemPrompt;
import exception.IncompatibleCaseException;
import exception.InvalidCaseException;

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

        try(Scanner scanner = new Scanner(System.in)){
            SystemPrompt systemPrompt = new SystemPrompt(scanner);
            CaseController caseController = new CaseController();
            boolean continueApplication = true; // we will change this to false when the app finishes
            while(continueApplication){
                // this is where we will put our code to get the user input
                String initialVariable = systemPrompt.promptUserForInitialVariableName();
                if(initialVariable.equals("q")){
                    // this is where we will put our code to exit the loop
                    System.out.println("Goodbye!");
                    // we use break to exit the loop
                    break;
                }
                // we will also get the initial case styling of the input
                String startingCase = systemPrompt.promptUserForInitialCasing();
                // and we will get the target casing to change the input into
                String targetCase = systemPrompt.promptUserForTargetCasing();
                // this is where we will put our code to show the output
                // of the case conversion
                String result;
                boolean startingCaseIsValid = Integer.parseInt(startingCase) >= 1
                        &&
                        Integer.parseInt(startingCase) <= 5;
                boolean targetCaseIsValid = Integer.parseInt(targetCase) >= 1
                        &&
                        Integer.parseInt(targetCase) <= 5;
                try{
                    if (startingCaseIsValid && targetCaseIsValid){
                        result = caseController.caseSelection(
                                initialVariable,
                                startingCase,
                                targetCase);
                    } else {
                        throw new InvalidCaseException("Invalid number provided for one or more cases");
                    }
                } catch (InvalidCaseException exception){
                    result = exception.getMessage();
                }
                System.out.println("transformation result: " + result);



            }
        }

    }
}
