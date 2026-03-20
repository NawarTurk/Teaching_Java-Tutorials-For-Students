// Question: Write a program that reads 10 integers from the user and stores them in a binary
// (.dat) file using DataOutputStream. Then, read the file back using DataInputStream and compute:
// (1) the average of all even integers, and (2) the sum of all odd integers.
// Write both results to a separate binary output file, and display them on the screen.

import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class EvenOddBinaryStats {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        DataOutputStream out = null;

        try {
            out = new DataOutputStream(new FileOutputStream("inputQuestion2.dat"));

            System.out.println("Enter ten integers:");

            for (int i = 0; i < 10; i++) {
                int num = input.nextInt();
                out.writeInt(num);
            }

        } catch (IOException e) {
            System.out.println("Error writing the input file.");
        } finally {
			try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
                System.out.println("Error closing output file.");
            }
        }


        int evenSum = 0;
        int evenCount = 0;
        int oddSum = 0;

        DataInputStream in = null;

        try {
            in = new DataInputStream(new FileInputStream("inputQuestion2.dat"));

            for (int i = 0; i < 10; i++) {
                int num = in.readInt();

                if (num % 2 == 0) {
                    evenSum += num;
                    evenCount++;
                } else {
                    oddSum += num;
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the input file.");
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                System.out.println("Error closing input file.");
            }
        }


        double averageEven = (evenCount > 0) ? (double) evenSum / evenCount : 0;

        DataOutputStream out2 = null;

        try {
            out2 = new DataOutputStream(new FileOutputStream("outputQuestion2.dat"));

            out2.writeDouble(averageEven);
            out2.writeInt(oddSum);

        } catch (IOException e) {
            System.out.println("Error writing the output file.");
        } finally {
            try {
                if (out2 != null)
                    out2.close();
            } catch (IOException e) {
                System.out.println("Error closing output file.");
            }
        }

        input.close();

        System.out.println("Average of even integers: " + averageEven);
        System.out.println("Sum of odd integers: " + oddSum);
    }
}
