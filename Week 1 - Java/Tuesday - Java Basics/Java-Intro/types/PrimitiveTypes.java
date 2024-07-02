package types;

public class PrimitiveTypes {
    /*
        In Java you have a multitude of built-in data "types" yo
        can work with. The most basic of this data is your primitives.
        These are the most foundational building blocks which you can
        use to create resources in your code
     */

    // Numeric whole number primitives
    byte byteData;
    short shortData;
    int  intData; // for our purposes int will usually suffice
    long longData;

    // Numeric floating point value primitives
    // an extra step for making float data is adding an "f" to the end of the number
    float floatData; // for our purposes float will usually suffice
    double doubleData;

    // represents individual characters
    char charData;

    // logical true/false
    boolean ultimateTruthAboutTheUniverse;

    public static void main(String[] args) {
        PrimitiveTypes defaultExample = new PrimitiveTypes();
        // default values
        System.out.println(defaultExample.byteData); // 0
        System.out.println(defaultExample.shortData); // 0
        System.out.println(defaultExample.intData); // 0
        System.out.println(defaultExample.longData); // 0
        System.out.println(defaultExample.floatData); // 0.0
        System.out.println(defaultExample.doubleData); // 0.0
        System.out.println(defaultExample.charData); // NUL ASCII character (unicode '\u0000')
        System.out.println(defaultExample.ultimateTruthAboutTheUniverse); // false
    }
}
