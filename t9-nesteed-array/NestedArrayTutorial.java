public class NestedArrayTutorial {
    public static void main(String[] args) {
        int size = 5;

        // Nested loops can be used to print shapes.
        // The outer loop controls the rows.
        // The inner loop controls how many stars are printed in each row.

        // SHAPE 1: Rectangle
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        // Shape printed: A
        // * * * * *
        // * * * * *
        // * * * * *
        // * * * * *
        // * * * * *

        System.out.println();

        // SHAPE 2: Left-aligned increasing triangle
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        // Shape printed: B
        // *
        // * *
        // * * *
        // * * * *
        // * * * * *

        System.out.println();

        // SHAPE 3: Left-aligned decreasing triangle using an increasing outer loop
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size - i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        // Shape printed: C
        // * * * * *
        // * * * *
        // * * *
        // * *
        // *

        System.out.println();

        // SHAPE 4: Right-aligned increasing triangle
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size - i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        // Shape printed: D
        //         *
        //       * *
        //     * * *
        //   * * * *
        // * * * * *

        System.out.println();

        // SHAPE 5: Right-aligned decreasing triangle
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i - 1; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= size - i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        // Shape printed: E
        // * * * * *
        //   * * * *
        //     * * *
        //       * *
        //         *
    }
}