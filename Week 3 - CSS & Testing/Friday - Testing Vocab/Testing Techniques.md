# Testing Techniques
Listed below are some common testing techniques and when to use them

## Use Case Testing
When performing Use Case Testing you take requirements and turn them into "use cases". This provides a framework for organizing scenarios, test data, and then building Test Cases from your organized data to be executed. This is a catch all strategy that can be utilized with just about any kind of testing requirement. 

## Black Box & White Box testing
Whenever you test an application without access to the source code you are performing Black Box testing. This is very common when manual testing an application before it is released to end users. This kind of testing is common in system and acceptance testing

Whenever you test an application with access to the source code you are performing White Box testing. This kind of testing is typically required when performing unit and integration testing, but it can also include system and acceptance testing

Knowing whether you are performing Black or White box testing can help you to determine the scope of testing that is expected from you.

## State Transition Diagram
Any time you have an application that tracks the "state" of a resource, such as reimbursement request, PTO request, defect report, really anything that can change from one "state" to another, you can create a State Transition Diagram to represent the possible changes, and therefore, the number of tests you need to create in order to verify that all requirements are met when transition between the possible states. 

## Decision Table
Whenever you have multiple pieces of Test Data that need to be tested in various combinations (think valid and invalid login credentials) you can organize the data into a Decision Table, which informs you of the expected outcome of combining the various pieces of data together.

## Boundary Analysis Testing
This is a strategy for organizing your Test Data: if you have one or more Test Objects that have requirements that create "boundaries" for data, such as minimum or maximum values, you can organize your data by creating "classes" that represent potential user input that goes up to and just past those boundaries. 

## Equivalence Partitioning
Similar to Boundary Analysis Testing, Equivalence Partitioning is a useful organizational tool when you have large categories with a high potential for a significant number of values you COULD test (think testing a calculator that should work with integer and floating values, both positive and negative). Instead of testing an arbitrary number of values of positive and negative integers and floating values, you pick a single value to represent each "class" of data (one positive int, one negative int, one positive float, one negative float). If a defect is revealed in any class, you assume that all values that are a part of that class would cause the same defect, and investigate appropriately.

## Error Guessing
This is a Black Box testing technique where the tester uses previous experience with a Test Object to determine what kinds of test should be run to return meaningful results based upon the given Test Objectives.

## Exploratory Testing
This is a White Box testing technique where the tester explores the code of an application to look for places where testing either is needed or has been missed, and should be implemented. 

## Checklist Testing
This form of testing involves having a list of actions that need to be performed to verify that requirements are being met.

## Statement Testing
This is a lower level testing technique where you verify that each "statement" of code in your application is working correctly. This kind of testing typically goes hand in hand with code coverage requirements.

## Conditional Testing
You can think of Conditional Testing as a way of organizing your test data in a collection of if-else statements: if given condition, expected response, else other expected response.

## Static Testing
Static Testing is verifying and validating that an application is doing what it is supposed to before executing any code. This kind of testing often helps to catch errors in the Quality Assurance practices of the development and testing team, and can help to prevent future errors from compounding.