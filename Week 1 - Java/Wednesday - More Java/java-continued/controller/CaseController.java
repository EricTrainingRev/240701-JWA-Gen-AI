package controller;

public class CaseController {

    public String caseSelection(String variable, String initialCase, String targetCase){
        /*
            the initialCase gives us the starting rules of how the String is formatted, and
            the targetCase gives us the new transformation rules we need to follow in order
            to convert the casing of the variable name correctly.
         */
        if (initialCase.equals("2") && targetCase.equals("3")){
               return pascalToCamel(variable);
        }
        return "Not implemented yet";
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
