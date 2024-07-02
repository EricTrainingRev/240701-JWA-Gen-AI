package types.references;

/*
    Arrays are the most basic data structure you can use in Java to store
    your information. They are simply containers that can be used to
    save information and then access it at a later time

    There are a couple different ways you can declare your arrays:
        - int[] variableName = {value one, value two, etc}
        - int[] variableName = [3]

    couple of features about arrays:
        - once created, an array can not change its size
            - if you make an array with 4 spaces inside, and then
              realize you need 5 spaces, you have to make an entirely
              new array: you can't change the size of the initial array
        - arrays store their elements in sequence in memory
            - this localizes all the data, which can make accessing
              the elements in the array very quick, because the index
              position is all you need to know how to access the resource
 */

public class ArrayExample {
    public static void main(String[] args) {
        // this creates a new array with pre-determined data
        int[] evenNumbers = {2,4,6,8};

        // this creates an array without pre-determined data
        int[] notSetElements = new int[4];

        // to adjust the data in an index position you reference the
        // index and adjust the value
        notSetElements[0] = 10;

        // if you do a print on an array directly you get a memory location
        System.out.println(evenNumbers);

        // if you do a print on an index position you get a print of the data
        System.out.println(notSetElements[0]);
    }
}
