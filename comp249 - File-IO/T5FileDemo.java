import java.io.*;

public class T5FileDemo {

    public static void main(String[] args) {

        try {
            // Creating a PrintWriter also creates the actual file on disk if it does not exist
            PrintWriter writer = new PrintWriter("src/sample.txt");
            writer.println("Hello from Java");
            writer.println(12345);
            writer.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not create the file.");
        }

        // Using File methods on a file that exists on disk
        System.out.println("Using File methods on a file that exists on disk");
        File realFile = new File("src/sample.txt");

        if (realFile.exists())
            System.out.println("sample.txt exists");
        else
            System.out.println("sample.txt does not exist");

        System.out.println("Name: " + realFile.getName());
		System.out.println("Parent: " + realFile.getParent());
        System.out.println("Path: " + realFile.getPath());
        System.out.println("Absolute path: " + realFile.getAbsolutePath());
        System.out.println("Can read: " + realFile.canRead());
        System.out.println("Can write: " + realFile.canWrite());
        System.out.println("Length: " + realFile.length());

        if (realFile.isFile())
            System.out.println("It is a file");
        else if (realFile.isDirectory())
            System.out.println("It is a directory");

        
        System.out.println("\n\nUsing File methods on a file that does NOT exist on disk");

        // Using File methods on a file that does NOT exist on disk
        File missingFile = new File("ghost.txt");

        if (missingFile.exists())
            System.out.println("ghost.txt exists");
        else
            System.out.println("ghost.txt does not exist");

        System.out.println("Can read: " + missingFile.canRead());
        System.out.println("Can write: " + missingFile.canWrite());
    }
}