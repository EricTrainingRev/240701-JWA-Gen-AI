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
- perform extra Acceptance Testing

## Setup Requirements
- an environment variable called "PLANETARIUM" needs to be set with the JDBC url for the planetarium database
    - SQLite3 is used by the application
- a database needs to be created and set up for the planetarium to work properly. Use the ```setup-reset.sql``` file to create the database at the same location as your "PLANETARIUM" environment variable
-  start the application with the command ```java -jar path/to/Planetarium-1.0-shaded.jar```

## Agile Practices
- have a Daily Scrum each day
    - what to cover:
        - give an update on the previous day's work
        - inform your team of what you will work on today
        - discuss any blockers team members are facing
    - make sure to save the topics covered in the Daily Scrum
        - you can do this by uploading notes on the topics covered to your Jira project (Confluence would be good for this) or saving them in your github repository
        - this is so you can track and see if any blockers are persistent or if any features/requirements are proving more difficult to work on than expected
    - don't "over engineer" this meeting: it is simply meant to get everyone on the same page before work each day and assist each other in overcoming any blockers. Anything extra you add to this meeting should be for your benefit as a team
- make sure you assign yourself issues in your Sprint board you are working on. Similar to this, make sure to change the status of the issue depending on whether you are currently working on the issue or if it is finished
    - this provides a quick and easy way to check what needs to be worked on next when you complete a task so you don't accidentally double up on work with someone else
- practice pair programming
    - pair programming roles:
        - have a "driver" that actively writes codes and performs the git commits/pushes
        - have a "navigator" that provides a second pair of eyes on the code being produced
    - the goal of pair programming is to increase the quality of code produced and to increase all team members' understanding of the source code that is produced. Having two pairs of eyes on the code helps to catch errors in the code, and it also means there are at least two people (can have multiple navigators) with an understanding of the source code that is produced. 

## Git Practices
- protect the main branch of the github repo from direct pushes
    - this helps to prevent adding application breaking code into your repo
- determine a branching strategy for your team
    - come up with a standard naming convention so everyone can understand what was worked on in a branch at glance
    - determine how often adds and commits should be created
    - determine how the team is going to create commits (active voice, passive voice, generic messages, etc.)

## Project Presentation Requirements
- 10 minute presentation
- everyone needs to speak
- automated tests need to be demoed
- test results need to be shown

## Project Presentation Order of Operation
- Introduce team
- Introduce project
    - describe goal of this sprint
    - give general overview of what will be covered in the presentation
        - MVP requirements met
        - Stretch goals started/completed
- Describe Agile practices implemented
- Describe Git strategies implemented
- Give demonstration of automated tests in action
- Describe testing strategy
- Show off test results
- give a mini Sprint retrospective
    - what went well
    - what will you improve on next sprint
- field questions