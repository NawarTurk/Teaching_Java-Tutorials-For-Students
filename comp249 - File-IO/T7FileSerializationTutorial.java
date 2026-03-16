/*

Checked exceptions note:
In this example we handle all checked exceptions by writing:

    public static void main(String[] args) throws Exception

However, the actual checked exceptions that may occur include:

FileNotFoundException
    - new PrintWriter("text.txt")
    - new Scanner(new File("text.txt"))
    - new FileInputStream("text.txt")
    - new FileOutputStream("person.dat")

IOException
    - new ObjectOutputStream(...)
    - new ObjectInputStream(...)
    - writeObject(...)
    - stream close operations

ClassNotFoundException
    - readObject()

Java File Access — Quick Comparison

Class                 Accepts File?   Accepts Stream?                 Example
----------------------------------------------------------------------------------------------
Scanner               yes             yes (InputStream)               new Scanner(new File("a.txt"))
                                                                  new Scanner(new FileInputStream("a.txt"))

ObjectOutputStream    no              yes (OutputStream)              new ObjectOutputStream(new FileOutputStream("a.dat"))

ObjectInputStream     no              yes (InputStream)               new ObjectInputStream(new FileInputStream("a.dat"))

Key idea:
File = just the path
Stream = the mechanism that actually reads/writes bytes
*/

import java.io.*;
import java.util.*;

class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    // Version number for the serialized class.
    // It helps Java verify that the class definition used to read the object
    // is compatible with the one used when the object was saved.

    String name;
    transient int age;
	 // transient means this variable will NOT be saved when the object is serialized.
	 // When the object is read back from the file, this field will not be restored.
	 // Instead, it will get the default value for its type (for int → 0).

    Person(String n, int age) {
        name = n;
        this.age = age;
        System.out.println("Greated a Person with name: " + name + " and age: " + age);
    }
}

public class T7FileSerializationTutorial {

    public static void main(String[] args) throws Exception {

        // -------------------------------------------------------
        // 1. Create a text file
        // -------------------------------------------------------

        PrintWriter pw = new PrintWriter("text.txt");
        // PrintWriter can open the file directly by name.
        // Internally it will create a FileOutputStream.
        // I could also explicitly use FileOutputStream or FileWriter,
        // but it is not required here.
        pw.println("hello world");
        pw.close();


        // -------------------------------------------------------
        // 2. Scanner using File
        // -------------------------------------------------------

        Scanner s1 = new Scanner(new File("text.txt"));
        // Scanner requires either:
        // new File("text.txt") OR new FileInputStream("text.txt")
        // because it needs something that provides input bytes.

        System.out.println("Scanner using File:");
        System.out.println(s1.next());
        s1.close();


        // -------------------------------------------------------
        // 3. Scanner using a stream
        // -------------------------------------------------------

        Scanner s2 = new Scanner(new FileInputStream("text.txt"));

        System.out.println("Scanner using FileInputStream:");
        System.out.println(s2.next());
        s2.close();


        // -------------------------------------------------------
        // 4. Writing an object (serialization)
        // -------------------------------------------------------

        ObjectOutputStream out =
            new ObjectOutputStream(new FileOutputStream("person.dat"));
        // ObjectOutputStream requires an OutputStream.
        // Therefore we must use FileOutputStream to connect it to the file.
        // FileOutputStream is the stream that actually writes bytes to the file.

        Person p = new Person("Alice", 89);

        out.writeObject(p); // Objects are saved in binary format,

        out.close();

        System.out.println("Object written to file.");


        // -------------------------------------------------------
        // 5. Reading the object back
        // -------------------------------------------------------

        ObjectInputStream in =
            new ObjectInputStream(new FileInputStream("person.dat"));

        Person p2 = (Person) in.readObject(); // you need to use a cast to convert an object to the apt type
        // readObject() can throw a (checked) ClassNotFoundException so you must catch it or declare it

        System.out.println("Object read from file: name: " + p2.name + " , age: " +  p2.age);

        in.close();


        // -------------------------------------------------------
        // 6. This would NOT work
        // -------------------------------------------------------

        // ObjectOutputStream out =
        //     new ObjectOutputStream(new File("person.dat")); // ERROR
        //
        // ObjectOutputStream requires an OutputStream,
        // and File is not an OutputStream.
    }
}