# Types of Testing
- User Acceptance Testing
- End to End testing
- Positive Testing
- Negative Testing

# Functional vs Non-Functional Testing
- Functional testing relates to features users of an application can interact with
    - you can think of it as testing what the system does (enforcing requirements)
- Non-Functional testing relates to features of the way an application operates
    - you can think of it as testing how the system works (performance, security, compatibility, etc.)

# Static vs Dynamic Testing
- Dynamic testing involves testing an application/service that is running
    - every level of the testing pyramid includes some form of Dynamic testing
- Static Testing involves testing the application/service when it is not running
    - code reviews before merging dev branches into a main branch in a version control repository is a good example of static testing: the source code is examined for any errors that could lead to issues in dynamic testing scenarios before the code is merged with the main branch
    - linting tools are often used with Static Testing

# Performance Testing
- typically falls under System Testing
- a form of Non-Functional Testing
- an important form of testing for any company that has Service Level Agreements (SLAs) with their end users
- some common Performance Tests:
    - performance testing: testing the optimization of an application/service
        - latency of requests/responses
        - availability 
        - capability to handle mass data transfer
    - endurance testing: setting up the application in a production like environment and simulating expected user interaction with the service for an extended period of time
        - helps to discover defects that are not present until time has passed
            - memory leaks
            - poorly configured logs
    - load testing: testing the ability of the application and its environment to handle more/less traffic than expected, up to the full capacity of the resources
    - stress testing: testing an application up to and pass its expected full capacity to see where the breaking points are

# Retesting vs Regression Testing
- Retesting is re-running test cases that previously failed
    - verifying a defect has been fixed
- Regression testing is re-running test cases after a new feature or update is integrated in to the application/service
    - a common type of testing done when tests are automated

# Smoke Testing vs Sanity Testing
- Smoke Testing is testing done before the main suite of tests are executed to verify whether the application/service is ready to be tested or not
    - a form of Acceptance Testing
    - "Where there is smoke there is fire"
    - you can think of Smoke testing as a way for testers to validate that testing can begin
    - think of Smoke Testing as a general check up with the doctor
- Sanity Testing is testing done before regression testing to verify that the functionality being tested is in a state where it can be tested
    - subset of Regression testing
    - think of Sanity Testing as a visit to a specialist doctor
