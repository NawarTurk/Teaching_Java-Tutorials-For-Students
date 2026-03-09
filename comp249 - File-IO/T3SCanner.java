import java.io.*;
import java.util.*;

public class T3SCanner {

	public static void main(String[] args) throws FileNotFoundException {
		
		/*
		Scanner can read from either:

		Scanner sc = new Scanner(new File("myText0.txt")); 
		// Scanner internally opens the stream.

		Scanner sc = new Scanner(new FileInputStream("myText0.txt")); 
		// Here we explicitly open the stream and pass it to Scanner.

		Both work, but the first is simpler and more common.
		*/

		PrintWriter out = new PrintWriter("myText0.txt");
		out.print(1);
		out.print("              ");
		out.println(2);
		out.print(3);
		out.print("              ");
		out.println(4);
		out.print("Hello, World!");
		out.close();
		
		Scanner in = new Scanner(new File("myText0.txt")); 
//		Scanner in = new Scanner(new FileInputStream("myText0.txt"));
		int myInt1 = in.nextInt();
		int myInt2 = in.nextInt();
		int myInt3 = in.nextInt();
		int myInt4 = in.nextInt();
//		int myInt5 = in.nextInt(); // java.util.InputMismatchException
		// There is input, but it is not the expected type
		in.nextLine();
		String myline = in.nextLine();
//		int myIntFinal = in.nextInt();// java.util.NoSuchElementException
// Scanner reached end of input and there is nothing left to read
		in.close();

		System.out.println(myInt1);
		System.out.println(myInt2);
		System.out.println(myInt3);
		System.out.println(myInt4);
		System.out.println(myline);




		
		
		
		


		
		

	}

}
