// Question: Write a program that reads a text file character by character using FileReader
// and counts how many characters are letters, digits, and special characters.
// Calculate the percentage of each type and write the results to a new text file
// called "insightsOfChars.txt" using PrintWriter.

import java.io.*;

public class CharacterTypeAnalyzer {

	public static void main(String[] args) {

		int letters = 0;
		int digits = 0;
		int special = 0;
		int total = 0;

		try {

			/*
			 * FileReader reads CHARACTERS (Unicode).
			 *
			 * It converts the bytes in the file into characters.
			 *
			 * Example Unicode values: A → 65 € → 8364 你 → 20320
			 *
			 * Alternative: We could also use FileInputStream:
			 *
			 * // FileInputStream fr = new FileInputStream("chars.txt");
			 *
			 * But FileInputStream reads BYTES, not characters.
			 *
			 * Some characters are stored in ONE byte (ASCII characters like A, 9, #), while
			 * other characters may be stored in MULTIPLE bytes (for example the Chinese
			 * character 你 is stored using 3 bytes in UTF-8).
			 *
			 * So with FileInputStream one character might require multiple reads(), while
			 * FileReader returns the full character in one read().
			 */

			FileReader fr = new FileReader("chars.txt");

			int ch;

			while ((ch = fr.read()) != -1) {
			    // fr.read() reads ONE character from the file and returns its numeric value.
			    // The return type is int, not char.

			    // If a character is read, fr.read() returns its Unicode value.
			    // Example:
			    // 'A'  → 65
			    // '9'  → 57
			    // '你' → 20320

			    // When the end of the file is reached, fr.read() returns -1.
			    // So -1 means: no more characters to read (End Of File / EOF).

			    // The loop continues while characters are still available.

				char c = (char) ch;
				System.out.println("Value: " + ch + " Character: " + c);

				if (Character.isLetter(c))
					letters++;
				else if (Character.isDigit(c))
					digits++;
				else
					special++;

				total++;
			}

			fr.close();

			double lettersP = Math.round((letters * 100.0) / total);
			double digitsP = Math.round((digits * 100.0) / total);
			double specialP = Math.round((special * 100.0) / total);

			PrintWriter out = new PrintWriter("insightsOfChars.txt");

			out.println("Letters: " + lettersP + "%");
			out.println("Digits: " + digitsP + "%");
			out.println("Special Characters: " + specialP + "%");

			out.close();

		} catch (IOException e) {
			System.out.println("File error.");
		}
		// note
		/*
		| Method                           | What it reads     | Return type | End-of-file signal    | Simple `read()` loop possible |
		| -------------------------------- | ----------------- | ----------- | --------------------- | ----------------------------- |
		| `FileReader.read()`              | characters        | `int`       | `-1`                  | Yes                           |
		| `FileInputStream.read()`         | bytes             | `int`       | `-1`                  | Yes                           |
		| `DataInputStream.readInt()`      | integer (4 bytes) | `int`       | throws `EOFException` | No                            |
		| `ObjectInputStream.readObject()` | object            | `Object`    | throws `EOFException` | No
		 */
	}

}
