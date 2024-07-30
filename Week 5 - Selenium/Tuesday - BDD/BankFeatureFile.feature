# Similar to how an Epic in Jira can be broad or narrow in the collection of Stories it
# covers, Features work the same way. The Broader the feature, the more User Stories you
# can store under it, but you lose a level of specificity of you go too broad.
Feature: Bank Users should be able to access their account securly
    # Because the Scenario and Scenario Outline share a starting step (getting to the login
    # page) we can make use of a Background section to place the step so that we only need
    # to define the step one time, and it can be used in all Scenarios
    Background: Shared login starting Given statement
        Given   The user is on the login page
    # Scenarios are similar to User Stories: for the purposes of a Scenario you can make
    # a one to one correlation, or you can make your Scenarios more broad
    Scenario: Users with valid credentials should be able to log in
        When    The user enters a valid Username
        When    The user enters a valid Password
        When    The user clicks the "login" button
        Then    The user should be redirected to the Home page 

    Scenario Outline: Users with invalid credentials should not be able to log in
        When    The user enters <username>
        When    The user enters <password>
        When    The user clciks the "login" button
        Then    The user should not be logged in

    Example:
    |username|password|
    |taken|valid|
    |taken|too long|
    |too long|valid|
    |too long|too long|
    |valid|too long|