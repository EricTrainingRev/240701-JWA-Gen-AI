package controller;

import exception.IncompatibleCaseException;
import exception.InvalidCaseException;
import service.CaseService;

/*
    Controller classes are typically used to handle data transferring between the user and the
    application. A user will provide input some way, and the controller class will pass the user
    input to whatever (typically) service class you have created to handle the business or software
    requirements of the application. Think of controller classes as the middle men of the application:
    they help transport data
 */

public class CaseController {

    public CaseService caseService;

    public CaseController(CaseService caseService){
        this.caseService = caseService;
    }

    public String caseSelection(String variable, String initialCase, String targetCase) {
        /*
            the initialCase gives us the starting rules of how the String is formatted, and
            the targetCase gives us the new transformation rules we need to follow in order
            to convert the casing of the variable name correctly.
         */
        try{
            caseService.validateCaseIdentifiers(initialCase, targetCase);
            if (initialCase.equals("2") && targetCase.equals("3")){
                return pascalToCamel(variable);
            }
            throw new IncompatibleCaseException(String.format("Invalide combination of cases:\n" +
                    "initial case: %s\n" +
                    "target case: %s", initialCase, targetCase)
            );
        } catch (IncompatibleCaseException | InvalidCaseException exception){
            return exception.getMessage();
        }
    }

    public String pascalToCamel(String variable){
        StringBuilder camelBuilder = new StringBuilder(variable);
        char firstcharacter = camelBuilder.charAt(0);
        String firstCharacterAsString = Character.toString(firstcharacter);
        String firstCharacterAsLowercaseString = Character.toString(firstcharacter).toLowerCase();
        camelBuilder.replace(0,1, firstCharacterAsLowercaseString);
        return camelBuilder.toString();
    }

}
