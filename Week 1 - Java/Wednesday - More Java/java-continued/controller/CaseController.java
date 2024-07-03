package controller;

import exception.IncompatibleCaseException;

public class CaseController {

    public String caseSelection(String variable, String initialCase, String targetCase){
        /*
            the initialCase gives us the starting rules of how the String is formatted, and
            the targetCase gives us the new transformation rules we need to follow in order
            to convert the casing of the variable name correctly.
         */
        try{
            if (initialCase.equals("2") && targetCase.equals("3")){
                return pascalToCamel(variable);
            }
            throw new IncompatibleCaseException(String.format("Invalide combination of cases:\n" +
                    "initial case: %s\n" +
                    "target case: %s", initialCase, targetCase)
            );
        } catch (IncompatibleCaseException exception){
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
