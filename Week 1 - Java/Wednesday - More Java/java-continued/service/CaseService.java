package service;

/*
    This class is going to be used to validate that the user provides
    inputs for cases that are valid. If the user does not provide valid
    inputs then we will also provide code in this class to handle those
    situations
 */

import entity.CaseOption;
import exception.InvalidCaseException;

public class CaseService {

    /*
        Because we refactored our CaseOption enum to provide a numeric value with each enum
        we can now directly use our enum in the verification of the user input without performing
        any kind of string to number data transformation
     */
    public void validateCaseIdentifiers(CaseOption startingCaseIdentifier, CaseOption targetCaseIdentifier) throws InvalidCaseException{
        boolean startingCaseIsValid = startingCaseIdentifier.getCaseIdentifier() >= 1
                &&
                startingCaseIdentifier.getCaseIdentifier() <= 5;
        if (!startingCaseIsValid){
            throw new InvalidCaseException("Starting case identifier is invalid: please pick 1-5");
        }
        boolean targetCaseIsValid = targetCaseIdentifier.getCaseIdentifier() >= 1
                &&
                targetCaseIdentifier.getCaseIdentifier() <= 5;
        if (!targetCaseIsValid){
            throw new InvalidCaseException("Target case identifier is invalid: please pick 1-5");
        }
    }

    public String pascalToCamel(String variable){
        return makeFirstCharacterLowercase(variable);
    }

    public String pascalToSnake(String variable){
        // CaseOption - case_option
        // convert first letter to lowercase
        StringBuilder snakeBuilder = new StringBuilder(makeFirstCharacterLowercase(variable));
        // add an underscore before all other uppercase letters and
        // find all other uppercase letters and convert to lowercase
        int index = 0;
        for (char c : snakeBuilder.toString().toCharArray()){
            String variableCharacter = Character.toString(c);
            String uppercaseCharacter = Character.toString(c).toUpperCase();
            if (variableCharacter.equals(uppercaseCharacter)){
                snakeBuilder.replace(index, index+1, String.format("_%s",variableCharacter.toLowerCase()));
            }
            index++;
        }
        return snakeBuilder.toString();
    }

    public String makeFirstCharacterLowercase(String variable){
        StringBuilder camelBuilder = new StringBuilder(variable);
        char firstCharacter = camelBuilder.charAt(0);
        String firstCharacterAsString = Character.toString(firstCharacter);
        String firstCharacterAsLowercaseString = Character.toString(firstCharacter).toLowerCase();
        camelBuilder.replace(0,1, firstCharacterAsLowercaseString);
        return camelBuilder.toString();
    }

}
