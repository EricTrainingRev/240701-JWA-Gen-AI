import controller.CaseController;
import controller.PromptController;
import entity.CaseOption;
import service.CaseService;

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
            PromptController promptController = new PromptController(scanner);
            CaseService caseService = new CaseService();
            CaseController caseController = new CaseController(caseService);
            boolean continueApplication = true; // we will change this to false when the app finishes
            while(continueApplication){
                // this is where we will put our code to get the user input
                String initialVariable = promptController.promptUserForInitialVariableName();
                if(initialVariable.equals("q")){
                    // this is where we will put our code to exit the loop
                    System.out.println("Goodbye!");
                    // we use break to exit the loop
                    break;
                }
                // we will also get the initial case styling of the input
                CaseOption startingCase = promptController.promptUserForInitialCasing();
                // and we will get the target casing to change the input into
                CaseOption targetCase = promptController.promptUserForTargetCasing();
                // this is where we will put our code to show the output
                // of the case conversion
                String result = caseController.caseSelection(initialVariable, startingCase, targetCase);
                System.out.println("transformation result: " + result);

            }
        }

    }
}
