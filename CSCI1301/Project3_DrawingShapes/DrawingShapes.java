
/*
 * DrawingShapes.java 
 * Author: Cedric Amponsem 
 * Submission Date: 4/3/26
 *
 * Purpose: The program allows the user to input a specific length (or height)
 * of a shape given by the program like a rectangle, triangle, hexagon, octagon,
 * or a pentagon.
 */
import java.util.Scanner;

public class DrawingShapes {
    public static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter a shape: r t h o p");
        String shapeChoice = INPUT.nextLine();

        if (shapeChoice.equals("r")) { // RECTANGLE

            System.out.println("Enter a length");
            int length = INPUT.nextInt();
            DrawingShapes.checkLength(length); // Checks if length is greater than 1

            System.out.println("Enter a height");
            int height = INPUT.nextInt();
            DrawingShapes.checkHeight(height); // Checks if height is greater than 1

            System.out.println("Below is a " + length + " by " + height + " rectangle of *");
            // Code that creates RECTANGLE
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < length; j++) {
                    System.out.print("*");
                }
                System.out.print("\n");
            }

        } else if (shapeChoice.equals("t")) { // TRIANGLE

            System.out.println("Enter a length");
            int length = INPUT.nextInt();
            DrawingShapes.checkLength(length); // Checks if length is greater than 1

            System.out.println("Below is a triangle with two side lengths of " + length + " *");
            // Code that creates TRIANGLE
            for (int i = 1; i <= length; i++) {
                System.out.print(" ".repeat(length - i) + "*");
                for (int j = 1; j < i; j++) {
                    System.out.print("**");
                }
                System.out.print("\n");
            }

        } else if (shapeChoice.equals("h")) { // HEXAGON

            System.out.println("Enter a length");
            int length = INPUT.nextInt();
            DrawingShapes.checkLength(length); // Checks if length is greater than 1

            System.out.println("Below is a hexagon with side lengths of " + length + " *");
            // Code that creates HEXAGON
            for (int i = 1; i <= length; i++) {
                System.out.print(" ".repeat(length - i) + "*".repeat(length));
                for (int j = 1; j < i; j++) {
                    System.out.print("**");
                }
                System.out.print("\n");
            }

            for (int i = length - 1; i > 0; i--) {
                System.out.print(" ".repeat(length - i) + "*".repeat(length));
                for (int j = 1; j < i; j++) {
                    System.out.print("**");
                }
                System.out.print("\n");
            }

        } else if (shapeChoice.equals("o")) { // OCTAGON

            System.out.println("Enter a length");
            int length = INPUT.nextInt();
            DrawingShapes.checkLength(length); // Checks if length is greater than 1

            System.out.println("Below is an octagon with side lengths of " + length + " *");
            // Code that creates OCTAGON
            for (int i = 1; i <= length; i++) {
                System.out.print(" ".repeat(length - i) + "*".repeat(length));
                for (int j = 1; j < i; j++) {
                    System.out.print("**");
                }
                System.out.print("\n");
            }

            for (int i = 1; i < length; i++) {
                System.out.print("*".repeat(length));
                for (int j = 1; j <= length - 1; j++) {
                    System.out.print("**");
                }
                System.out.print("\n");
            }

            for (int i = length - 1; i > 0; i--) {
                System.out.print(" ".repeat(length - i) + "*".repeat(length));
                for (int j = 1; j < i; j++) {
                    System.out.print("**");
                }
                System.out.print("\n");
            }

        } else if (shapeChoice.equals("p")) { // PENTAGON

            System.out.println("Enter a length");
            int length = INPUT.nextInt();
            DrawingShapes.checkLength(length); // Checks if length is greater than 1

            System.out.println("Below is a pentagon with 4 side lengths of " + length + " *");
            // Code that creates PENTAGON
            for (int i = 1; i <= length; i++) {
                System.out.print(" ".repeat(length - i) + "*");
                for (int j = 1; j < i; j++) {
                    System.out.print("**");
                }
                System.out.print("\n");
            }
            for (int i = 0; i < length - 1; i++) {
                for (int j = 0; j < 2 * length - 1; j++) {
                    System.out.print("*");
                }
                System.out.print("\n");
            }

        } else { // If user's input is invalid
            System.out.println("Invalid shape");
            System.out.println("Goodbye!");
        }

    } // main

    public static void checkLength(int length) {
        if (!(length > 1)) {
            System.out.println("Length must be greater than 1");
            System.out.println("Goodbye!");
            System.exit(0);
        }
    } // checkLength

    public static void checkHeight(int height) {
        if (!(height > 1)) {
            System.out.println("Height must be greater than 1");
            System.out.println("Goodbye!");
            System.exit(0);
        }
    } // checkHeight

}
