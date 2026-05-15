/*
 * StarGraph.java
 * Author: Cedric Amponsem 
 * Submission Date: 3/26/26
 *
 * Purpose: This program allows the user to find and graph the x and y of the
 * function y = 20 * |sin x|. The user is able to input the minimum to maximum
 * length of the graph and x and y coordinates.
 */

import java.util.Scanner;

public class StarGraph {
    public static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Please enter the number of x values to process: ");
        int sizeN = INPUT.nextInt(); // Length of the array
        if (!(sizeN > 0)) {
            System.out.println("The number of x values must be an integer greater than 0.");
            System.exit(0);
        } // if statement

        System.out.print("Enter a minimum value for x: ");
        double xMin = INPUT.nextDouble(); // Minimum value of the x value

        System.out.print("Enter the amount to increment x: ");
        double xIncrement = INPUT.nextDouble(); // Increments of x for each value
        if (!(xIncrement > 0)) {
            System.out.println("The increment must be a decimal number greater than 0.");
            System.exit(0);
        } // if statement
        
        
        // Array setup
        double[] valueOfX = new double[sizeN];
        double[] valueOfY = new double[sizeN];

        System.out.println();
        
        // Values of x and y depending on user's input 
        System.out.println("Values");
        for (int i = 0; i < valueOfX.length; i++) {
            valueOfX[i] = xMin + (i * xIncrement);
            double y = 20 * Math.abs(Math.sin(valueOfX[i]));
            valueOfY[i] = y;
            System.out.printf("x: %.3f, y: %.3f\n", valueOfX[i], valueOfY[i]);
        } // for loop

        System.out.println();

        // Displays a graph of values
        System.out.println("Graph");
        for (int j = 0; j < sizeN; j++) {
            int result = (int) valueOfY[j];
            String stars = "*".repeat(result);
            System.out.println(":" + stars);
        } // for loop

    } // main

}
