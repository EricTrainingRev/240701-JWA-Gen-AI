# Bank Test Case Creation
Since this activity is based off P0, we will use the requirements of that project to determine what kind of testing we need to do. Based off the two different sets of requirements, Business and Software, the Business requirements are the actual actions and features a user should be able to accomplish in the application, and the Software requirements augment the Business side. This gives us direction in how to think about building and executing our tests: the Business requirements are what we are testing, the Software requirements augment how we perform the testing.

## Business Requirement: Users Should be able to register with the Bank
A useful way to organize your tests is by creating Use Cases for your requirements. For the purposes of testing that users can register with your bank application we can create a Use Case for the requirement:

Example Use Case:
- Id: 1
- Name: user registration
- Description: Users Should be able to register with the Bank
- System: Bank application
- Preconditions:
    - No registered user with username "Batman" (added after determining positive scenario data)
    - registered user with username "Robin" (forgot to add this precondition until writting up Negative scenario test cases)
- Actors:
    - User (creating a new account)
    - Bank application (handles the creation of the new account)

### Positive Scenario
For the Use case above, as currently designed, there are no provisions for validating the Software Requirements of the registration feature are being enforced. This is fine as long as we are focused on performing **Positive Testing**. When you create Positive Tests you are testing that, given valid input (meaning it conforms to any requirement constraints placed upon a feature) you get the expected output.

Now that we have organized the Test Case and have decided to focus on Positive Testing for the time being, we can start brainstorming scenarios for the Use Case. In our case, we need to think of the steps involved for the process of a new user registering themselves with the bank

Positive Use Case Scenario:
1. get to landing page
2. pick option to register
3. provide valid username
4. provide valid password
5. user should be registered with the bank

This particular feature we are building tests for has really only one positive scenario, so our work scenario building is done for now. Once you are happy with your scenarios it is time to start organizing your test data. For this Use Case and the positive scenario we determined above, we need to have a valid username and password we can use in order to perform any testing on the scenario:

Positive Use Case Scenario Data:
- valid username = "Batman"
- valid password = "I am the night"

**NOTE**: when we initially created our Use Case documentation we did not put any precondition information: now that we know that we need "Batman" to be a valid username, we have created a necessary precondition: there should be no registered users with the username of "Batman" in the system when testing this Positive scenario, so we need to go back and update the precondition with this information

We have our scenario, we have our test data, we are now ready to build our **Test Case**. A Test case is a collection of all relevant information about a singular test that needs to be executed or has been executed. Some common Test Case data points:
- Test Case Id
- Description
- Preconditions
- Test Data
- Steps
- Expected Outcome
- Actual Outcome
- Who executed the test
- Status

|Test Case Id|Description|Preconditions|Test Data|Steps|Expected Outcome|Actual Outcome|Tester|Status|
|------------|-----------|-------------|---------|-----|----------------|--------------|------|------|
|1|given a valid username and password a user should be able to register with the bank|No registered user with username "Batman"|valid username = "Batman", valid password = "I am the night"|1. get to landing page 2. pick option to register 3. provide valid username 4. provide valid password 5. user should be registered with the bank|User should be informed their account was created|TBD|Alfred|In Progress|

### Negative Scenarios
Everything we have set up so far has been assuming that things work as intended, and that the end user behaves as expected, but the sad reality of software work is you can't assume the end user is always going to conform to your application requirements. With this in mind, we need to think about **Negative Tests** for our application: these are tests that validate whether, given invalid inputs or actions (data or actions that do not conform to our application requirements), the application handles these invalid inputs or actions as expected.

With this in mind, we can think of multiple scenarios where the Software requirements of the application are not met:

Negative Use Case Scenario Username not unique:
1. get to landing page
2. pick option to register
3. provide non-unique username
4. provide valid password
5. user should be informed the username is already taken

Negative Use Case Scenario Username too long:
1. get to landing page
2. pick option to register
3. provide too long username
4. provide valid password
5. user should be informed the username is too long

Negative Use Case Scenario Password too long:
1. get to landing page
2. pick option to register
3. provide valid username
4. provide too long password
5. user should be informed the password is too long

Negative Use Case Scenario credentials too long:
1. get to landing page
2. pick option to register
3. provide too long username
4. provide too long password
5. user should be informed username and password are too long

Negative Use Case Scenario username taken and password too long:
1. get to landing page
2. pick option to register
3. provide non-unique username
4. provide too long password
5. user should be informed registration failed

Similar to our Positive Scenario, once we have determined our Negative Scenarios we can start organizing the data we need to walk through the scenarios:

Negative Scenarios data:
- valid username = "Batman"
- valid password = "I am the night"
- non-unique username = "Robin"
- too long username = "Riddle Me This: I am three pronged, have a handle, and am often used with dinner. What time is it?"
- too long password = "Riddle Me This: I like to wag my tail when I am happy and bark at the mailman: what is for breakfast?"

Now that we have multiple scenarios with multiple combinations of valid and invalid data, we need a way of keeping track of what the intended output is for the data (success, failure, specific failure message, etc). One way of organizing your data is to create a **Decision Table**. A Decision Table is just a table that lists the data used in a scenario and the expected result of using the data in the given combination.
<table>
    <tr>
        <th>Scenario</th><th>Username</th><th>Password</th><th>result</th>
    </tr>
    <tr>
        <td>Positive Use Case Scenario</td><td>valid username</td><td>valid password</td><td>user registered</td>
    </tr>
    <tr>
        <td>Negative Use Case Scenario Username not unique</td><td>non-unique username</td><td>valid password</td><td>user not registered</td>
    </tr>
    <tr>
        <td>Negative Use Case Scenario Username too long</td><td>too long username</td><td>valid password</td><td>user not registered</td>
    </tr>
    <tr>
        <td>Negative Use Case Scenario Password too long</td><td>valid username</td><td>too long password</td><td>user not registered</td>
    </tr>
    <tr>
        <td>Negative Use Case Scenario credentials too long</td><td>too long username</td><td>too long password</td><td>user not registered</td>
    </tr>
    <tr>
        <td>Negative Use Case Scenario username taken and password too long</td><td>non-unique username</td><td>too long password</td><td>user not registered</td>
    </tr>
</table>

Keep in mind when building your own decision tables that it is simply an organizational tool meant to help streamline and increase understanding of what test data goes with each scenario and what the expected outcome of the combination of data should produce. Make sure when creating your own decision tables that you organize them in ways that make sense to you and your team, and follow organizational requirements when present.

Now that our scenarios are created and our test data is organized we can start writting our test cases for the Negative scenarios

|Test Case Id|Description|Preconditions|Test Data|Steps|Expected Outcome|Actual Outcome|Tester|Status|
|------------|-----------|-------------|---------|-----|----------------|--------------|------|------|
|2|Negative Use Case Scenario Username not unique|registered user with username "Robin"|non-unique username	valid password|1. get to landing page 2. pick option to register 3. provide non-unique username 4. provide valid password 5. user should be informed the username is already taken|user not registered|TBD|TBD|Needs to be Assigned|
|3|Negative Use Case Scenario Username too long|N/A|too long username valid password|1. get to landing page 2. pick option to register 3. provide too long username 4. provide valid password 5. user should be informed the username is too long|user not registered|User was registered despite username being too long|Alfred|Defect Report needs to be created|
|4|Negative Use Case Scenario Password too long|N/A|valid username too long password|1. get to landing page 2. pick option to register 3. provide valid username 4. provide too long password 5. user should be informed the password is too long|user not registered|User was given success message but user was not actually registered|Alfred|Defect Report Generated|
etc.

Note the Test Cases created above have a combination of generic and specific information: unless your organization has specific requirements for how detailed you need to be when writing your Test Cases you have freedom to organize your Test Cases in a way that makes the most sense to you and your team.