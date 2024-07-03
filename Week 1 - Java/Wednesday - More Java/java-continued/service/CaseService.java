package service;

/*
    This class is going to be used to validate that the user provides
    inputs for cases that are valid. If the user does not provide valid
    inputs then we will also provide code in this class to handle those
    situations
 */

import exception.InvalidCaseException;

public class CaseService {

    public void validateCaseIdentifiers(String startingCaseIdentifier, String targetCaseIdentifier) throws InvalidCaseException{
        boolean startingCaseIsValid = Integer.parseInt(startingCaseIdentifier) >= 1
                &&
                Integer.parseInt(startingCaseIdentifier) <= 5;
        if (!startingCaseIsValid){
            throw new InvalidCaseException("Starting case identifier is invalid: please pick 1-5");
        }
        boolean targetCaseIsValid = Integer.parseInt(targetCaseIdentifier) >= 1
                &&
                Integer.parseInt(targetCaseIdentifier) <= 5;
        if (!targetCaseIsValid){
            throw new InvalidCaseException("Target case identifier is invalid: please pick 1-5");
        }
    }

}
