// Question: Write a program that reads a binary (.dat) file containing integers and finds
// the minimum and maximum values stored in it. Since DataInputStream does not return -1
// at end-of-file like text streams do, use EOFException to detect when all integers
// have been read. Handle the case where the file is empty.

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.EOFException;
import java.io.IOException;

public class BinaryMinMaxFinder {

    public static void main(String[] args) {

        DataInputStream in = null;
        int min = 0;
        int max = 0;
        boolean hasData = false;

        try {
            in = new DataInputStream(new FileInputStream("src2/inputQuestion2.dat"));

            int num = in.readInt();   // read first integer
            min = max = num;
            hasData = true;

            while (true) {
                num = in.readInt();

                if (num < min)
                    min = num;

                if (num > max)
                    max = num;
            }

        }
        // DataInputStream.readInt() does NOT return -1 when the file ends.
        // Instead it throws EOFException. We catch this exception to detect
        // that we reached the end of the file.
        catch (EOFException e) {
            if (!hasData) {
                System.out.println("The file is empty.");
                return;
            }
        }
        catch (IOException e) {
            System.out.println("Error reading the file.");
            return;
        }
        finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                System.out.println("Error closing the file.");
            }
        }

        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);
    }
}
