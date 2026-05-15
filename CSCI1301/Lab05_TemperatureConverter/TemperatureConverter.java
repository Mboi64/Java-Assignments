
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
    public static final Scanner KEYBOARD = new Scanner(System.in);

    public static void main(String[] args) {

        // Declare named constants.

        final double MIN_FAHRENHEIT = -459.67;

        // Declare the variables.

        double fahrenheit;
        double convertedDegrees = 0;
        int tempScale;
        String tempScaleStr = "";

        System.out.print("Enter the temperature in Fahrenheit: ");
        fahrenheit = KEYBOARD.nextDouble(); // Set a breakpoint here

        // Verify the user's input
        if (fahrenheit < MIN_FAHRENHEIT) { // first if-statement: Set a breakpoint here
            System.out.print("The temperature must be greater than or equal to " + MIN_FAHRENHEIT);
            System.exit(0);
        }

        System.out.print("""
                         Enter the temperature scales you want to convert to:
                         1. Kelvin 
                         2. Rankine 
                         3. Reaumur 
                         4. Celsius
                         Enter a temperature scale: """);
        tempScale = KEYBOARD.nextInt();

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
            System.exit(0);
        }

        System.out.println(fahrenheit + " degrees Fahrenheit is " + convertedDegrees + " degrees "
            + tempScaleStr + ".");
    }
}