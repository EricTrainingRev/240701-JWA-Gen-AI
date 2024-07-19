# Terminology

## Test Case
A test case is a collection of scenario, test data, and requirements documented used to verify if a feature and/or requirement is able to be fulfilled. Test Cases typically will include the outcome executing the associated test, who performed the test, and the status of the test

## Defect
A defect a deviation from expected behavior. Defects tend be caused by some form of error in the underlying software

## Error
An Error is some kind of malfunction within the software that is being tested. You can think of it as being similar to having a cold: if you are sick with a cold then you will experience symptoms that are deviations from your desired healthy state. So it would be like your cold is the error, and the symptoms you experience because of your cold are the defects

## Failure
A Failure occurs whenever the testing and dev team don't discover one or more defects which are later discovered and reported by the end user

## Test Data
Test Data is whatever information you need to execute one or more test cases
- login credentials
- data that is passed from one microservice to another
- file that has to be transferred to another machine
- etc.

## Positive & Negative Testing
Positive testing is using test data that conforms to requirements and using it in your tests to verify that the expected outcome is achieved

On the flip side, Negative testing is using test data that does not conform to requirements and using it in your tests to verify that the expected outcome is achieved

Sometimes these two paths of testing are called Happy Path (positive) and Sad Path (negative) testing.

## Verification vs Validation
The process of Verification is used to check that a product or service has been built correctly. This processes typically involves unit, integration, and system testing. 

The process of Validation is used to check that the right product or service has been built. Validation tends to be handled by acceptance testing and by engaging with the end client

## Test Objective
A Test Objective is the goal of your testing: this can be to verify that an application has been built to meet all requirements, to validate the product meets the client's desires, to confirm that a software environment is correctly configured to host an application, etc. 

## Test Object
If a Test Objective is the overarching goal of your testing, a Test Object is the individual thing you are currently testing, or have tested. You will typically have many Test Objects throughout the course of working on a project or application.

## Test Suite
As testing work progresses and the number of Test Cases increases it become necessary to organize your testing work into logical groupings: these groupings of Test Cases are called Test Suites.

## User Story
If a Use Case is a high level description of one or more requirements, User Stories are how you can narrow the focus of your testing in to individual scenarios using a technology agnostic language. This allows for User Stories to be utilized by more than just the testing/development team: the marketing team can use User Stories to pitch the product to potential clients, the C levels can use User Stories to inform shareholders of what the company is working on, etc. For our purposes, we will be using Gherkin syntax to create the scenarios (called Acceptance Criteria) for User Stories