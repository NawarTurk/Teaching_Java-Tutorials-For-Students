import java.io.*;
import java.util.*;

public class T6CompareScannerBuffered {

	public static void main(String[] args) throws IOException {

		/*
		Class           | Reads what              | Main methods used                                   | Type conversion needed?        | Behavior on invalid input
		-------------------------------------------------------------------------------------------------------------------------------
		Scanner         | Tokens from text        | nextInt(), nextDouble(), nextBoolean(), next()      | No (automatic)                 | Throws exception
		BufferedReader  | Characters / lines      | read(), readLine()                                  | Yes (parseInt, parseDouble...) | You handle conversion
		*/

		// create the file
		PrintWriter out = new PrintWriter("data.txt");
		out.println("10 3.14 true hello");
		// test this
//		 out.println("10 3.14 trrue hello");

		out.close();

		// -------- reading with Scanner --------
		Scanner sc = new Scanner(new File("data.txt"));

		int i = sc.nextInt();
		double d = sc.nextDouble();
		boolean b = sc.nextBoolean();
		String s = sc.next();

		System.out.println("Scanner:");
		System.out.println(i + " " + d + " " + b + " " + s);

		sc.close();

		// -------- reading with BufferedReader --------
		BufferedReader br = new BufferedReader(new FileReader("data.txt"));

		String line = br.readLine();
		String[] parts = line.split(" ");

		int i2 = Integer.parseInt(parts[0]);
		double d2 = Double.parseDouble(parts[1]);
		boolean b2 = Boolean.parseBoolean(parts[2]);
		String s2 = parts[3];

		System.out.println("BufferedReader:");
		System.out.println(i2 + " " + d2 + " " + b2 + " " + s2);

		br.close();
	}
}