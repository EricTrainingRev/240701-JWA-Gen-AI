# Idea
Tic Tac Toe terminal game

# Requirement
Board displayed in terminal, user input for first and second player, win or tie message for end of game

# stretch goal 
make a single player version where app plays against you

# NOTE
The Scanner class can be used to take in user input
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // this reads input from the terminal
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("give the user a prompt");
            String userInput = scanner.nextLine(); // returns whatever the user enters into the terminal
            // do things with user input
        }
    }
}
```