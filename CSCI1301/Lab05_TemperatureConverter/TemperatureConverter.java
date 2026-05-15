
/**
 * TemperatureConverter.java 
 * Author: Cedric Amponsem 
 * Submission Date: 2/20/26
 *
 * Purpose: The program is suppose to allow the user to enter a temperature in
 * Fahrenheit and (utilizing a scale) converts it into different units of
 * temperatures such as Celcius, Reaumur, Rankine, and Kelvin. However, the
 * given program has many bugs and it is our job to debug any mishaps that may
 * occur in the code.
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither received nor given
 * inappropriate assistance. I have not copied or modified code from any source
 * other than the course webpage or the course textbook. I recognize that any
 * unauthorized assistance or plagiarism will be handled in accordance with the
 * University of Georgia's Academic Honesty Policy and the policies of this
 * course. I recognize that my work is based on an assignment created by the
 * School of Computing at the University of Georgia. Any publishing or posting
 * of source code for this assignment is strictly prohibited unless you have
 * written consent from the School of Computing at the University of Georgia.
 * 
 *
 *
 * This program does the following: Prompts the user to enter a temperature in
 * Fahrenheit and a temperature scale the user wants to convert it to. If both
 * the temperature in Fahrenheit and the temperature scale are valid, the
 * program converts the temperature in Fahrenheit to the specified temperature
 * scale and displays the converted value.
 *
 */

import java.util.Scanner;

public class TemperatureConverter {
    // Creating the Scanner object
    public static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        // Declare named constants.

        final double MIN_FAHRENHEIT = -459.67;

        // Declare the variables.

        double fahrenheit;
        double convertedDegrees = 0;
        int tempScale;
        String tempScaleStr = "";

        System.out.print("Enter the temperature in Fahrenheit: ");
        fahrenheit = keyboard.nextDouble(); // Set a breakpoint here

        // Verify the user's input
        if (fahrenheit < MIN_FAHRENHEIT) { // first if-statement: Set a breakpoint here
            System.out.print("The temperature must be greater than or equal to " + MIN_FAHRENHEIT);
            System.exit(0);
        }

        System.out.print("Enter the temperature scales you want to convert to:\n" + "1. Kelvin \n"
            + "2. Rankine \n" + "3. Reaumur \n" + "4. Celsius\n" + "Enter a temperature scale: ");
        tempScale = keyboard.nextInt();

        if ((tempScale >= 1) && (tempScale <= 4)) { // Second-if statement: Set a breakpoint here
            if (tempScale == 1) { // Set a breakpoint here
                convertedDegrees = (fahrenheit - MIN_FAHRENHEIT) * 5 / 9;
                tempScaleStr = "Kelvin";
            } else if (tempScale == 2) {
                convertedDegrees = fahrenheit - MIN_FAHRENHEIT;
                tempScaleStr = "Rankine";

            } else if (tempScale == 3) {
                convertedDegrees = (fahrenheit - 32) * 4 / 9; // Set a breakpoint here
                tempScaleStr = "Reaumur";

            } else if (tempScale == 4) {
                convertedDegrees = (fahrenheit - 32) * 5 / 9; // Set a breakpoint here

                tempScaleStr = "Celsius";
            }

        } else {
            System.out.println("Unknown temperature scale  -" + "  cannot do calculation. Bye");
            // System.exit(0);
        }

        System.out.println(fahrenheit + " degrees Fahrenheit is " + convertedDegrees + " degrees"
            + tempScaleStr + ".");
    }
}