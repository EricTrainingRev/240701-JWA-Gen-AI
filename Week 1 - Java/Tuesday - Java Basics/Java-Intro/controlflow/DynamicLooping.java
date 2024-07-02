package controlflow;

/*
    Typically you are not going to be able to hard code all the information
    your application needs into the base source code. Sooner or later some form
    of user input or data transformation will need to happen. This input and/or transformation
    is typically going to be what controls your application execution
 */
public class DynamicLooping {
    public static void main(String[] args) {
        /*
            Imagine you are implementing some form of username authentication for an application:
                - usernames need to be 5-15 characters long
                - usernames need to be unique
            Instead of manually checking every possible username combination between 5-15
            characters, we can make the check dynamic instead using variables

            the example below shows how you can use your various control flow options together
            to control the execution of your application
         */

        // these are just test usernames to check unique validation
        String[] takenUsernames = {"superUser75", "IlovePizza", "VeggieLife"};
        // you can change the newUsername value to change the output of the application
        String newUsername = "newuser123";

        // check if length is incorrect
        boolean usernameCorrectLength = true; // this variable will control whether we check the uniqueness of the username
        if(newUsername.length() < 5 && newUsername.length() > 15){
            // give an error message specific for the length and set the boolean controlling the
            // second check to false
            System.out.println("Username incorrect length, please make it 5-15 characters");
            usernameCorrectLength = false;
        }
        // this block will only execute if the length of the username is correct
        if (usernameCorrectLength){
            boolean usernameTaken = false; // this variable will control whether to give a success or error message creating the new username
            // we only loop through the taken usernames if the new username is the correct length
            for(int x = 0; x < takenUsernames.length; x++){
                // use .equals() to compare string values
                if(newUsername.equals(takenUsernames[x])){
                    usernameTaken = true;
                    // break can be used to terminate a loop: useful if you find what you need
                    // in early iterations of your loop and you don't need to run the whole thing
                    break;
                }
            }
            // give an error message if the username is taken, otherwise welcome the new user
            if(usernameTaken){
                System.out.println("Username must be unique, please try again");
            } else {
                System.out.println("Welcome new user " + newUsername);
            }
        }




    }
}
