package additional_null_reference;

/*
======================================================
   Tutorial: Object References (local, null, arrays)
======================================================
*/

/*
SUMMARY OF WHEN JAVA PRINTS null FOR OBJECT REFERENCES

1. Local object variable (inside a method):
   - Declaring it without assigning a value gives NO default.
   - You cannot print it because it is "not initialized".
       Car x;
       System.out.println(x);   // ERROR

2. Local variable explicitly assigned null:
   - If you assign null yourself, printing is allowed.
       Car x = null;
       System.out.println(x);   // prints null

3. Elements of an array of objects:
   - When you create an array of object references, every slot starts as null.
   - Printing any element works and prints null until you assign an object.
       Car[] garage = new Car[3];
       System.out.println(garage[0]);  // prints null

4. Instance variables (fields) inside a class:
   - Fields always get default values (null for object references).
   - Printing them works and shows null until you assign an object.
       class Holder { public Car car; }
       Holder h = new Holder();
       System.out.println(h.car);      // prints null
*/


public class ObjectReferencesDemo {

    public static void main(String[] args) {

        // ----------------------------------------
        // PART 1 - Local variable (NO default value)
        // ----------------------------------------

        // Car x;
        // System.out.println(x);   // ERROR: variable not initialized

        Car x = null;
        System.out.println(x);        // prints null



        // ----------------------------------------
        // PART 2 - Array of object references
        // ----------------------------------------
        Car[] garage = new Car[3];

        System.out.println(garage[0]);   // null
        System.out.println(garage[1]);   // null

        garage[0] = new Car();
        System.out.println(garage[0]);   // prints "Car object"



        // ----------------------------------------
        // PART 3 - Class field is auto-null
        // ----------------------------------------
        CarHolder holder = new CarHolder();

        // field 'car' has default value null
        System.out.println(holder.car);      // prints null

        holder.car = new Car();
        System.out.println(holder.car);      // prints "Car object"
    }
}
