# Use Case
- Id: 1
- Name: user registration
- Description: Users Should be able to register with the Bank
- System: Bank application
- Preconditions:
    - No registered user with username "Batman"
    - registered user with username "Robin"
- Actors:
    - User (creating a new account)
    - Bank application (handles the creation of the new account)

# Scenarios
**Positive Scenario**:
1. get to landing page
2. pick option to register
3. provide valid username
4. provide valid password
5. user should be registered with the bank

**Negative Scenario Username not unique**:
1. get to landing page
2. pick option to register
3. provide non-unique username
4. provide valid password
5. user should be informed registration failed

**Negative Scenario Username too long**:
1. get to landing page
2. pick option to register
3. provide too long username
4. provide valid password
5. user should be informed registration failed

**Negative Scenario Password too long**:
1. get to landing page
2. pick option to register
3. provide valid username
4. provide too long password
5. user should be informed registration failed

**Negative Scenario credentials too long**:
1. get to landing page
2. pick option to register
3. provide too long username
4. provide too long password
5. user should be informed registration failed

**Negative Scenario username taken and password too long**:
1. get to landing page
2. pick option to register
3. provide non-unique username
4. provide too long password
5. user should be informed registration failed

# Test Data
Positive:
- valid username = "Batman and Robin unite now!!!!"
- valid password = "Riddler and Joker disagree!!!!"

Negative:
- non-unique username = "Robin"
- too long username = "Gordon and Clark are friends!!!"
- too long password = "Reverse Flash strikes again!!!!"

## Decision Table
<table>
    <tr>
        <th>Scenario</th><th>Username</th><th>Password</th><th>result</th>
    </tr>
    <tr>
        <td>Positive Scenario</td><td>valid username</td><td>valid password</td><td>user registered</td>
    </tr>
    <tr>
        <td>Negative Scenario Username not unique</td><td>non-unique username</td><td>valid password</td><td>user not registered</td>
    </tr>
    <tr>
        <td>Negative Scenario Username too long</td><td>too long username</td><td>valid password</td><td>user not registered</td>
    </tr>
    <tr>
        <td>Negative Scenario Password too long</td><td>valid username</td><td>too long password</td><td>user not registered</td>
    </tr>
    <tr>
        <td>Negative Scenario credentials too long</td><td>too long username</td><td>too long password</td><td>user not registered</td>
    </tr>
    <tr>
        <td>Negative Scenario username taken and password too long</td><td>non-unique username</td><td>too long password</td><td>user not registered</td>
    </tr>
</table>

# Test Cases
|Test Case Id|Description|Preconditions|Test Data|Steps|Expected Outcome|Actual Outcome|Tester|Status|
|------------|-----------|-------------|---------|-----|----------------|--------------|------|------|
|1|given a valid username and password a user should be able to register with the bank|No registered user with username "Batman"|valid username, valid password|<ol><li>get to landing page </li><li>pick option to register </li><li>provide valid username</li><li>provide valid password</li><li>user should be registered with the bank</li></ol>|TBD|Alfred|In Progress|
|2|given a non unique username and valid password a user should not be able to register an account|registered user with username "Robin"|non-unique username, valid password|<ol><li>get to landing page </li><li>pick option to register </li><li>provide non-unique username</li><li>provide valid password</li><li>user should be informed the username is already taken</li></ol>|user not registered|TBD|Alfred|In Progress|
|3|given a too long username and valid password a user should not be able to register an account|N/A|too long username, valid password|<ol><li>get to landing page </li><li>pick option to register </li><li>provide too long username</li><li>provide valid password</li><li>user should be informed the username is too long</li></ol>|user not registered|TBD|Alfred|In Progress|
|4|given a valid username and too long password a user should not be able to register an account|N/A|valid username, too long password|<ol><li>get to landing page </li><li>pick option to register </li><li>provide valid username</li><li>provide too long password</li><li>user should be informed the password is too long</li></ol>|user not registered|TBD|Alfred|In Progress|
etc.