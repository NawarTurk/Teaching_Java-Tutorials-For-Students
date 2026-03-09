import java.io.*;
public class T2ThrwosFileNotFoundClass {

	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter outputStream = new PrintWriter (new
		BufferedWriter(new PrintWriter ("stuff.txt")));
//		BufferedWriter(new PrintWriter ("src2/stuff.txt")));
		System.out.println("Writing to file.");
		outputStream.println("Hello");
		outputStream.println("World!");
		outputStream.close();
		System.out.println("End of program.");
	}

}
