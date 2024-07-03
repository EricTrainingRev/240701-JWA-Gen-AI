package controller;

import entity.CaseOption;
import exception.InvalidCaseException;

import java.util.Scanner;

public class PromptController {

    public Scanner scanner;
    public PromptController(Scanner scanner){
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

    public CaseOption promptUserForInitialCasing(){
        System.out.println(INITIALCASINGPROMPT);
        int initialId = scanner.nextInt();
        return getCaseOption(initialId);
    }

    public CaseOption promptUserForTargetCasing(){
        System.out.println(INITIALCASINGPROMPT);
        int targetId =  scanner.nextInt();
        return getCaseOption(targetId);
    }

    public CaseOption getCaseOption(int id){
        CaseOption caseOption;
        switch(id){
            case 1:
                caseOption = CaseOption.UPPERCASE;
                break;
            case 2:
                caseOption = CaseOption.PASCAL;
                break;
            case 3:
                caseOption = CaseOption.CAMEL;
                break;
            case 4:
                caseOption = CaseOption.SNAKE;
                break;
            case 5:
                caseOption = CaseOption.SCREAMINGSNAKE;
                break;
            default:
                caseOption = CaseOption.INVALID;
        }
        return caseOption;
    }
}
