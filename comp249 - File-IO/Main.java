import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		/*
		Class              Stream type        Accepts directly                  SOME OF THE Main methods used                                   Can append?                            Resulting file
		-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		PrintWriter        character stream   text, numbers, objects            print(), println(), printf()                         No (needs FileWriter/FileOutputStream) readable text
		
		FileWriter         character stream   characters / text                  write(int)*,  write(String)                        Yes: new FileWriter(file,true)         readable text
		                                                           			// int interpreted as Unicode character (0–65535)

		FileOutputStream   byte stream        bytes / numbers (0–255)            write(int), ...............                         Yes: new FileOutputStream(file,true)   raw bytes (may look binary)
		                                                           			// values written as single byte 
		                                                           			/// (ASCII range commonly 0–127, byte range 0–255)

		DataOutputStream   byte stream        Java primitive data types          writeInt(), writeDouble(), writeBoolean(),          Yes (via FileOutputStream)             structured binary data
		                                                                      writeChar(), writeUTF(), writeFloat()
		*/

		PrintWriter out1 = new PrintWriter("text1.txt");
		out1.println("\n\n\ninitial values");
		out1.print(29.95);
		out1.print(10);
		out1.close();

		PrintWriter out2 = new PrintWriter("text1.txt");
//		PrintWriter out2 = new PrintWriter(
//				new FileOutputStream("text1.txt"));
		out2.println("\n\n\nnew values");
		out2.print(1010);
		out2.print(999);
		out2.close();
		
		PrintWriter out4 = new PrintWriter(
				new FileWriter("text1.txt"));
		out4.print("hello from the other side");
		out4.close();
		
	
		PrintWriter out3 = new PrintWriter(new FileOutputStream("text1.txt", true));
		out3.println("\n\n\naddition al values");
		out3.print(10);
		out3.close();
		
		
		PrintWriter out5 = new PrintWriter(
				new FileWriter("text1.txt", true));
		out5.print("hello from the other side");
		out5.close();
		
        FileOutputStream fos = new FileOutputStream("binary1.dat");  // .dat by convention
        fos.write(65);   // byte value 65 → 'A'
        fos.write(66);   // byte value 66 → 'B'
        fos.write(97);   // byte value 97 → 'a'
        fos.write(200);  // not a printable character
        fos.close();
        

		FileWriter fw = new FileWriter("file.txt");
		// u can append with fw
//		FileWriter fw = new FileWriter("file.txt", true);
		fw.write("test");
		fw.write(97); // writes the character 'a' (Unicode/ASCII code 97)
		fw.write(String.valueOf(97));
		fw.close();
		
		// ADDITIONAL
		// -------- DataOutputStream example --------
//		DataOutputStream dos =
//		        new DataOutputStream(new FileOutputStream("data.dat"));
//
//		dos.writeInt(10);        // writes an int
//		dos.writeDouble(3.14);   // writes a double
//		dos.writeBoolean(true);  // writes a boolean
//		dos.writeChar('A');      // writes a char
//		dos.writeUTF("hello");   // writes a string
//		dos.close();

	}

}
