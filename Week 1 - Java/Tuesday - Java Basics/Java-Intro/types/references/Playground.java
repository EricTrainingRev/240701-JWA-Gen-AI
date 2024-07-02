package types.references;

public class Playground implements InterfaceExample{

    @Override
    public void shareGreeting() {
        /*
            because this method is abstract in the interface we have
            to implement it here. Also, because the interface provides
            access to the greeting field we can reference it in this
            method without needing to do any other work!
         */
        System.out.println(greeting);
    }

    public static void main(String[] args) {
        Playground playgroundObject = new Playground();
        playgroundObject.shareGreeting();
        playgroundObject.defaultMethod();
    }
}
