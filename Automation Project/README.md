# JWA Foundation Project
The Planetarium is a web application designed by Revature Space Initiative for astronomers to track celestial bodies they discover in the night sky. Development work on the application is progressing, and the company wants to bring in testers to improve Quality Control to further improve product quality. The company was very happy with the manual testing done last Sprint, and they would like for you and your team to build automated versions of your previous manual tests in order to make retesting easier in the future. Your Job this Sprint is to build an automated test suite to perform System testing on the planetarium application

## Project Focus
- Java
- Selenium
- Cucumber
- Junit
- Jira
- Test Case Creation
- Test Reporting
- System Testing

## Software Requirements  
- Users should have unique usernames
- Usernames and passwords should not be longer than 30 characters
- Planet and Moon names should not have more than 30 characters
- Planets and moons should have unique names
- Planets should be “owned” by the user that added it to the Planetarium
- Moons should be “owned” by the Planet the User adding the moon associated it with
- Planets and Moons should allow adding an associated image, but an image should not be required for the data to be added to the database

## Use Cases
- Users should be able to open a new User account with the Planetarium
- Users should be able to securely access their account
- Users should be able to see planets and moons added to the Planetarium
- Users should be able to add new Planets to the Planetarium
- Users should be able to remove Planets from the Planetarium
- Users should be able to add Moons to the Planetarium associated with a Planet
- Users should be able to remove Moons from the Planetarium

## Testing Requirements
- All Test Reporting should be done in Jira
- All Use Cases require a minimum of one positive test
- All Use Cases with associated software requirements require negative testing to verify requirements are met
- All Use Cases with Software Requirements that limit data **input** require Boundary Analysis Testing
- All Use Cases with Software Requirements that limit data **visibility** require Error Guess Testing
- All Use Cases with Software Requirements that limit data **interaction** require Error Guess Testing
- All tests that fail should be logged in a Defect Report inside of Jira
- Acceptance testing for the user experience should answer the following questions in detail:
    - Is the intended use of the service intuitive?
    - Is the service easy to use?
    - Does the service inspire confidence?
    - Is the service pleasing to look at?

## Test Software Requirements
- web page information should be saved in Page Object Models for ease of refactoring and updating
- feature files should be used to link Acceptance Criteria to code execution in order to perform End to End testing
- A test runner class should be used to facilitate the End to End testing

## Defect Report Requirements
- All Defect Reports should include the following information
    - unique id
    - description
    - associated Test Object
    - associated Test Data

## MVP Requirements
- All previous manual tests for System testing are automated
- Requirement Traceability Matrix contains the Acceptance Criteria
- Acceptance Criteria are created for Use Cases
- Test Cases are saved in Jira
- Automated Tests are complete
- Test Results are saved in Jira
- Defect Reports are created for each failed test
- Defect Reports are saved in Jira

## Suggested Stretch Goals
- perform extra Error Guess Testing
- perform Non-Functional System testing

## Setup Requirements
- an environment variable called "PLANETARIUM" needs to be set with the JDBC url for the planetarium database
    - SQLite3 is used by the application
- a database needs to be created and set up for the planetarium to work properly. Use the ```setup-reset.sql``` file to create the database at the same location as your "PLANETARIUM" environment variable
-  start the application with the command ```java -jar path/to/Planetarium-1.0-shaded.jar```

## Project Presentation Order of Operations
1. Show your final test report for the System Tests you performed
    - this should be generated via AIO in your Jira project
2. Show your final test report for the Acceptance Tests you performed
    - As long as the data is organized and stored in Jira you have flexibility in how you craft this data
4. Talk through your process on the following subjects
    - how did you go about organizing/executing your Systems tests?
        - show your boundary analysis value data organization
        - showcase the tests you came up with through Error Guessing
    - how did you go about organizing/executing your Acceptance Tests?
    - how did you organize your defect reports?
    - what went well during your testing process?
    - what will you do differently during the next round of testing to build upon and/or improve on your previous testing cycle?