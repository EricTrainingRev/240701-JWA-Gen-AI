package controller;

import java.util.Scanner;

public class SystemPrompt {

    public Scanner scanner;
    public SystemPrompt(Scanner scanner){
        this.scanner = scanner;
    }

    public final String VARIABLENAMEPROMPT = "Please give me your variable name (enter q to quit): ";
    public final String INITIALCASINGPROMPT = "Please indicate what case your variable is in by selecting the \n" +
            "associated number:\n" +
            "1. UPPERCASE\n" +
            "2. PASCAL\n" +
            "3. CAMEL\n" +
            "4. SNAKE\n" +
            "5. SCREAMINGSNAKE\n" +
            "your choice: ";
    public final String TARGETCASINGPROMPT = "Please indicate what case your variable should transform into by selecting the\n" +
            "associated number:\n" +
            "1. UPPERCASE\n" +
            "2. PASCAL\n" +
            "3. CAMEL\n" +
            "4. SNAKE\n" +
            "5. SCREAMINGSNAKE\n" +
            "your choice: ";

    public String promptUserForInitialVariableName(){
        System.out.print(VARIABLENAMEPROMPT);
        return scanner.nextLine();
    }

    public String promptUserForInitialCasing(){
        System.out.println(INITIALCASINGPROMPT);
        return scanner.nextLine();
    }

    public String promptUserForTargetCasing(){
        System.out.println(INITIALCASINGPROMPT);
        return scanner.nextLine();
    }
}
