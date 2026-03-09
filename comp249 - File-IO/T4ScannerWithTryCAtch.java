
import java.io.*;
import java.util.*;

public class T4ScannerWithTryCAtch {

	public static void main(String[] args) {

		// -------- Writing to file --------
		try {
		    PrintWriter out = new PrintWriter("myText4.txt");

		    out.print(1);
		    out.print("              ");
		    out.println(2.4);

//		    int x = 10 / 0;  // ArithmeticException (division by zero)

		    out.print(3);
		    out.print("              ");
		    out.println(4);
		    out.print("Hello, World!");

		    out.close();
		    // If an exception happens before this line (like the division above),
		    // the file may remain open because close() is never reached.

		} catch (FileNotFoundException e) {
		    System.out.println("Error creating the file.");

		} catch (ArithmeticException e) {
		    System.out.println("Division by zero occurred.");
		}

		// -------- Reading from file --------

		// We initialize to null because we want to close it in finally.
		Scanner in = null;

		try {
			in = new Scanner(new FileInputStream("myText4.txt"));

			int myInt1 = in.nextInt();
			Double myInt2 = in.nextDouble();
			// int myInt2 = in.nextInt();

			int myInt3 = in.nextInt();
			int myInt4 = in.nextInt();

			// int myInt5 = in.nextInt(); // InputMismatchException

			in.nextLine();
			String myline = in.nextLine();

			// int myIntFinal = in.nextInt(); // NoSuchElementException

			System.out.println(myInt1);
			System.out.println(myInt2);
			System.out.println(myInt3);
			System.out.println(myInt4);
			System.out.println(myline);

		} catch (FileNotFoundException e) {
			System.out.println("File not found.");

		} catch (InputMismatchException e) {
			System.out.println("Input type mismatch (expected an integer).");

		} catch (NoSuchElementException e) {
			System.out.println("No more data to read.");

		} finally {
			if (in != null) {
				in.close();
			}
		}
	}
}