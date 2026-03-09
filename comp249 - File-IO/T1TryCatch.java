import java.io.*;

public class T1TryCatch {

	public static void main(String[] args) {
		PrintWriter out = null;

		try {
			out = new PrintWriter(
					new BufferedWriter(
							new FileWriter("myText2.txt", true)));
//							new FileWriter("src/myText2.txt", true)));
//							new FileWriter("src2/myText2.txt", true)));


		} catch (IOException e) {
			System.out.println("Error Opening the File");
			System.exit(0);
		} finally {
			if (out != null)
				out.close();
					
		}

	}

}
