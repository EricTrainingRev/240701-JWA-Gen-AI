package controlflow;

/*
    Looping is how we make it so our code continues to run as long as we need it to without
    ending once all operations have executed once.
 */
public class Looping {
    public static void main(String[] args) {
        /*
            A common way to loop your code a specific number of times is to make a for loop. This
            allows you to have fine-tuned control over how many times you want your code to execute

            Inside your for statement you can:
                - initialize a control variable
                - set the logical condition that controls how long the loop continues
                - change the value of the control variable once an iteration of the loop finishes execution
         */
        for(int x =0; x <= 10; x++){
            System.out.println(x);
        }

        /*
            If you want your code to loop for an indeterminate amount of times a while loop
            is a good option
         */
        int y = 0;
        while(y <= 10){
            System.out.println(y);
            y++;
        }
        /*
            If you need to make your while loop execute at least one time you can make it a
            do while loop. This makes the logic check happen at the end of the loop, not the start
         */
        int z = 100;
        do {
            System.out.println(z);
            z++;
        } while (z <= 10);
    }
}
