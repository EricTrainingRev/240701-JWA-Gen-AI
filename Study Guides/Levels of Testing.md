# Levels of Testing

## Acceptance Testing

### Typical Objectives
Acceptance Testing is a process that allows for validating the application in question actually meets the requirements of the application owner and the end users to ensure the successful release of the application. This process not only creates confidence in the system as a whole but also ensures that the application is ready for release to users. While system defect identification is not the primary focus, discovering numerous defects may indicate substantial foundational issues within the application. Ideally, Acceptance testing should be done to validate the application, not verify its functionality (verification should be handled in the lower levels of testing)

### Types of Acceptance Testing
- User Acceptance Testing
    - The application handles all requirements needed by the end user
- Operational Acceptance Testing
    - Internal administrative tasks can be handled successfully
        - Data is appropriately backed up
        - Logs are generated correctly
        - Installing/un-installing work correctly
        - Security vulnerabilities are handled
- Contractual and Regulatory Acceptance Testing
    - Ensuring the application meets legal/contract requirements
        - Often done in association with an authority witnessing the testing
            - An auditor from the SEC might verify financial records can't be edited
- Alpha Testing
    - Internal testers/developers test an application to see if it works as intended
- Beta Testing
    - People outside the test/dev teams who are sample end users use the application
    - Spot any issues related to end user expectations

### Typical Defects
- Business rules not implemented or interpreted correctly
- Does not mean contract or regulatory requirements
- Poor performance and non-functional failures
    - images don't load correctly or scale incorrectly
    - page loading takes a long time
- Accessibility features don't work correctly

## System Testing

### Typical Objectives
System Testing involves verifying that functional and non-functional requirements are met when all systems are working together in an application. This includes the database, back end, front end, and supporting cloud infrastructure. Good System Testing can reveal novel defects that are undetectable by lower level testing, and a robust System Testing suite helps create confidence in the system as a whole.

### Types of System Testing
- End to End testing
    - verifying user actions can complete User Stories by fulfilling  Acceptance Criteria
- Performance testing 
    - verifying the application is responsive withing contractual obligations
    - verifying the application has the scaling potential as planned
- Load testing
    - verifying the application can handle the expected number of users
- Compatibility Testing
    - verifying the application works in different environments
        - different browsers
        - different operating systems
- Penetration Testing
    - verifying the security of the application is robust enough to withstands well known attacks

### Typical Defects
- Incorrect or unexpected functional behavior
- System does not conform to specifications
- Inability to complete all parts of end-to-end tasks
- Performance does not meet minimal requirements
- Application does not meet security requirements
- Cloud environment does not scale appropriately